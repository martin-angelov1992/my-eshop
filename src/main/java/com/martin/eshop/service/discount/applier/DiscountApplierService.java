package com.martin.eshop.service.discount.applier;

import com.martin.eshop.model.IBill;
import com.martin.eshop.model.User;

public interface DiscountApplierService
{
    IBill getDiscounted( User user, IBill bill );
}