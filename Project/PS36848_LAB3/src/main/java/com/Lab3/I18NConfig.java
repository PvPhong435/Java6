package com.Lab3;


import java.util.Locale;


import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class I18NConfig implements WebMvcConfigurer
{
	@Bean("messageSource")
	public MessageSource getMessageSource()
	{
		ReloadableResourceBundleMessageSource ms=new ReloadableResourceBundleMessageSource();
		ms.setDefaultEncoding("utf-8");
		ms.setBasenames("classpath:i18n/message","classpath:i18n/global");
		return ms;
	}
	
	@Bean("localeResolver")
	public LocaleResolver getLocaleResolver()
	{
		CookieLocaleResolver cookie=new CookieLocaleResolver();
		cookie.setDefaultLocale(new Locale("vi"));
		cookie.setCookiePath("/");
		cookie.setCookieMaxAge(10*24*60*60);
		return cookie;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		LocaleChangeInterceptor lci=new LocaleChangeInterceptor();
		lci.setParamName("lang");
		registry.addInterceptor(lci).addPathPatterns("/**").excludePathPatterns("/images/**");
	}
}
 