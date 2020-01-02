package com.study.service.flow;

import com.study.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.AuditStrategyFactory;
import com.study.common.BaseRsp;
import com.study.common.IService;
import com.study.common.constants.ServiceId;
import com.study.message.flow.RejectedReq;
import com.study.service.aspect.SendEmail;

@Service("rejectedService")
public class RejectedService implements IService<RejectedReq, BaseRsp> {

	@Autowired
	private RoleService roleService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	@SendEmail(serviceId = ServiceId.ADD_CAR, msg = "发件人驳回了审批")
	public BaseRsp doExcute(RejectedReq req) throws Exception {

		roleService.checkAuthority(req.getJobNumber(), "reject");

		AuditStrategyFactory.getInstance().getService(req.getServiceId()).rejected(req.getBusId());
		return new BaseRsp();
	}
}
