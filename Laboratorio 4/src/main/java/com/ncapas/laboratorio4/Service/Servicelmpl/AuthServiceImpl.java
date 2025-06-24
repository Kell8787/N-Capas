package com.ncapas.laboratorio4.Service.Servicelmpl;

import com.ncapas.laboratorio4.Client.Keycloak.iKeycloakAdminClient;
import com.ncapas.laboratorio4.Client.Keycloak.iKeycloakAuthClient;
import com.ncapas.laboratorio4.Config.Keycloak.KeycloakProperties;
import com.ncapas.laboratorio4.Domain.DTO.CreateUserDTO;
import com.ncapas.laboratorio4.Domain.DTO.KeycloakTokenResponse;
import com.ncapas.laboratorio4.Service.iAuthService;
import lombok.RequiredArgsConstructor;
import feign.Response;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

import static com.ncapas.laboratorio4.Utils.Mappers.GeneralMappers.createUserDtoToMap;
import static com.ncapas.laboratorio4.Utils.Mappers.GeneralMappers.loginToFormData;
import static com.ncapas.laboratorio4.Utils.UserIdFromKeycloak.getUserIdFromKeycloakResponse;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements iAuthService {

    private final iKeycloakAdminClient keycloakAdminClient;
    private final iKeycloakAuthClient keycloakAuthClient;
    private final KeycloakProperties keycloakProperties;

    @Override
    public KeycloakTokenResponse register(CreateUserDTO user) throws Exception {
        Response response = keycloakAdminClient.createUser(createUserDtoToMap(user));
        if (response.status() != 201) throw new Exception("Failed to create user: " + new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8));
        String userId = getUserIdFromKeycloakResponse(response);
        return login(user.getUserName(), user.getPassword());
    }

    @Override
    public KeycloakTokenResponse login(String username, String password) {
        return keycloakAuthClient.getToken(loginToFormData(username, password, keycloakProperties.getClientId(), keycloakProperties.getClientSecret()));
    }
}
