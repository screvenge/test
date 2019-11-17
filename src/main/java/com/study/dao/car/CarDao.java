package com.study.dao.car;

import java.util.List;

import com.study.model.car.CarRecord;

public interface CarDao {
	List<CarRecord> queryCars();
}
