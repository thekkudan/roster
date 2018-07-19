package io.rscale.training;

import java.util.List;

public class AppInfo {

	public static final String MYSQL = "MySQL";
	public static final String H2 = "H2";
	
	private String appId;
	private String appName;
	private List<String> appUris;
	private String cfApi;
	private String instanceId;
	private int instanceIndex;
	private String spaceId;
	private String spaceName;
	private String database;
	private List<String> boundServices;
	private List<String> profiles;
	private String rosterA;
	private String rosterB;
	private String rosterC;
	private String appVersion;
	
	public AppInfo() {}

	public AppInfo(String appId, String appName, List<String> appUris, String cfApi, String instanceId,
			int instanceIndex, String spaceId, String spaceName, String database, List<String> boundServices, 
			List<String> profiles, String rosterA, String rosterB, String rosterC, String appVersion) {
		super();
		this.appId = appId;
		this.appName = appName;
		this.appUris = appUris;
		this.cfApi = cfApi;
		this.instanceId = instanceId;
		this.instanceIndex = instanceIndex;
		this.spaceId = spaceId;
		this.spaceName = spaceName;
		this.database = database;
		this.boundServices = boundServices;
		this.profiles = profiles;
		this.rosterA = rosterA;
		this.rosterB = rosterB;
		this.rosterC = rosterC;
		this.appVersion = appVersion;
	}

	public String getAppId() {
		return appId;
	}

	public String getAppName() {
		return appName;
	}

	public List<String> getAppUris() {
		return appUris;
	}

	public String getCfApi() {
		return cfApi;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public int getInstanceIndex() {
		return instanceIndex;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public String getSpaceName() {
		return spaceName;
	}

	public String getDatabase() {
		return database;
	}
	
	public List<String> getBoundServices() {
		return boundServices;
	}
	
	public List<String> getProfiles() {
		return profiles;
	}
	
	public String getRosterA() {
		return rosterA;
	}
	
	public String getRosterB() {
		return rosterB;
	}
	
	public String getRosterC() {
		return rosterC;
	}
	
	public String getAppVersion() {
		return appVersion;
	}
	
}
