package com.study.dao.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.message.car.data.CarAndComponent;
import com.study.message.car.data.CarInfo;
import com.study.message.car.data.CarInfoOfOne;
import com.study.model.car.CarComponent;
import com.study.model.car.CarRecord;
import com.study.model.car.CarRepair;

public interface CarDao {
	List<CarRecord> queryCars();
	
	CarInfo queryCarById(@Param("id") Long id);
	
	int addCarRecord(CarRecord record);
	
	/**
	 * 添加车辆信息 ==> a_car_info 表
	 */
	void addCarInfo(CarRecord carRecord);
	
	/**
	 * 根据牌照号查询carId ==> a_car_info 表
	 */
	Long selectCarIdByLicense(@Param("licenseId") String licenseId, @Param("temLicense") String temLicense);
	
	/**
	 * 根据客户名查询客户id 
	 */
	Long selectConsumerIdByName(@Param("consumerName")String consumerName);
	
	/**
	 * 根据carNO查询carId
	 */
	Long searchCarIdByCarNo(@Param("carNo") String carNo);
	
	/**
	 * 根据车牌号查找车辆原始信息
	 */
	CarRecord selectOneCarRecordByLicense(@Param("license") String license);
	
	/**
	 * 添加部件信息 ==> a_car_component 表
	 */
	void addCarComponentInfo(CarComponent carComponent);
	
	/**
	 * 更新carinfo
	 */
	void updateCarInfo(CarRecord carRecord);
	
	/**
	 * 添加repairInfo ==> a_car_repair 表
	 */
	void addCarRepairInfo(CarRepair carRepair);
	
	/**
	 * 根据主键更新repairInfo ==> a_car_repair 表
	 */
	void updateCarRepairInfo(CarRepair carRepair);
	
	/**
	 * 根据carId, component,修理时间为null,查询修理表
	 */
    CarRepair selectCarRepairInfo(@Param("carId")Long carId, @Param("component")String component);
	
	/**
	 * 根据carid删除carInfo
	 */
	void deleteCarInfoByCarId(@Param("carId")Long carId);
	
	/**
	 * 根据carId删除carComponentInfo
	 */
	void deletecarComponentInfoByCarId(@Param("carId")Long carId);
	
	/**
	 * 根据carId删除carRepairInfo
	 */
	void deletecarRepairInfoByCarId(@Param("carId")Long carId);
	
	/**
	 * 根据carNo模糊查询车辆信息
	 */
	List<CarInfoOfOne> selectCarInfoByCarNo(@Param("carNo")String carNo);
	
	/**
	 * 根据repairId主键查询carrepair表
	 */
	CarRepair selectCarRepairInfoByRepairId(@Param("repairId") Long repairId);
	
	/**
	 * 根据carId查询a_car_component 和 a_car_info 表
	 */
	CarAndComponent selectCarAndComponentByCarId(@Param("carId")Long carId);
	
	int updateAuditStatus(@Param("id") Long id, @Param("auditStatus") Integer auditStatus);
}
