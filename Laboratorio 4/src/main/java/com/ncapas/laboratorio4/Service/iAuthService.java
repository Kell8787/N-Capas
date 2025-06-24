package com.ncapas.laboratorio4.Service;

import com.ncapas.laboratorio4.Domain.DTO.CreateUserDTO;
import com.ncapas.laboratorio4.Domain.DTO.KeycloakTokenResponse;
import jakarta.validation.Valid;

public interface iAuthService {
    KeycloakTokenResponse register(@Valid CreateUserDTO user) throws Exception;
    KeycloakTokenResponse login(String username, String password);
}
