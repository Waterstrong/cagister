package tw.dojo.pos.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import tw.dojo.pos.domain.Goods;
import tw.dojo.pos.repository.GoodsRepository;

public class DefaultGoodsServiceTest {
    @InjectMocks
    private DefaultGoodsService goodsService;

    @Mock
    private GoodsRepository goodsRepository;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void should_save_goods() {
        Goods expectedGoods = new Goods("1234");
        when(goodsRepository.save(expectedGoods)).thenReturn(expectedGoods);

        Goods goods = goodsService.saveGoods(expectedGoods);

        assertThat(goods, is(expectedGoods));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_null_goods() {
        goodsService.saveGoods(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_goods_without_barcode() {
        goodsService.saveGoods(new Goods());
    }
}
