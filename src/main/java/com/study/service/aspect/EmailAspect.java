package com.study.service.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.study.common.workflow.IAuditReq;

/**
 * AOP面向切面demo
 * 
 * @author reborn
 *
 */
@Component // 加入到IoC容器
@Aspect // 指定当前类为切面类
public class EmailAspect {
	/**
	 * 环绕通知方法
	 * 
	 * @param joinPoint 这个对象是必须要有的，因为你要在通知中通过它来调用被通知的方法。
	 */
	@Around("@annotation(com.study.service.aspect.SendEmail)")
	public Object watchPerformance(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		try {
			// 通知方法中可以做任何的事情，当要将控制权交给被通知的方法时，它需要调用该方法。
			// 如果不调用这个方法的话，那么你的通知实际上会阻塞对被通知方法的调用。
			// 有可能这就是你想要的效果，但更多的情况是你希望在某个点上执行被通知的方法。
			// 得到返回值,注解必须加入返回值,面向切面实际是返回该方法的值
			obj = joinPoint.proceed();
			// 获取方法,为了获取目标对象的方法对象（包括方法上的注解）
			Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

			// 获取代理的方法参数列表
			Object[] args = joinPoint.getArgs();
			
			// 默认读取的是接口,得到注解需要得到实现类
			if (method.getDeclaringClass().isInterface()) {
				// 获取代理的目标(原来本身的service)
				Object target = joinPoint.getTarget();
				// method = target.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
				Method[] methods = target.getClass().getDeclaredMethods();
				for (Method eachMethod : methods) {
					if (eachMethod.getName().equals(method.getName())) {
						SendEmail email = eachMethod.getAnnotation(SendEmail.class);

						if (null != email) {
							for (Object arg : args) {
								if (arg instanceof IAuditReq) {
									// 通过Http请求对接内部邮箱服务器
									EmailUtil.sendEmail(email.serviceId(), email.msg(), ((IAuditReq) arg).getAuditAccout());
									return obj;
								}
							}
						}
					}
				}
			}
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			System.out.println("throw exception");
		}

		return obj;
	}
}
