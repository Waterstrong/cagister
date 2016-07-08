package tw.dojo.pos.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

    private static final String BARCODE = "123";
    private Goods goods;

    @Before
    public void setUp() {
        goods = new Goods(BARCODE);
        goods.setPrice(3.0);
    }

    @Test
    public void should_calculate_subtotal_when_benefit_is_zero() {
        ShoppingItem item = new ShoppingItem(BARCODE, 3);
        item.setGoods(goods);
        item.setBenefit(0.0);

        assertThat(item.calculateSubtotal(), is(9.0));
        assertThat(item.calculateTotal(), is(9.0));
    }

    @Test
    public void should_calculate_subtotal_when_benefit_is_not_zero() {
        ShoppingItem item = new ShoppingItem(BARCODE, 3);
        item.setGoods(goods);
        item.setBenefit(1.5);

        assertThat(item.calculateSubtotal(), is(7.5));
        assertThat(item.calculateTotal(), is(9.0));
    }
}
