package com.example.coinbackoffice.service;

import static org.mockito.Mockito.*;

import com.example.coinbackoffice.api.UserRequest;
import com.example.coinbackoffice.api.UserResponse;
import com.example.coinbackoffice.entity.User;
import com.example.coinbackoffice.exception.UserNotFoundException;
import com.example.coinbackoffice.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @TestConfiguration
    static class configuration{
        @Bean
        public UserService configureUserService(){
            return new UserService();
        }
    }

    @Before
    public void setUp() throws Exception {
        when(userRepository.findById("1")).thenReturn(Optional.of(new User("1")));
    }

    @Test
    public void findUserPresent() throws UserNotFoundException {
        User user = this.userService.getUser("1");
        Assert.assertNotNull(user);
        Assert.assertEquals(BigInteger.ONE, user.getId());
        Assert.assertNotNull(user.getWallets());
        Assert.assertEquals(0, user.getWallets().size());
    }

    @Test(expected = UserNotFoundException.class)
    public void findUserNotPresent() throws UserNotFoundException {
         this.userService.getUser("2");
    }

    @Test
    public void createUser() {
        UserRequest request = new UserRequest();
        request.setEmail("email");
        request.setName("name");

        User expectedUser = new User();
        expectedUser.setEmail("email");
        expectedUser.setName("name");

        when(this.userRepository.save(expectedUser)).thenReturn(expectedUser);

        UserResponse result = this.userService.createUser(request);
        Assert.assertNotNull(result);
    }

    @Test(expected = Exception.class)
    public void createWithoutName() {
        UserRequest request = new UserRequest();
        request.setEmail("email");

        User expectedUser = new User();
        expectedUser.setEmail("email");

        when(this.userRepository.save(expectedUser)).thenThrow(new Exception());

        this.userService.createUser(request);
    }
}
