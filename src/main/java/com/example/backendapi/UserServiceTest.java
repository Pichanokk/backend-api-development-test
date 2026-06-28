package com.example.backendapi;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {
    @Test
    void testCreateUser_ShouldIncreaseListSize() {
        UserService userService = new UserService();
        User newUser = new User(null,
                "Test Name",
                "testUser",
                "test@email.com",
                "123",
                "test.com");

        User result = userService.createUser(newUser);

        assertNotNull(result.getId());
        assertEquals("Test Name", result.getName());
    }

    @Test
    void testGetAllUsers_ShouldReturnInitialData() {
        UserService userService = new UserService();
        List<User> users = userService.getAllUsers();
        assertEquals(2, users.size());
    }
}
