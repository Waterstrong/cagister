package tw.dojo.pos.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tw.dojo.pos.BaseIntegrationTest;
import tw.dojo.pos.domain.Goods;
import tw.dojo.pos.repository.GoodsRepository;

public class ItemControllerIntegrationTest extends BaseIntegrationTest {
    @Autowired
    private ItemController itemController;

    @Autowired
    private GoodsRepository goodsRepository;

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(itemController).build();
    }

    @Test
    public void should_calculate_items_given_input_list() throws Exception {
        goodsRepository.save(createGoods("ITEM000001", "苹果", "斤", 3.0));
        goodsRepository.save(createGoods("ITEM000003", "可口可乐", "瓶", 2.5));
        goodsRepository.save(createGoods("ITEM000005", "蓝球", "wh", 99.0));
        String inputs = "[\"ITEM000001\", " +
                        "\"ITEM000001\", " +
                        "\"ITEM000001\", " +
                        "\"ITEM000001\", " +
                        "\"ITEM000001\", " +
                        "\"ITEM000003-2\", " +
                        "\"ITEM000005\", " +
                        "\"ITEM000005\", " +
                        "\"ITEM000005\"]";

        mockMvc.perform(post("/items")
                .contentType(APPLICATION_JSON)
                .content(inputs))
                .andExpect(status().isOk());

    }

    private Goods createGoods(String barcode, String name, String unit, Double price) {
        Goods goods = new Goods(barcode);
        goods.setName(name);
        goods.setPrice(price);
        goods.setUnit(unit);
        return goods;
    }
}
