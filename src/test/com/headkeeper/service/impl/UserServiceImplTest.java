package com.headkeeper.service.impl;

import com.headkeeper.bean.view.UserView;
import com.headkeeper.dao.UserDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

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
        userService.removeUser(1);
        verify(userDAO, times(1)).deleteUser(anyInt());
    }

    @Test
    public void setUserActiveStatus() throws Exception {
        userService.setUserActiveStatus(1, true);
        verify(userDAO, times(1)).updateUser(anyInt(), anyBoolean());
    }

    @Test
    public void registration() throws Exception {
        userService.registration(new UserView());
        verify(userDAO, times(1)).addNewUser(any(), anyInt());
    }

    @Test
    public void updateUserInfo() throws Exception {
        userService.updateUserInfo(1, new UserView());
        verify(userDAO, times(1)).updateUser(anyInt(), any());
    }

    @Test
    public void getUser() throws Exception {
        UserView user = userService.getUser(anyInt());
        Assert.assertNotNull(user);
        verify(userDAO, times(1)).getUserById(anyInt());
    }

    @Test
    public void getAllUsers() throws Exception {
        List list = userService.getAllUsers();
        Assert.assertNotNull(list);
        verify(userDAO, times(1)).getUsers();
    }

    @Test
    public void getUserByEmail() throws Exception {
        UserView user = userService.getUserByEmail(anyString());
        Assert.assertNotNull(user);
        verify(userDAO, times(1)).getUserByEmail(anyString());
    }

}