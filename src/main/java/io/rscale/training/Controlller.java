package io.rscale.training;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlller {

	private AppInfo appInfo;
	
	@Autowired
	public Controlller(AppInfo appInfo) {
		this.appInfo = appInfo;
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/details")
    public String details(Model model) throws SQLException {
		
		model.addAttribute("appId", appInfo.getAppId());
		model.addAttribute("appName", appInfo.getAppName());
		model.addAttribute("appUris", appInfo.getAppUris());
		model.addAttribute("cfApi", appInfo.getCfApi());
		model.addAttribute("instanceId", appInfo.getInstanceId());
		model.addAttribute("instanceIndex", appInfo.getInstanceIndex());
		model.addAttribute("spaceId", appInfo.getSpaceId());
		model.addAttribute("spaceName", appInfo.getSpaceName());
		model.addAttribute("database", appInfo.getDatabase());
		model.addAttribute("boundServices", appInfo.getBoundServices());
		model.addAttribute("profiles", appInfo.getProfiles());
		model.addAttribute("rosterA", appInfo.getRosterA());
		model.addAttribute("rosterB", appInfo.getRosterB());
		model.addAttribute("rosterC", appInfo.getRosterC());
		model.addAttribute("appVersion", appInfo.getAppVersion());
		
        return "details";
    }

	@RequestMapping("/kill") 
	public void kill() {
		System.exit(1);
	}
	
}
