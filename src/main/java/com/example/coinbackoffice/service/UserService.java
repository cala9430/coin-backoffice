package com.example.coinbackoffice.service;

import com.example.coinbackoffice.api.UserRequest;
import com.example.coinbackoffice.api.UserResponse;
import com.example.coinbackoffice.entity.User;
import com.example.coinbackoffice.entity.Wallet;
import com.example.coinbackoffice.exception.UserNotFoundException;
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

    public User getUser(String id) throws UserNotFoundException {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("Cannot find User with id %s", id)));
    }

    public UserResponse createUser(UserRequest user){
        User userEntity = new User();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity =  this.userRepository.save(userEntity);

        return new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getWallets());
    }

    public List<Wallet> getUserWallets(String id) throws Exception {
        return this.getUser(id).getWallets();
    }

    public Object getUserHistory(String id){
        throw new UnsupportedOperationException();
    }

    public void update(User user) {
        this.userRepository.save(user);
    }
}
