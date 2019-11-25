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
	public void addCarInfo(CarRecord carRecord);
	
	/**
	 * 根据牌照号查询carId ==> a_car_info 表
	 */
	public Long selectCarIdByLicense(@Param("licenseId") String licenseId, @Param("temLicense") String temLicense);
	
	/**
	 * 根据客户名查询客户id 
	 */
	public Long selectConsumerIdByName(@Param("consumerName")String consumerName);
	
	/**
	 * 根据carNO查询carId
	 */
	public Long searchCarIdByCarNo(@Param("carNo") String carNo);
	
	/**
	 * 根据车牌号查找车辆原始信息
	 */
	public CarRecord selectOneCarRecordByLicense(@Param("license") String license);
	
	/**
	 * 添加部件信息 ==> a_car_component 表
	 */
	public void addCarComponentInfo(CarComponent carComponent);
	
	/**
	 * 更新carinfo
	 */
	public void updateCarInfo(CarRecord carRecord);
	
	/**
	 * 添加repairInfo ==> a_car_repair 表
	 */
	public void addCarRepairInfo(CarRepair carRepair);
	
	/**
	 * 根据主键更新repairInfo ==> a_car_repair 表
	 */
	public void updateCarRepairInfo(CarRepair carRepair);
	
	/**
	 * 根据carId, component,修理时间为null,查询修理表
	 */
	public CarRepair selectCarRepairInfo(@Param("carId")Long carId, @Param("component")String component);
	
	/**
	 * 根据carid删除carInfo
	 */
	public void deleteCarInfoByCarId(@Param("carId")Long carId);
	
	/**
	 * 根据carId删除carComponentInfo
	 */
	public void deletecarComponentInfoByCarId(@Param("carId")Long carId);
	
	/**
	 * 根据carId删除carRepairInfo
	 */
	public void deletecarRepairInfoByCarId(@Param("carId")Long carId);
	
	/**
	 * 根据carNo模糊查询车辆信息
	 */
	public List<CarInfoOfOne> selectCarInfoByCarNo(@Param("carNo")String carNo);
	
	/**
	 * 根据repairId主键查询carrepair表
	 */
	public CarRepair selectCarRepairInfoByRepairId(@Param("repairId") Long repairId);
	
	/**
	 * 根据carId查询a_car_component 和 a_car_info 表
	 */
	public CarAndComponent selectCarAndComponentByCarId(@Param("carId")Long carId);
	
}
