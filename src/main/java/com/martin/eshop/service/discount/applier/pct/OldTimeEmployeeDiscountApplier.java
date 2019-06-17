package com.martin.eshop.service.discount.applier.pct;

import com.martin.eshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Period;

@Service
public class OldTimeEmployeeDiscountApplier extends PctDiscountApplier
{
    @Autowired
    private Clock clock;

    private Period newEmployeePeriod;

    public OldTimeEmployeeDiscountApplier( @Value ( "${discount.pct.oldTime}" ) final BigDecimal pct,
                                           @Value ( "${discount.pct.oldTime.period}" ) final String newEmployeePeriod )
    {
        super( pct );
        this.newEmployeePeriod = Period.parse('P'+newEmployeePeriod);
    }

    @Override
    public boolean isApplicable( final User user )
    {
        return user.getRegistrationDate().isBefore(LocalDateTime.now(clock).minus(newEmployeePeriod));
    }
}