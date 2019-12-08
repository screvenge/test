package com.study.task;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.common.AbstractTask;
import com.study.common.CloseUtil;
import com.study.common.FileUtil;
import com.study.dao.car.CarDao;
import com.study.model.car.CarRecord;

@Component("exportCarExcelTask")
public class ExportCarExcelTask extends AbstractTask {
	@Autowired
	private CarDao carDao;

	@Override
	public void mainWork() {
		List<CarRecord> cars = carDao.queryCars();
		if (CollectionUtils.isNotEmpty(cars)) {
			// 整个excel文件就是一个workbook工作簿
			// sheet是工作表
			// Row行
			// Cell列(单元格)
			
			// 通过POI导出excel
			// xls是HSSFWorkbook
			Workbook workbook = new XSSFWorkbook();

			// 每写入一张表,一行,一列之前都必须先创建
			Sheet sheet = workbook.createSheet("项目匹配车表");

			// row是行,创建第一行设置一个标题
			Row title = sheet.createRow(0);
			// value只能是基本类型和String
			title.createCell(0).setCellValue("id");
			title.createCell(1).setCellValue("内部编号");
			title.createCell(2).setCellValue("是否有牌照");
			title.createCell(3).setCellValue("牌照号");
			title.createCell(4).setCellValue("是否有临牌");
			title.createCell(5).setCellValue("临牌号");
			title.createCell(6).setCellValue("临牌有效起始时间");
			title.createCell(7).setCellValue("临牌失效日期");
			title.createCell(8).setCellValue("内部验车状态(默认等待验车)");
			title.createCell(9).setCellValue("车辆状态(默认未知)");
			title.createCell(10).setCellValue("归属部门id");
			title.createCell(11).setCellValue("归属员工id");
			title.createCell(12).setCellValue("所属项目客户id");
			title.createCell(13).setCellValue("登记入库时间");
			title.createCell(14).setCellValue("实际入库时间");
			title.createCell(15).setCellValue("出库时间");

			for (int i = 0; i < cars.size(); i++) {
				// 因为第一行是标题,所以创建第二行
				Row row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(cars.get(i).getId());
				row.createCell(1).setCellValue(cars.get(i).getCarNo());
				row.createCell(2).setCellValue(cars.get(i).getHasLicense());
				row.createCell(3).setCellValue(cars.get(i).getLicenseId());
				row.createCell(4).setCellValue(cars.get(i).getHasLicense());
				row.createCell(5).setCellValue(cars.get(i).getTemLicense());
				row.createCell(6).setCellValue(cars.get(i).getTemStartDate());
				row.createCell(7).setCellValue(cars.get(i).getTemEndDate());
				row.createCell(8).setCellValue(cars.get(i).getAuditStatus());
				row.createCell(9).setCellValue(cars.get(i).getStatus());
				row.createCell(10).setCellValue(cars.get(i).getDepartmentId());
				row.createCell(11).setCellValue(cars.get(i).getStaffId());
				row.createCell(12).setCellValue(cars.get(i).getConsumerId());
				row.createCell(13).setCellValue(cars.get(i).getRegistTime());
				row.createCell(14).setCellValue(cars.get(i).getActualRegistTime());
				row.createCell(15).setCellValue(cars.get(i).getOutTime());
			}
			
			OutputStream fos = null; 
			try {
				fos = FileUtil.fileOutputStream("C:\\Users\\swiftzsl\\Desktop\\CarExcel\\", "项目匹配车表" + getTimestamp() + ".xlsx");
				workbook.write(fos);
			} catch (IOException e) {
				System.out.println("导出失败");
				e.printStackTrace();
			} finally {
				CloseUtil.close(fos);
				CloseUtil.close(workbook);
			}
		}
	}
	
	private String getTimestamp() {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(new Date());
	}

	@Override
	public String getTaskName() {
		return "exportCarExcelTask";
	}
}
