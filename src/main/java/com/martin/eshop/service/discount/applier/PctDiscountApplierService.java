package com.martin.eshop.service.discount.applier;

import com.martin.eshop.model.Bill;
import com.martin.eshop.model.IBill;
import com.martin.eshop.model.ProductType;
import com.martin.eshop.model.User;
import com.martin.eshop.model.product.DiscountedProduct;
import com.martin.eshop.model.product.IProduct;
import com.martin.eshop.service.discount.applier.pct.PctDiscountApplier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Service
public class PctDiscountApplierService implements DiscountApplierService
{
    private final Set<PctDiscountApplier> pctDiscountAppliers;

    public PctDiscountApplierService(final Set<PctDiscountApplier> pctDiscountAppliers) {
        this.pctDiscountAppliers = new TreeSet<>( ( o1, o2 ) -> o2.getPct( ).compareTo( o1.getPct( ) ) );

        this.pctDiscountAppliers.addAll( pctDiscountAppliers );

    }

    @Override
    public IBill getDiscounted( final User user,
                                final IBill bill )
    {
        PctDiscountApplier bestPctApplier = findBestPctApplier( user );

        if (bestPctApplier == null) {
            return bill;
        }

        Set<IProduct> products = new HashSet<>(  );

        for ( IProduct product: bill.getProducts( )) {
            if (product.getType( ) == ProductType.GROCERIES) {
                products.add( product );
                continue;
            }

            DiscountedProduct discountedProduct = new DiscountedProduct( product,
                                                                         bestPctApplier.getPct());
            products.add( discountedProduct );
        }

        Bill discountedBill = new Bill();
        discountedBill.setProducts( products );
        return discountedBill;
    }

    private PctDiscountApplier findBestPctApplier(final User user)
    {
        for (PctDiscountApplier discountApplier: pctDiscountAppliers) {
            if (discountApplier.isApplicable( user )) {
                return discountApplier;
            }
        }

        return null;
    }
}