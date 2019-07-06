package com.example.coinbackoffice.service;

import static org.mockito.Mockito.*;

import com.example.coinbackoffice.entity.User;
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
        when(userRepository.findById("1")).thenReturn(Optional.of(new User(BigInteger.ONE)));
    }

    @Test
    public void findUserPresent() throws Exception {
        User user = this.userService.getUser("1");
        Assert.assertNotNull(user);
        Assert.assertEquals(BigInteger.ONE, user.getId());
        Assert.assertNotNull(user.getWallets());
        Assert.assertEquals(0, user.getWallets().size());
    }
}
