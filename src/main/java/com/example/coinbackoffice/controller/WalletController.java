package com.example.coinbackoffice.controller;

import com.example.coinbackoffice.entity.Wallet;
import com.example.coinbackoffice.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
@CrossOrigin
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping
    public List<Wallet> listWallets(){
        return this.walletService.listWallets();
    }

    @GetMapping("/{id}")
    public Wallet getWallet(@PathVariable("id") String id) throws Exception {
        return this.walletService.getWallet(id);
    }

    @PutMapping
    public Object createWallet(@RequestParam("userId") String userId) throws Exception {
        return this.walletService.createWallet(userId);
    }

    @PostMapping("/{id}")
    public Object transferMoney(@PathVariable("id") String id, @RequestBody Object transfer){
        throw new UnsupportedOperationException();
    }
}
