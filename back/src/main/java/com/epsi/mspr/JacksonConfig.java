package com.epsi.mspr;

import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
    @Bean
    public Hibernate6Module Hibernate6Module() {
        return new Hibernate6Module();
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer(Hibernate6Module Hibernate6Module) {
        return jacksonObjectMapperBuilder ->
                jacksonObjectMapperBuilder.modulesToInstall(Hibernate6Module);
    }
}
