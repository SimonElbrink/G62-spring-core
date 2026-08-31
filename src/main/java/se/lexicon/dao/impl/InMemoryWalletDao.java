package se.lexicon.dao.impl;

import se.lexicon.dao.WalletDao;
import se.lexicon.model.Wallet;

import java.util.*;

public class InMemoryWalletDao implements WalletDao {

    private final Map<String, Wallet> storage = new HashMap<>();


    @Override
    public Wallet save(Wallet wallet) {
        wallet.setWalletId(UUID.randomUUID().toString());
        storage.put(wallet.getWalletId(), wallet);
        return wallet;
    }

    @Override
    public Optional<Wallet> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Wallet> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void update(Wallet wallet) {
        storage.put(wallet.getWalletId(), wallet); // Replace the existing wallet
    }

}
