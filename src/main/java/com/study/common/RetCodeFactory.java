package com.study.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.study.message.common.LanguageInfo;

public class RetCodeFactory {
	private static final String CLASSPATH_ALL_URL_PREFIX = "classpath*:resultcodei18n/*.properties";
	
	private static final Map<Integer, List<LanguageInfo>> MAP = new HashMap<>();
	
	static {
		ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		try {
			Resource[] resources = resourceResolver.getResources(CLASSPATH_ALL_URL_PREFIX);
			Properties properties = new Properties();
			
			for (Resource resource : resources) {
				InputStream in = resource.getInputStream();
				properties.load(in);
				
				Set<String> set = properties.stringPropertyNames();
				
				for (String code : set) {
					// 获取文件的名称
					String language = resource.getFilename().split("\\.")[0];
					
					List<LanguageInfo> mapValue = MAP.get(Integer.valueOf(code));

					if (mapValue == null) {
						List<LanguageInfo> list = new ArrayList<>();
						LanguageInfo languageInfo = new LanguageInfo();
						languageInfo.setLanguage(language);
						languageInfo.setName(String.valueOf(properties.get(code)));
						list.add(languageInfo);
						MAP.put(Integer.valueOf(code), list);
					} else {
						LanguageInfo languageInfo = new LanguageInfo();
						languageInfo.setLanguage(language);
						languageInfo.setName(String.valueOf(properties.get(code)));
						mapValue.add(languageInfo);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getMsg(Integer retCode, String i18n) {
		// 如果为null, 默认中文
		i18n = i18n == null ? "zh_CN" : i18n;
		List<LanguageInfo> list = MAP.get(retCode);
		if (CollectionUtils.isNotEmpty(list)) {
			for (LanguageInfo lan : list) {
				if (lan.getLanguage().equals(i18n)) {
					return lan.getName();
				}
			}
		}
		return null;
	}
}
