package com.study.common.startup;

import java.util.ArrayList;
import java.util.List;

public class Startup {
	private static final Startup INSTANCE = new Startup();
	
	private List<IStartup> startupConfigs = new ArrayList<>();
	
	public static Startup getInstance() {
		return INSTANCE;
	}

	public List<IStartup> getStartupConfigs() {
		return startupConfigs;
	}

	public void setStartupConfigs(List<IStartup> startupConfigs) {
		this.startupConfigs = startupConfigs;
	}
	
	public void start() {
		for (IStartup startup : startupConfigs) {
			startup.startup();
		}
	}
}
