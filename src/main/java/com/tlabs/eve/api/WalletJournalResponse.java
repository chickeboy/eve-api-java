package com.tlabs.eve.api;


import java.util.ArrayList;
import java.util.List;

public final class WalletJournalResponse extends EveAPIResponse {

    private static final long serialVersionUID = 8503338423091393808L;

    private List<WalletJournalEntry> transactions = new ArrayList<>();

    public final void addTransaction(WalletJournalEntry t) {
        this.transactions.add(t);
    }

    public final List<WalletJournalEntry> getTransactions() {
        return transactions;
    }
}
