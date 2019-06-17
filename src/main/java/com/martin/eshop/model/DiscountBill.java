package com.martin.eshop.model;

import com.martin.eshop.model.product.IProduct;

import java.math.BigDecimal;
import java.util.Collection;

public class DiscountBill implements IBill
{
    private final IBill bill;
    private final BigDecimal discountedAmount;

    public DiscountBill(final IBill bill, final BigDecimal discountedAmount) {
        this.bill = bill;
        this.discountedAmount = discountedAmount;
    }

    @Override
    public BigDecimal getTotal( )
    {
        return discountedAmount;
    }

    @Override
    public Collection<IProduct> getProducts( )
    {
        return bill.getProducts();
    }
}