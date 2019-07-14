package com.pvc.service;

import com.pvc.bean.User;
import com.pvc.resource.UserController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById(){
        User user = userService.getUserById(1234L);
        Assert.assertEquals(user.getId(),1234L);
    }


}
