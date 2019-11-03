package com.study.common;

/**
 * @param <Q> 请求
 * @param <P> 响应
 */
public interface IService<Q, P> {
	P doExcute(Q req) throws Exception;
}
