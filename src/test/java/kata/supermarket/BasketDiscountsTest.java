package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasketDiscountsTest {

    @Test
    void basketProvidesTotalValueMinusDiscounts() {
        // Create test data
        final Item aPackOfDigestives = new Product(new BigDecimal("1.55")).oneOf();
        final Item aPintOfMilk = new Product(new BigDecimal("0.49")).oneOf();
        final BigDecimal fixedPrice = new BigDecimal("1.50");

        // Populate test data
        List<Item> items = Arrays.asList(aPackOfDigestives, aPintOfMilk);
        List<Discount> discounts = Collections.singletonList(new BuyTwoItemsForFixedPrice(
                aPackOfDigestives, aPintOfMilk, fixedPrice));

        // Populate basket with test data
        final Basket basket = new Basket();
        items.forEach(basket::addItem);
        discounts.forEach(basket::addDiscount);

        // Assert the result
        assertThat(basket.total(), is(fixedPrice));
    }
}
