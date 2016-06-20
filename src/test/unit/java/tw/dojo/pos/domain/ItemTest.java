package tw.dojo.pos.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ItemTest {
    @Test
    public void should_calculate_subtotal_when_benefit_is_zero() {
        Item item = new Item("123", 3);
        item.setPrice(3.0);
        item.setBenefit(0.0);

        assertThat(item.calculateSubtotal(), is(9.0));
        assertThat(item.calculateTotal(), is(9.0));
    }

    @Test
    public void should_calculate_subtotal_when_benefit_is_not_zero() {
        Item item = new Item("123", 3);
        item.setPrice(3.0);
        item.setBenefit(1.5);

        assertThat(item.calculateSubtotal(), is(7.5));
        assertThat(item.calculateTotal(), is(9.0));
    }
}
