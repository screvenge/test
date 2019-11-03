package com.study.common.web;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Long2StringObjectMapper extends ObjectMapper {
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 5320908630298144949L;

	public Long2StringObjectMapper() {
		super();
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		registerModule(simpleModule);
		Jackson2ObjectMapperBuilder.json().configure(this);
	}
}
