package com.cd.stmty.config;

import com.sendgrid.SendGrid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${send.grid.api.key}")
    private String sendGridApiKey;

//    @Autowired
//    private AlarmInterceptor alarmInterceptor;

//    @Override
//    public void addInterceptors(final InterceptorRegistry registry) {
//        registry.addInterceptor(alarmInterceptor).addPathPatterns("/").addPathPatterns("/contract")
//                .addPathPatterns("/contract/{contractId:[0-9-]+}").addPathPatterns("/contract-change")
//                .addPathPatterns("/payment").addPathPatterns("/cancel-worry").addPathPatterns("/schedule")
//                .addPathPatterns("/template").addPathPatterns("/master").addPathPatterns("/help")
//                .addPathPatterns("/payment/search").addPathPatterns("/contract/search")
//                .addPathPatterns("/contract-change/search").addPathPatterns("/cancel-worry/search")
//                .addPathPatterns("/schedule/search");
//
//    }

//    @Bean
//    public FilterRegistrationBean<GenericFilterBean> ajaxFilterRegistration() {
//        FilterRegistrationBean<GenericFilterBean> registration = new FilterRegistrationBean<>();
//        registration.
// (new AjaxFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("AjaxFilter");
//        registration.setOrder(1);
//        return registration;
//    }

    @Bean
    public SendGrid sendgrid() {
        return new SendGrid(sendGridApiKey);
    }
}