package com.example.coinbackoffice.service;

import com.example.coinbackoffice.api.TransferRequest;
import com.example.coinbackoffice.entity.User;
import com.example.coinbackoffice.entity.Wallet;
import com.example.coinbackoffice.exception.InsufficientFundsException;
import com.example.coinbackoffice.repository.UserRepository;
import com.example.coinbackoffice.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Wallet createWallet(String userId) throws Exception {
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

    @Transactional
    public Wallet transferMoney(String id, TransferRequest transfer) throws Exception {
        Wallet walletFrom = this.getWallet(id);
        if(walletFrom.getBalance().compareTo(transfer.getAmount()) > 0){
            throw new InsufficientFundsException();
        }

        Wallet walletTo = this.getWallet(transfer.getTo());

        walletFrom.setBalance(walletFrom.getBalance().add(transfer.getAmount().negate()));
        walletTo.setBalance(walletFrom.getBalance().add(transfer.getAmount()));

        this.walletRepository.save(walletFrom);
        this.walletRepository.save(walletTo);
        return walletFrom;
    }
}
