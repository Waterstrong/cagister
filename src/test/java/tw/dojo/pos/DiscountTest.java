package tw.dojo.pos;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DiscountTest {
    @Test
    public void should_pass() {
        Discount discount = new Discount();
        assertThat(true, is(true));
    }
}
