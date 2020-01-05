package com.study.common.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.study.common.AccountUtil;
import com.study.common.BaseException;
import com.study.common.BeanValidator;

/**
 * 装饰器模式的converter
 * @author reborn
 *
 */
public class BaseConverterWrapper<T> implements HttpMessageConverter<T> {
	private final HttpMessageConverter<T> msgConverter;
	
	public BaseConverterWrapper(HttpMessageConverter<T> msgConverter) {
		this.msgConverter = msgConverter;
	}

	@Override
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		return msgConverter.canRead(clazz, mediaType);
	}

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		return msgConverter.canWrite(clazz, mediaType);
	}

	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return msgConverter.getSupportedMediaTypes();
	}

	@Override
	public T read(Class<? extends T> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		T target = msgConverter.read(clazz, inputMessage);
		fillHeaders(clazz, inputMessage, target);
		valid(target);
		return target;
	}

	@Override
	public void write(T t, MediaType contentType, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		msgConverter.write(t, contentType, outputMessage);
	}
	
	private void fillHeaders(Class<? extends T> clazz, HttpInputMessage inputMessage, T target) {
		HttpHeaders headers = inputMessage.getHeaders();
		if (clazz.getAnnotationsByType(Fill.class) != null) {
			Method[] methods = clazz.getMethods();
			if (ArrayUtils.isNotEmpty(methods)) {
				for (Method method : methods) {
					FillName fill = method.getAnnotation(FillName.class);
					if (null != fill) {
						List<String> list = headers.get(fill.name());
						if (CollectionUtils.isNotEmpty(list)) {
							try {
								method.invoke(target, list.get(0));
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	
	private void valid(T target) throws IOException {
		try {
			BeanValidator.getInstance().valid(target);
		} catch (BaseException e) {
			throw new IOException("param error");
		}
	}
}
