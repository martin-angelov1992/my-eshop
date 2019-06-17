package com.martin.eshop.model.product;

import com.martin.eshop.model.ProductType;

import java.math.BigDecimal;

public class Product implements IProduct
{
    private ProductType type;
    private BigDecimal price;

    public Product( final ProductType type,
                    final BigDecimal price )
    {
        this.type = type;
        this.price = price;
    }

    public Product( )
    {
    }

    public void setType( final ProductType type )
    {
        this.type = type;
    }

    public void setPrice( final BigDecimal price )
    {
        this.price = price;
    }

    public ProductType getType( ) {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }
}