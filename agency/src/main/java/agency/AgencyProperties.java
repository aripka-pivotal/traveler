package agency;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix="agency")
@RefreshScope
public class AgencyProperties {

	private String fallbackGuide = "None available! Your backup guide is: Cookie";

	public String getFallbackGuide() {
		return fallbackGuide;
	}

	public void setFallbackGuide(String fallbackGuide) {
		this.fallbackGuide = fallbackGuide;
	}
	
	

}
