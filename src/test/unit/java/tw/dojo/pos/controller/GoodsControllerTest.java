package tw.dojo.pos.controller;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.http.HttpStatus.CREATED;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import tw.dojo.pos.domain.Goods;
import tw.dojo.pos.service.GoodsService;

public class GoodsControllerTest {
    @InjectMocks
    private GoodsController goodsController;

    @Mock
    private GoodsService goodsService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void should_save_goods() {
        Goods expectedGoods = new Goods();
        when(goodsService.saveGoods(expectedGoods)).thenReturn(expectedGoods);

        ResponseEntity<?> responseEntity = goodsController.saveGoods(expectedGoods);

        assertThat(responseEntity.getStatusCode(), is(CREATED));
        assertThat(responseEntity.getBody(), is(expectedGoods));

    }
}
