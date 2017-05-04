package com.headkeeper.service.impl;

import com.headkeeper.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserDAO userDAO;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void removeUser() throws Exception {
    }

    @Test
    public void setUserActiveStatus() throws Exception {
    }

    @Test
    public void registration() throws Exception {
    }

    @Test
    public void updateUserInfo() throws Exception {
    }

    @Test
    public void getUser() throws Exception {
    }

    @Test
    public void getAllUsers() throws Exception {
    }

    @Test
    public void getUserByEmail() throws Exception {
    }

}