package com.example.coinbackoffice.service;

import com.example.coinbackoffice.api.TransferRequest;
import com.example.coinbackoffice.entity.Wallet;
import com.example.coinbackoffice.repository.UserRepository;
import com.example.coinbackoffice.repository.WalletRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class WalletServiceTests {

    @Autowired
    private WalletService walletService;

    @MockBean
    private WalletRepository walletRepository;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @TestConfiguration
    static class configuration{
        @Bean
        public WalletService configureWalletService(){
            return new WalletService();
        }
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void transferMoneyTest() throws Exception {
        Wallet from = new Wallet("1", BigDecimal.TEN);
        Wallet to = new Wallet("2", BigDecimal.ZERO);
        when(walletRepository.findById("1")).thenReturn(Optional.of(from));
        when(walletRepository.findById("2")).thenReturn(Optional.of(to));
        when(walletRepository.save(from)).thenReturn(new Wallet("1", BigDecimal.ZERO));
        when(walletRepository.save(to)).thenReturn(new Wallet("2", BigDecimal.TEN));

        TransferRequest request = new TransferRequest();
        request.setAmount(BigDecimal.TEN);
        request.setTo("2");

        Wallet result = this.walletService.transferMoney("1", request);
        Assert.assertNotNull(result);
        Assert.assertEquals(BigDecimal.ZERO, result.getBalance());
        Assert.assertEquals("1", result.getId());


    }
}
