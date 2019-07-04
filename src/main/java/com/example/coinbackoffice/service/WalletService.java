package com.example.coinbackoffice.service;

import com.example.coinbackoffice.entity.User;
import com.example.coinbackoffice.entity.Wallet;
import com.example.coinbackoffice.repository.UserRepository;
import com.example.coinbackoffice.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Wallet> listWallets(){
        return this.walletRepository.findAll();
    }

    public Wallet getWallet(String id) throws Exception {
        return this.walletRepository.findById(id).orElseThrow(Exception::new);
    }

    public Object createWallet(String userId) throws Exception {
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){
            throw new Exception();
        }

        // TODO: handle transaction

        Wallet wallet = new Wallet();
        User user = userOptional.get();

        user.addWallet(wallet);

        wallet = this.walletRepository.save(wallet);
        this.userRepository.save(user);

        return wallet;
    }

    public Object transferMoney(String id, Object transfer){
        throw new UnsupportedOperationException();
    }
}
