package io.rscale.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!cloud")
public class NonCloudAppInfoConfig {
	
	@Bean
	public AppInfo appInfo() {
		return new AppInfo();
	}
	
}
