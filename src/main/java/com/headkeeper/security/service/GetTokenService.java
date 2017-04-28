package com.headkeeper.security.service;

import com.headkeeper.security.service.exception.AuthenticationException;

public interface GetTokenService {
    String getToken(String email, String password) throws AuthenticationException;
}
