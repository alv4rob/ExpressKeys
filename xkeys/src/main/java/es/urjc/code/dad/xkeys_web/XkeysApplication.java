 package es.urjc.code.dad.xkeys_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager; 
import org.springframework.cache.annotation.EnableCaching; 
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean; 
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession; 
import com.hazelcast.spring.cache.HazelcastCacheManager; 

import com.hazelcast.config.Config; 
import com.hazelcast.config.JoinConfig;
import com.hazelcast.core.HazelcastInstance;

@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
public class XkeysApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(XkeysApplication.class, args);
	}
	
    @Bean
    public Config config() {

        Config config = new Config();
        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
        joinConfig.getMulticastConfig().setEnabled(true);
   
        return config;
    }	
    
    @Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
    	return new HazelcastCacheManager(hazelcastInstance);
    }
}