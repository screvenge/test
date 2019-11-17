package com.study.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public abstract class FileUtil {
	/**
	 * 导出excel工具类
	 * 
	 * @param fileDir 目录
	 * @param fileName 文件名称
	 */
	public static FileOutputStream fileOutputStream(String fileDir, String fileName) {
		FileOutputStream fos = null;
		File dir = new File(fileDir);

		if (!dir.isDirectory()) {
			dir.mkdir();
		}

		File xls = new File(fileDir + fileName);

		if (xls.isFile() && xls.exists()) {
			xls.delete();
		}

		try {
			// 创建文件流
			fos = new FileOutputStream(fileDir + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fos;
	}
}
