package org.glenlivet.sakura.katharsis.domain.model;

import java.math.BigDecimal;
import java.util.Currency;

public class Money {
    private BigDecimal amount;

    private Currency currency;

    public Money() {
    }

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.currency = currency;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Currency getCurency() {
        return currency;
    }
}
