package se.lexicon.dao;

import se.lexicon.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionDao {


    Transaction save(Transaction transaction);

    Optional<Transaction> findById(String id);

    List<Transaction> findByWalletId(String id);
}