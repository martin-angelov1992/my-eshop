package com.martin.eshop.model.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.martin.eshop.model.ProductType;

import java.math.BigDecimal;

@JsonDeserialize (as = Product.class)
public interface IProduct
{
    ProductType getType( );

    BigDecimal getPrice( );
}
