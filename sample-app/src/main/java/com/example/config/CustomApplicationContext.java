package com.example.config;

import com.example.custom.JsonPropertyFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by p711679 on 21/09/2015.
 */
@Configuration
public class CustomApplicationContext extends WebMvcConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(CustomApplicationContext.class);

    /** Custome Message converter with object mapper filter. **/

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        boolean flag = false;
        LOG.debug("coverter added....");


        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                converters.remove(converter);
                converters.add(new MappingJackson2HttpMessageConverter(getObjectMapper()));
                flag = true;
                LOG.debug("coverter added....");
            }
        }

        if (!flag) {
            converters.add(new MappingJackson2HttpMessageConverter(getObjectMapper()));
            LOG.debug("coverter added....");
        }

    }


    @Bean(name = "objectMapper")
    public ObjectMapper getObjectMapper() {

        Jackson2ObjectMapperBuilder mapperBuilder = new Jackson2ObjectMapperBuilder();

        SimpleFilterProvider filters = new SimpleFilterProvider();
        filters.addFilter("typeFilter", new JsonPropertyFilter());
        filters.setFailOnUnknownId(false);

        mapperBuilder.filters(filters);

        ObjectMapper mapper = mapperBuilder.build();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        return mapper;
    }
}
