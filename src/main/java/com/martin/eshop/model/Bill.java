package com.martin.eshop.model;

import com.martin.eshop.model.product.IProduct;

import java.math.BigDecimal;
import java.util.Collection;

public class Bill implements IBill
{
    private Collection<IProduct> products;

    public BigDecimal getTotal() {
        return products.stream().map(p -> p.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void setProducts( final Collection<IProduct> products )
    {
        this.products = products;
    }

    public Collection<IProduct> getProducts( ) {
        return products;
    }
}