package com.example.TrackHub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TrackHub.model.Accounts;
import com.example.TrackHub.repository.AccountsRepository;
import com.example.TrackHub.service.AccountsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    private AccountsService accountsService;
    private AccountsRepository accountsRepository;

    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @RequestMapping(value = "/all")
    public ResponseEntity<Object> getAccounts() {
        return new ResponseEntity<>(accountsService.getAccounts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateAccount(@PathVariable("id") Long id, @RequestBody Accounts accounts) {
        accountsService.updateAccount(id, accounts);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAccount(@PathVariable("id") Long id) {
        accountsService.deleteAccount(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createAccount(@RequestBody Accounts newAccount) {
        accountsService.createAccount(newAccount);
        return new ResponseEntity<>(newAccount, HttpStatus.OK);
    }

}
