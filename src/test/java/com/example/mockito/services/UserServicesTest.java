package com.example.mockito.services;
import com.example.mockito.dao.UserDao;
import com.example.mockito.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServicesTest {
    @Mock
    private UserDao userDao;


    @InjectMocks
    private UserServices userServices = new UserServices(userDao);

    @Test
    public void checkUserNoExist() {
        User user = new User("Vova");
        boolean result = userServices.checkUserExist(user);
        assertFalse(result);
    }

    @Test
    public void checkUserExist() {
        User user = new User("Vova");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userDao.findAllUsers()).thenReturn(userList);
        boolean result = userServices.checkUserExist(user);
        assertTrue(result);

    }
}