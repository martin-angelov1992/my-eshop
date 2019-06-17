package com.martin.eshop.model;

import com.martin.eshop.model.product.IProduct;

import java.math.BigDecimal;
import java.util.Collection;

public interface IBill
{
    BigDecimal getTotal( );

    Collection<IProduct> getProducts( );
}