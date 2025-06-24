package com.ncapas.laboratorio4.Client.Keycloak;

import com.ncapas.laboratorio4.Config.Keycloak.KeycloakAuthFeignConfig;
import com.ncapas.laboratorio4.Domain.DTO.KeycloakTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "keycloak-service", url = "${keycloak.server-url}", configuration = KeycloakAuthFeignConfig.class)
public interface iKeycloakAuthClient {
    @PostMapping(value = "/realms/${keycloak.realm}/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public KeycloakTokenResponse getToken(@RequestBody MultiValueMap<String, String> formData);
}
