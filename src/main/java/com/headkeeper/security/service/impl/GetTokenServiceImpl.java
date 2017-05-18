package com.headkeeper.security.service.impl;

import com.headkeeper.security.service.GetTokenService;
import com.headkeeper.security.service.exception.AuthenticationException;
import com.headkeeper.security.util.SecurityUser;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class GetTokenServiceImpl implements GetTokenService {

    private final static String TOKEN_KEY = "head_keepers";
    private final static String EMAIL = "EMAIL";
    private final static String USER_ID = "USER_ID";
    private final static String EXPIRATION_DATE = "TOKEN_EXPIRATION_DATE";
    private static final String NICKNAME = "NICKNAME";
    private static final String IS_ADMIN = "IS_ADMIN";
    private static final String IS_USER = "IS_USER";
    private static final String IS_COMPANY = "IS_COMPANY";

    private UserDetailsService userDetailsService;

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public String getToken(String email, String password) throws AuthenticationException {

        if (email == null || password == null) {
            return null;
        }

        SecurityUser user;
        try {
            user = (SecurityUser) userDetailsService.loadUserByUsername(email);
        } catch (UsernameNotFoundException exception) {
            throw new AuthenticationException("No user with suh email!", exception);
        }

        Map<String, Object> tokenData = new HashMap<String, Object>();

        if (password.equals(user.getPassword())) {
            tokenData.put(USER_ID, user.getId());
            tokenData.put(EMAIL, user.getUsername());
            tokenData.put(NICKNAME, user.getNickname());

            boolean checkAdmin = user.getAuthorities().contains(new SimpleGrantedAuthority("admin"));
            boolean checkUser = user.getAuthorities().contains(new SimpleGrantedAuthority("user"));
            boolean checkCompany = user.getAuthorities().contains(new SimpleGrantedAuthority("employer"));

            tokenData.put(IS_ADMIN, checkAdmin);
            tokenData.put(IS_USER, checkUser);
            tokenData.put(IS_COMPANY, checkCompany);

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 100);
            tokenData.put(EXPIRATION_DATE, calendar.getTime());

            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setExpiration(calendar.getTime());
            jwtBuilder.setClaims(tokenData);

            return jwtBuilder.signWith(SignatureAlgorithm.HS512, TOKEN_KEY).compact();
        } else {
            throw new AuthenticationException("Wrong password!");
        }
    }
}
