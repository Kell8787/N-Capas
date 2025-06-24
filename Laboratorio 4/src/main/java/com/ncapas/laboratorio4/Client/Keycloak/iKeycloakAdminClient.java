package com.ncapas.laboratorio4.Client.Keycloak;

import com.ncapas.laboratorio4.Config.Keycloak.KeycloakFeignInterceptorConfig;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "feign-admin", url = "${keycloak.server-url}", configuration = KeycloakFeignInterceptorConfig.class)
public interface iKeycloakAdminClient {
    //Metodo post realizado al realm que hemos creado al apartado de users que nos devolvera una Response de Feign (Asegurar que la importacion de Response venga de import feign.Response)
    @PostMapping("/admin/realms/${keycloak.realm}/users")
    Response createUser(@RequestBody Map<String, Object> user);
}