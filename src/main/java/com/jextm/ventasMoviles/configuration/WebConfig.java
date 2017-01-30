package com.jextm.ventasMoviles.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jextm.ventasMoviles.util.AjaxService;
import com.jextm.ventasMoviles.util.impl.AjaxServiceImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.jextm.ventasMoviles")
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver getViewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/pages/");
		resolver.setSuffix(".jsp");

		return resolver;
		
	}
    
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry
			.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");		
		
	}
	
	@Bean
	public MessageSource messageSource() {
	
		ResourceBundleMessageSource result
			= new ResourceBundleMessageSource();
		result.setBasename("message");
		return result;
		
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		
		LocaleChangeInterceptor result = new LocaleChangeInterceptor();
		result.setParamName("lang");
		
		return result;
		
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		
		SessionLocaleResolver result = new SessionLocaleResolver();
		result.setDefaultLocale(Locale.getDefault());
		return result;
		
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}	
	@Bean
	public AjaxService ajaxService(){
		return new AjaxServiceImpl();
	}
	
}
