package com.semicolon.wallet.config;


import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Setter
@Getter
@Configuration
public class BeanConfig {


    @Value("${paystack.api.key}")
    private String paystackApiKey;
    @Value("${paystack.base.url}")
    private String paystackInitializeUrl;


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
