package com.apple.buy.robiphone.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class CommonConfig {
    @Bean
    public RestTemplate createTemplate (){
        return new RestTemplate();
    }
    @Bean
    public PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        //yaml.setResources(new FileSystemResource("/dir/application.yml"));//File引入
        yaml.setResources(new ClassPathResource("application.yml"));//class引入
        log.info("_________"+yaml.getObject().getProperty("logging.file.name"));;
        configurer.setProperties(yaml.getObject());
        return configurer;
    }
}
