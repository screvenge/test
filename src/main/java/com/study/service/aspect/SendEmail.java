package com.study.service.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解包含在javadoc中
@Documented 
//注解可以被继承
@Inherited
//注解的作用目标
@Target(ElementType.METHOD)
//注解的保留策略：SOURCE 注解仅存在于源码中，在class字节码文件中不包含
//CLASS默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得
//RUNTIME注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Retention(RetentionPolicy.RUNTIME)
public @interface SendEmail {
	public String serviceId();
	
	public String msg();
}
