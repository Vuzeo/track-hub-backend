package com.example.TrackHub.service;

import com.example.TrackHub.model.Accounts;

public interface AccountsService {

    public abstract void createAccount(Accounts accounts);

    public abstract void updateAccount(Long id, Accounts accounts);

    public abstract void deleteAccount(Long id);

    public abstract Object getAccounts();

}
