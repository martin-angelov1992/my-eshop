package com.martin.eshop.controller;

import com.martin.eshop.service.discount.DiscountService;
import com.martin.eshop.model.Bill;
import com.martin.eshop.model.IBill;
import com.martin.eshop.model.User;
import com.martin.eshop.service.jwt.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController
{
    @Autowired
    private DiscountService discountService;

    @PostMapping("/bill")
    public IBill bill( @CurrentUser final User user, @RequestBody final Bill bill ) {
        return discountService.applyDiscounts( user, bill );
    }
}