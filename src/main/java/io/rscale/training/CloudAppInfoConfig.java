package io.rscale.training;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class CloudAppInfoConfig {
	
	@Value("${ROSTER_A:#{null}}")
	private String rosterA;

	@Value("${ROSTER_B:#{null}}")
	private String rosterB;

	@Value("${ROSTER_C:#{null}}")
	private String rosterC;

	@Value("${APP_VERSION:#{null}}")
	private String appVersion;
	
	@Autowired
	private ApplicationContext appContext;
		
	public final String APP_ID_KEY = "application_id";
	public final String APP_NAME_KEY = "application_name";
	public final String APP_URIS_KEY = "application_uris";
	public final String CF_API_KEY = "cf_api";
	public final String INSTANCE_ID_KEY = "instance_id";
	public final String INSTANCE_INDEX_KEY = "instance_index";
	public final String SPACE_ID_KEY = "space_id";
	public final String SPACE_NAME_KEY = "space_name";
	
	private Cloud cloud;
	
	public CloudAppInfoConfig() {
		CloudFactory cloudFactory = new CloudFactory();
		cloud = cloudFactory.getCloud();
	}
	
	@Bean
	public AppInfo appInfo() throws SQLException {
		
		Map<String,Object> properties = cloud.getApplicationInstanceInfo().getProperties();
		
		String appId = (String)properties.get(APP_ID_KEY);
		String appName = (String)properties.get(APP_NAME_KEY);
		@SuppressWarnings("unchecked")
		List<String> appUris = (List<String>) properties.get(APP_URIS_KEY);
		String cfApi = (String)properties.get(CF_API_KEY);
		String instanceId = (String)properties.get(INSTANCE_ID_KEY);
		int instanceIndex = (int)properties.get(INSTANCE_INDEX_KEY);
		String spaceId = (String)properties.get(SPACE_ID_KEY);
		String spaceName = (String)properties.get(SPACE_NAME_KEY);
		String database = getDatabaseName();
		List<String> boundServices = getServices();
		List<String> profiles = Arrays.asList(appContext.getEnvironment().getActiveProfiles());
		
		return new AppInfo(appId, appName, appUris, cfApi, instanceId, instanceIndex, spaceId, spaceName, 
				database, boundServices, profiles, rosterA, rosterB, rosterC, appVersion);
	}
	
	public String getDatabaseName() {
		for( ServiceInfo info : cloud.getServiceInfos(DataSource.class) ) {
			if ( info.toString().toLowerCase().contains("mysql") ) {
				return "MySQL";
			}
		}
		return "H2";
	}
	
    private List<String> getServices() {
    	List<String> list = new ArrayList<String>();
    	for ( ServiceInfo info : cloud.getServiceInfos()) {
    		list.add(info.getId());
    	}
    	return list;
    }
	
}
