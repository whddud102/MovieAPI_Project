package com.jy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jy.service", "com.jy.utils"})
public class RootConfig{
 
}
