package tw.dojo.pos.service;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tw.dojo.pos.domain.Item;
import tw.dojo.pos.entity.Goods;
import tw.dojo.pos.repository.ItemRepository;

public class DefaultItemServiceTest {

    @InjectMocks
    private DefaultItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_return_calculated_items_when_no_promotion_applied() {
        String coloBarcode = "ITEM000001";
        String appleBarcode = "ITEM000002";
        Integer coloAmount = 3;
        int appleAmount = 2;
        List<Item> items = asList(new Item(coloBarcode, coloAmount), new Item(appleBarcode, appleAmount));
        Goods colo = createGoods(coloBarcode, "可口可乐", "瓶", 3.0);
        Goods apple = createGoods(appleBarcode, "苹果", "斤", 5.5);
        when(itemRepository.findOne(coloBarcode)).thenReturn(colo);
        when(itemRepository.findOne(appleBarcode)).thenReturn(apple);

        List<Item> calculatedItems = itemService.calculateItems(items);

        assertThat(calculatedItems.size(), is(2));
        assertCalculatedItem(calculatedItems.get(0), colo, coloAmount, 0.0);
        assertCalculatedItem(calculatedItems.get(1), apple, appleAmount, 0.0);
    }

    private void assertCalculatedItem(Item actualItem, Goods expectedGoods,
                                      Integer expectedAmount, Double expectedBenefit) {
        assertThat(actualItem.getBarcode(), is(expectedGoods.getBarcode()));
        assertThat(actualItem.getName(), is(expectedGoods.getName()));
        assertThat(actualItem.getAmount(), is(expectedAmount));
        assertThat(actualItem.getUnit(), is(expectedGoods.getUnit()));
        assertThat(actualItem.getPrice(), is(expectedGoods.getPrice()));
        assertThat(actualItem.getBenefit(), is(expectedBenefit));
    }

    private Goods createGoods(String barcode, String name, String unit, Double price) {
        Goods goods = new Goods();
        goods.setBarcode(barcode);
        goods.setName(name);
        goods.setUnit(unit);
        goods.setPrice(price);
        return goods;
    }
}
