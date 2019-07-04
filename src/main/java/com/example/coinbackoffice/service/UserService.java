package com.example.coinbackoffice.service;

import com.example.coinbackoffice.entity.User;
import com.example.coinbackoffice.entity.Wallet;
import com.example.coinbackoffice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers(){
        return this.userRepository.findAll();
    }

    public User getUser(String id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(Exception::new);
    }

    public Object createUser(Object user){
        User userEntity = new User();
        return this.userRepository.save(userEntity);
    }

    public List<Wallet> getUserWallets(String id) throws Exception {
        return this.getUser(id).getWallets();
    }

    public Object getUserHistory(String id){
        throw new UnsupportedOperationException();
    }
}
