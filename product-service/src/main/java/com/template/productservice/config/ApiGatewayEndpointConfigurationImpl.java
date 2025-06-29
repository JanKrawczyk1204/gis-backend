package com.template.productservice.config;

import jakarta.annotation.PostConstruct;
import org.coffeecode.ApiGatewayEndpointConfiguration;
import org.coffeecode.entity.Endpoint;
import org.coffeecode.entity.HttpMethod;
import org.coffeecode.entity.Response;
import org.coffeecode.entity.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiGatewayEndpointConfigurationImpl implements ApiGatewayEndpointConfiguration {

    @Value("${api-gateway.url}")
    private String GATEWAY_URL;

    @PostConstruct
    public void startOperation() {
        initMap();
        register();
    }

    @Override
    public void initMap() {
        endpointList.add(new Endpoint("/api/v1/kebab", HttpMethod.POST, Role.GUEST));
        endpointList.add(new Endpoint("/api/v1/review", HttpMethod.POST, Role.GUEST));
        endpointList.add(new Endpoint("/api/v1/review/kebab/**", HttpMethod.GET, Role.GUEST));
        endpointList.add(new Endpoint("/api/v1/review/user/**", HttpMethod.GET, Role.GUEST));
        endpointList.add(new Endpoint("/api/v1/kebab", HttpMethod.GET, Role.GUEST));
        endpointList.add(new Endpoint("/api/v1/kebab/search", HttpMethod.GET, Role.GUEST));
    }

    @Override
    public void register() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Response> response = restTemplate.postForEntity(GATEWAY_URL, endpointList, Response.class);
        if (response.getStatusCode().isError()) throw new RuntimeException();
    }
}
