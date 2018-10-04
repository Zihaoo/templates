package org.hwyoung.templates.domain;


import lombok.Data;
import org.apache.ibatis.javassist.ClassPath;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "com.source")
@PropertySource(value = "classpath:resource.properties")
@Data
public class Resource {
    private String name;
    private String url;

}
