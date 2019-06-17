package com.martin.eshop.service.discount.applier.pct;

import com.martin.eshop.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmployeePctDiscountApplier extends PctDiscountApplier
{
    public EmployeePctDiscountApplier( @Value ( "${discount.pct.employee}" ) final BigDecimal pct )
    {
        super( pct );
    }

    @Override
    public boolean isApplicable( final User user )
    {
        return user.isEmployee();
    }
}
