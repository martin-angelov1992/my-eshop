package com.martin.eshop.model.product;

import com.martin.eshop.model.ProductType;

import java.math.BigDecimal;

public class DiscountedProduct implements IProduct
{
    private final IProduct product;
    private final BigDecimal discountPct;

    public DiscountedProduct( final IProduct product,
                              final BigDecimal discountPct )
    {
        this.discountPct = discountPct;
        this.product = product;
    }

    public BigDecimal getOriginalPrice( ) {
        return product.getPrice();
    }

    @Override
    public ProductType getType( )
    {
        return product.getType( );
    }

    public BigDecimal getPrice( ) {
        return product.getPrice().subtract(product.getPrice().divide( BigDecimal.valueOf( 100 ) ).multiply( discountPct ));
    }
}