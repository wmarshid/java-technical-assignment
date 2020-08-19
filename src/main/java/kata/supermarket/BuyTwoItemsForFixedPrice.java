package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class BuyTwoItemsForFixedPrice implements Discount {

    private final Item itemOne;
    private final Item itemTwo;
    private final BigDecimal fixedPrice;

    public BuyTwoItemsForFixedPrice(Item itemOne, Item itemTwo, BigDecimal fixedPrice) {
        this.itemOne = itemOne;
        this.itemTwo = itemTwo;
        this.fixedPrice = fixedPrice;
    }

    @Override
    public BigDecimal apply(List<Item> items) {
        if (items.contains(itemOne) && items.contains(itemTwo)) {
            BigDecimal discount = itemOne.price().add(itemTwo.price());
            return discount.subtract(fixedPrice);
        }
        return BigDecimal.ZERO;
    }
}
