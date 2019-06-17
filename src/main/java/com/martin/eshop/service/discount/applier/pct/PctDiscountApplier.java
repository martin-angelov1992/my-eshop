package com.martin.eshop.service.discount.applier.pct;

import com.martin.eshop.model.User;

import java.math.BigDecimal;

public abstract class PctDiscountApplier
{
    private BigDecimal pct;

    public PctDiscountApplier( BigDecimal pct ) {
        this.pct = pct;
    }

    public BigDecimal getPct( )
    {
        return pct;
    }

    public abstract boolean isApplicable( User user );
}