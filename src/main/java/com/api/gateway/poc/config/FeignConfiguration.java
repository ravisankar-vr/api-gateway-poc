package com.api.gateway.poc.config;

import feign.Contract;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Configuration;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Configuration
public class FeignConfiguration {

   /* @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;*/
    /*@Bean
    public Decoder decoder() {
        return new JacksonDecoder();
    }

    @Bean
    public Encoder encoder() {
        return new JacksonEncoder();
    }*/

    @Bean
    public Encoder encoder() {
        return new SpringFormEncoder(new SpringEncoder(feignHttpMessageConverter()));
    }

    @Bean
    public Decoder decoder() {
        return new ResponseEntityDecoder(new SpringDecoder(feignHttpMessageConverter()));
    }

   /* @Bean
    public Contract contract() {
        return new SpringMvcContract();
    }*/

    public ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
        final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(new GateWayMappingJackson2HttpMessageConverter());
        return () -> httpMessageConverters;
    }

    public static class GateWayMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
        GateWayMappingJackson2HttpMessageConverter(){
            List<MediaType> supportedMediaTypes =
                    new ArrayList<>();
            supportedMediaTypes
                    .add(MediaType.valueOf(MediaType.TEXT_HTML_VALUE+ ";charset=UTF-8"));
            supportedMediaTypes
                    .add(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
            supportedMediaTypes.add(
                    MediaType.valueOf("application/vnd.spring-boot.actuator.v2+json"));
            setSupportedMediaTypes(supportedMediaTypes);

        }
    }


    /*@Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }*/
}
