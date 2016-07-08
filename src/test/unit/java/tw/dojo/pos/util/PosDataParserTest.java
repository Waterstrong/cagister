package tw.dojo.pos.util;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import tw.dojo.pos.domain.ShoppingItem;

public class PosDataParserTest {

    @Test
    public void should_parse_pos_input_data() {
        List<String> inputs = asList(
                "ITEM000001",
                "ITEM000001",
                "ITEM000001",
                "ITEM000001",
                "ITEM000001",
                "ITEM000003-2",
                "ITEM000005",
                "ITEM000005",
                "ITEM000005");
        List<ShoppingItem> items = PosDataParser.parse(inputs);

        assertThat(items.size(), is(3));
        assertItem(items.get(0), "ITEM000001", 5);
        assertItem(items.get(1), "ITEM000003", 2);
        assertItem(items.get(2), "ITEM000005", 3);
    }

    private void assertItem(ShoppingItem actualItem, String expectedBarcode, Integer expectedAmount) {
        assertThat(actualItem.getBarcode(), is(expectedBarcode));
        assertThat(actualItem.getAmount(), is(expectedAmount));
    }
}
