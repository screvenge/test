package com.study.service.car;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.BaseReq;
import com.study.common.BaseRsp;
import com.study.common.IService;

@Service("addCarService")
public class AddCarService implements IService<BaseReq, BaseRsp> {

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	public BaseRsp doExcute(BaseReq req) throws Exception {

		return new BaseRsp();
	}
}
