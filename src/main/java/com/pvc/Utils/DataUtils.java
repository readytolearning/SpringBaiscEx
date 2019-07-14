package com.pvc.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pvc.bean.User;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setName("Venkat");
        user1.setAddress("Hyd");

        User user2 = new User();
        user2.setId(2);
        user2.setName("Satya");
        user2.setAddress("Ban");
        users.add(user1);
        users.add(user2);
        return users;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
