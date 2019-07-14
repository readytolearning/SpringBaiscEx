package com.pvc.resource;

import com.pvc.Utils.DataUtils;
import com.pvc.bean.User;
import com.pvc.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private IUserService userService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                //.addFilters(new CORSFilter())
                .build();
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = new User();
        user.setId(1);
        user.setName("Venkat");
        when(userService.getUserById(Mockito.anyLong())).thenReturn(user);
        mockMvc.perform(get("/rest/user/1234"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Venkat")));
        verify(userService, times(1)).getUserById(Mockito.anyLong());
        verifyNoMoreInteractions(userService);
    }
    @Test
    public void testGetAllUsers() throws Exception {
        List<User> users= DataUtils.getUsers();
        when(userService.getAllUsers()).thenReturn(users);
        mockMvc.perform(get("/rest/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Venkat")));
        verify(userService, times(1)).getAllUsers();
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setId(1);
        user.setName("Venkat");
        mockMvc.perform(post("/rest/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(DataUtils.asJsonString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Venkat")));
    }
}
