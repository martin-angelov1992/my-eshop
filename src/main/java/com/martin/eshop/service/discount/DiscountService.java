package com.martin.eshop.service.discount;

import com.martin.eshop.model.IBill;
import com.martin.eshop.model.User;
import com.martin.eshop.service.discount.applier.AmountBasedDiscountApplierService;
import com.martin.eshop.service.discount.applier.DiscountApplierService;
import com.martin.eshop.service.discount.applier.PctDiscountApplierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountService
{
    private final List<DiscountApplierService> applierServices;

    public DiscountService(final PctDiscountApplierService pctDiscountApplierService,
                           final AmountBasedDiscountApplierService amountBasedDiscountApplier ) {
        this.applierServices = new ArrayList<>(  );
        applierServices.add( pctDiscountApplierService );
        applierServices.add( amountBasedDiscountApplier );
    }

    public IBill applyDiscounts( User user, IBill bill ) {
        for (DiscountApplierService applierService: applierServices) {
             bill = applierService.getDiscounted( user, bill );
        }

        return bill;
    }
}