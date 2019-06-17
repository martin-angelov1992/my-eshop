package com.martin.eshop.service.discount;

import com.martin.eshop.model.Bill;
import com.martin.eshop.model.IBill;
import com.martin.eshop.model.ProductType;
import com.martin.eshop.model.product.IProduct;
import com.martin.eshop.model.product.Product;
import com.martin.eshop.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@RunWith( SpringRunner.class )
@SpringBootTest
public class DiscrountServiceTest
{
    @Autowired
    private DiscountService service;

    @Mock
    private User user;

    private Bill bill;

    @Before
    public void before() {
        Set<IProduct> products = new HashSet<>(  );
        IProduct greceries = new Product( ProductType.GROCERIES, new BigDecimal( "140" ) );
        IProduct other = new Product( ProductType.OTHER, new BigDecimal( "160" ) );
        products.add( greceries );
        products.add( other );
        bill = new Bill();
        bill.setProducts( products );
    }

    @Test
    public void testUserIsEmployee() {
        when(user.isEmployee()).thenReturn( true );
        when(user.isAffiliate()).thenReturn( true );
        IBill discountedBill = service.applyDiscounts( user, bill );
        Assert.assertTrue(new BigDecimal( "242" ).compareTo(discountedBill.getTotal()) == 0);
    }

    @Test
    public void testUserIsAffiliate() {
        when(user.isAffiliate()).thenReturn( true );
        IBill discountedBill = service.applyDiscounts( user, bill );
        Assert.assertTrue(new BigDecimal( "274" ).compareTo(discountedBill.getTotal()) == 0);
    }

    @Test
    public void test2YearsUser() {
        String str = "2015-04-08 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm" );
        LocalDateTime dateTime = LocalDateTime.parse( str, formatter );
        when(user.getRegistrationDate()).thenReturn( dateTime );
        IBill discountedBill = service.applyDiscounts( user, bill );
        Assert.assertTrue(new BigDecimal( "282" ).compareTo(discountedBill.getTotal()) == 0);
    }
}