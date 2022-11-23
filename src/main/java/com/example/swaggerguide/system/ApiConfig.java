package com.example.swaggerguide.system;

import com.swagger.client.codegen.rest.api.PetApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.swagger.client.codegen.rest.invoker.ApiClient;

@Configuration
public class ApiConfig {
    @Value("${petclinic.host.uri}")
    private String hostInfoBasePath;

    @Bean
    public ApiClient apiClient() {
        return new ApiClient().setBasePath(hostInfoBasePath);
    }

    @Bean
    public PetApi petApi() {
        return new PetApi(apiClient());
    }
}
