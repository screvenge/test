package com.study.common;

public class BaseController {
	@SuppressWarnings("unchecked")
	public <Q, P> P service(IService<Q, P> iService, Q req) {
		try {
			return iService.doExcute(req);
		} catch (BaseException e) {
			BaseRsp rsp = new BaseRsp();
			rsp.setRetMsg(RetCodeFactory.getMsg(e.getRetCode(), ((BaseReq) req).getI18n()));
			rsp.setRetCode(e.getRetCode());
			return (P) rsp;
		} catch (Exception e) {
			e.printStackTrace();
			return (P) new BaseRsp(5, "error");
		}
	}
}
