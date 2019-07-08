package com.example.coinbackoffice.controller;

import com.example.coinbackoffice.api.UserRequest;
import com.example.coinbackoffice.api.UserResponse;
import com.example.coinbackoffice.entity.User;
import com.example.coinbackoffice.entity.Wallet;
import com.example.coinbackoffice.exception.UserNotFoundException;
import com.example.coinbackoffice.service.TransactionService;
import com.example.coinbackoffice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<User> listUsers(){
        return this.userService.listUsers();
    }

    @GetMapping("/{id}")
    public Object getUser(@PathVariable("id") String id) throws Exception {
        return this.userService.getUser(id);
    }

    @PutMapping
    public UserResponse createUser(@RequestBody UserRequest user){
        return this.userService.createUser(user);
    }

    @GetMapping("/{id}/wallets")
    public List<Wallet> getUserWallets(@PathVariable("id") String id) throws Exception {
        return this.userService.getUserWallets(id);
    }

    @GetMapping("/{id}/history")
    public Object getUserHistory(@PathVariable("id") String id) throws UserNotFoundException {
        return this.transactionService.findTransactionsForWallets(this.userService.getUser(id).getWallets());
    }
}

