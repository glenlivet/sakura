package org.glenlivet.sakura.mongo.domain.impl;

import org.glenlivet.sakura.mongo.domain.Money;

import java.math.BigDecimal;
import java.util.Currency;

public class MoneyImpl implements Money {

    private BigDecimal amount;

    private Currency currency;

    public MoneyImpl(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public Currency getCurency() {
        return currency;
    }
}
