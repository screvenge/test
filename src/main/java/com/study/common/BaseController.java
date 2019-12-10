package com.study.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.alibaba.fastjson.JSON;
import com.study.common.constants.WorkFlow;
import com.study.common.workflow.IAuditReq;
import com.study.dao.FlowDao;
import com.study.model.FlowRecord;

public class BaseController {
	/**
	 * 工作流dao
	 */
	@Autowired
	private FlowDao flowDao;

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

	/**
	 * 不同于service做的事情 1.获取事务操作生成的主键id,根据id查询相应表的信息并赋值object模型
	 * (怎么查id,查怎么表都自己去重写,通过请求类实现IOperationReq==>获取id,自定义服务类实现OperationUtil==>查表信息)
	 * 2.set flowrecord模型的属性,然后插入到flowno表中
	 */
	@SuppressWarnings("unchecked")
	public <Q, P> P serviceWithOperation(IService<Q, P> iService, Q req, OperationUtil util) {
		try {
			P rsp = iService.doExcute(req);

			// 用事务管理器判断是否结束
			// https://blog.csdn.net/qq_31854907/article/details/102584154
			// 必须事务结束才能开始记录操作历史
			if (!TransactionSynchronizationManager.isSynchronizationActive() && req instanceof IOperationReq) {

				// 在运行时是IOperationReq的实现类请求对象
				IOperationReq iReq = (IOperationReq) req;

				// 查到了进行事务操作的指定id的相关表信息,赋值给object,具体查什么表,你自己去重写
				Long id = iReq.getId();
				Object context = util.query(id);

				// t_flow_no 表的java模型
				FlowRecord flow = new FlowRecord();
				flow.setBusId(id);
				flow.setBusType(iReq.getBusType());
				flow.setCacheData(JSON.toJSONString(context));
				flow.setFlowStatus(iReq.getFlowStatus());
				flow.setCreateUser(AccountUtil.getInstance().getAccount());
				
				// 如果是审批的工作流, 那么添加审批人
				if (req instanceof IAuditReq) {
					flow.setAuditUser(((IAuditReq) req).getAuditAccout());
					flow.setServiceId(((IAuditReq) req).getServiceId());
					flow.setIsCurrent(WorkFlow.IS_CURRENT);
					flow.setAuditStatus(WorkFlow.AuditStatus.AUDITING);
				} else {//不走审批则设置当前不为工作流,且设置auditstatus为0,表示操作历史
					flow.setIsCurrent(WorkFlow.IS_NOT_CURRENT);
					flow.setAuditStatus(WorkFlow.AuditStatus.OPERATION);
				}
				
				flowDao.addFlowRecord(flow);// 将查到的事务操作信息添加到t_flow_no表
			}
			// 返回响应
			return rsp;
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
