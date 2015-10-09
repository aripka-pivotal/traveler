package agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@EnableConfigurationProperties(AgencyProperties.class)
public class TravelAgent {

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;
    
    @Autowired
    private AgencyProperties agencyProperties;

    @HystrixCommand(fallbackMethod = "getBackupGuide")
    public String getGuide() {
        return restTemplate.getForObject("http://company/available", String.class);
    }

    String getBackupGuide() {
        return agencyProperties.getFallbackGuide();
    }

}
