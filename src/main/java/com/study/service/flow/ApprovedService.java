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
import com.study.message.flow.ApprovedReq;
import com.study.service.aspect.SendEmail;

@Service("approvedService")
public class ApprovedService implements IService<ApprovedReq, BaseRsp> {

	@Autowired
	private RoleService roleService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
	@SendEmail(serviceId = ServiceId.ADD_CAR, msg = "发件人通过了审批")
	public BaseRsp doExcute(ApprovedReq req) throws Exception {

		roleService.checkAuthority(req.getJobNumber(), "approve");

		AuditStrategyFactory.getInstance().getService(req.getServiceId()).approved(req.getBusId());
		return new BaseRsp();
	}
}
