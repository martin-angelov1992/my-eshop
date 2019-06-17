package com.martin.eshop.service.discount.applier;

import com.martin.eshop.model.DiscountBill;
import com.martin.eshop.model.IBill;
import com.martin.eshop.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class AmountBasedDiscountApplierService implements DiscountApplierService
{
    private final BigDecimal totalTreshold;
    private final BigDecimal discount;

    public AmountBasedDiscountApplierService( @Value( "${discount.amount.threshold}" ) final BigDecimal totalTreshold,
                                              @Value( "${discount.amount.discountedAmount}" ) final BigDecimal discount ) {
        this.totalTreshold = totalTreshold;
        this.discount = discount;
    }

    @Override
    public IBill getDiscounted( final User user,
                                final IBill bill )
    {
        BigDecimal totalDiscount = bill.getTotal().divide( totalTreshold ).setScale( 0, RoundingMode.FLOOR ).multiply( discount );
        return new DiscountBill( bill, bill.getTotal().subtract( totalDiscount ));
    }
}
