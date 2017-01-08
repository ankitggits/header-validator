package com.dependentlearners.utility.config;

import java.util.List;

import com.dependentlearners.utility.component.ValidatedHeaderHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class Config extends WebMvcConfigurerAdapter{

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> handlerMethodArgumentResolvers){
		handlerMethodArgumentResolvers.add(validatedHeaderHandlerMethodArgumentResolver());
	}
	
	@Bean
	public ValidatedHeaderHandlerMethodArgumentResolver validatedHeaderHandlerMethodArgumentResolver(){
		return new ValidatedHeaderHandlerMethodArgumentResolver();
	}
}
