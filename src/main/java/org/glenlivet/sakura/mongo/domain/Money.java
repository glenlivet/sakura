package org.glenlivet.sakura.mongo.domain;

import java.math.BigDecimal;
import java.util.Currency;

public interface Money {

    BigDecimal getAmount();
    Currency getCurency();
}
