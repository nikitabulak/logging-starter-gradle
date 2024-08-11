package ru.bulak.loggingstartergradle;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import ru.bulak.loggingstartergradle.webfilter.WebLoggingAdvice;
import ru.bulak.loggingstartergradle.webfilter.WebLoggingFilter;

@AutoConfiguration
public class LoggingConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "logging", name = "web-logging", havingValue = "true")
    public WebLoggingFilter webLoggingFilter(){
        return new WebLoggingFilter();
    }

    @Bean
    @ConditionalOnProperty(prefix = "logging", name = {"web-logging", "log-request-body"}, havingValue = "true")
    public WebLoggingAdvice webLoggingAdvice(){
        return new WebLoggingAdvice();
    }
}
