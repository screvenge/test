package com.study.service.flow;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.AuditStrategyFactory;
import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.common.constants.ServiceId;
import com.study.message.flow.ApprovedReq;
import com.study.service.aspect.SendEmail;

@Service("approvedService")
public class ApprovedService implements IService<ApprovedReq, BaseRsp> {

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	@SendEmail(serviceId = ServiceId.ADD_CAR, msg = "发件人通过了审批")
	public BaseRsp doExcute(ApprovedReq req) throws Exception {
		AuditStrategyFactory.getInstance().getService(req.getServiceId()).approved(req.getBusId());
		return new BaseRsp();
	}
}
