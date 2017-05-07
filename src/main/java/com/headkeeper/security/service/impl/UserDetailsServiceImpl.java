package com.headkeeper.security.service.impl;

import com.headkeeper.bean.entity.Role;
import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.view.RoleView;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.security.util.SecurityUser;/*
import com.headkeeper.service.exception.ErrorInputException;
import com.headkeeper.service.user.UserService;
import com.headkeeper.service.user.exception.UserNotFoundException;*/
import com.headkeeper.service.UserService;
import com.headkeeper.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public SecurityUser loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        try {
            userEmail = URLDecoder.decode(userEmail, "UTF-8");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        UserView user = null;

        try {
            user = userService.getUserByEmail(userEmail);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        if (user == null) {
            throw new UsernameNotFoundException("User " + userEmail + " not found!");
        }

        List<GrantedAuthority> authorities = getUserRoles(user);

        return new SecurityUser(user.getEmail(), user.getPassword(), user.getId(),
                !user.isActive(), true, true, true, authorities);

    }

    private List<GrantedAuthority> getUserRoles(UserView user) {
        List<GrantedAuthority> result = new ArrayList<>(0);
        RoleView role = user.getRole();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getValue());
        result.add(grantedAuthority);
        return result;
    }
}
