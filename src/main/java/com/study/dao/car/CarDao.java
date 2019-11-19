package com.study.dao.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.message.car.data.CarInfo;
import com.study.model.car.CarRecord;

public interface CarDao {
	List<CarRecord> queryCars();
	
	CarInfo queryCarById(@Param("id") Long id);
	
	int addCarRecord(CarRecord record);
}
