package com.fl.i18n;

import java.util.Locale;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class I18nApplication {

	public static void main(String[] args) {
		SpringApplication.run(I18nApplication.class, args);
	}

    @RestController
    @RequestMapping("/")
    public static class I18nController {

        @Autowired
        private MessageUtil messageUtil;

        @GetMapping
        String index() {
            return messageUtil.getMessage("locale.key");
        }

    }

    @Component
    public static class MessageUtil {

        @Autowired
        private MessageSource messageSource;

        public String getMessage(String code) {
            return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());    
        }

        public String getMessage(String code, Object[] args) {
            return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());    
        }

        // public String getMessage(String code, String defaultMessage) {
        //     return messageSource.getMessage(id, null, defaultMessage, LocaleContextHolder.getLocale());    
        // }

        // public String getMessage(String code, Object[] args, String defaultMessage) {
        //     return messageSource.getMessage(id, args, defaultMessage, LocaleContextHolder.getLocale());    
        // }
        
    }

    @Configuration
    public static class I18nConfiguration {

        @Bean
        public LocaleResolver localeResolver() {
            AcceptHeaderLocaleResolver slr = new AcceptHeaderLocaleResolver();
            slr.setDefaultLocale(new Locale("pt", "BR"));
            return slr;
        }
    }
}
