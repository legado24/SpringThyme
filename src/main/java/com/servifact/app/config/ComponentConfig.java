
package com.servifact.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {
    "com.servifact.app.dao","com.servifact.app.service"})
@PropertySource("classpath:jdbc.properties")
public class ComponentConfig {

}