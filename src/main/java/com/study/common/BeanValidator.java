package com.study.common;

import javax.validation.Validation;
import javax.validation.Validator;

public class BeanValidator {
	private static final BeanValidator INSTANCE = new BeanValidator();
	
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	private BeanValidator() {
	}
	
	public static BeanValidator getInstance() {
		return INSTANCE;
	}
	
	public void valid(Object obj) throws BaseException {
		if (validator.validate(obj).isEmpty()) {
			return;
		}
		
		throw new BaseException(9999);
	}
}
