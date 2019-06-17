package com.martin.eshop.service.discount.applier.pct;

import com.martin.eshop.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AffilicatePctDiscountApplier extends PctDiscountApplier
{
    public AffilicatePctDiscountApplier( @Value( "${discount.pct.affiliate}" ) final BigDecimal pct )
    {
        super( pct );
    }

    @Override
    public boolean isApplicable( final User user )
    {
        return user.isAffiliate();
    }
}
