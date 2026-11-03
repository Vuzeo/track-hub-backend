package com.example.TrackHub.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.TrackHub.model.Accounts;
import com.example.TrackHub.repository.AccountsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    public AccountsServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public void createAccount(Accounts accounts) {
        accountsRepository.save(accounts);
    }

    @Override
    public void updateAccount(Long id, Accounts accounts) {
        if (!accountsRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // Save under the path id so the row is updated in place and keeps its foreign keys
        accounts.setId(id);
        accountsRepository.save(accounts);
    }

    @Override
    public void deleteAccount(Long id) {
        accountsRepository.deleteById(id);
    }

    @Override
    public List<Accounts> getAccounts() {
        List<Accounts> accounts = new ArrayList<Accounts>();
        accountsRepository.findAll().forEach(accounts::add);
        return accounts;
    }
}
