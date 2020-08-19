package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class BuyTwoItemsForFixedPriceTest {

    private Discount unitUnderTest;

    @Test
    void basketHasExpectedItemsForFixedPriceDiscount() {
        final Item aPackOfDigestives = new Product(new BigDecimal("1.55")).oneOf();
        final Item aPintOfMilk = new Product(new BigDecimal("0.49")).oneOf();
        List<Item> basket = Arrays.asList(aPackOfDigestives, aPintOfMilk);

        unitUnderTest = new BuyTwoItemsForFixedPrice(
                aPackOfDigestives,
                aPintOfMilk,
                new BigDecimal("1.50"));

        BigDecimal result = unitUnderTest.apply(basket);
        assertThat(result, is(new BigDecimal("0.54")));
    }

}