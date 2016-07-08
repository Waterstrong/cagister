package tw.dojo.pos.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tw.dojo.pos.BaseIntegrationTest;
import tw.dojo.pos.domain.Goods;
import tw.dojo.pos.repository.GoodsRepository;

public class ShoppingControllerIntegrationTest extends BaseIntegrationTest {
    @Autowired
    private ShoppingController itemController;

    @Autowired
    private GoodsRepository goodsRepository;

    private String inputs;

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(itemController).build();

        goodsRepository.save(createGoods("ITEM000001", "苹果", "斤", 3.0));
        goodsRepository.save(createGoods("ITEM000003", "可口可乐", "瓶", 2.5));
        goodsRepository.save(createGoods("ITEM000005", "蓝球", "wh", 99.0));
        inputs = "[\"ITEM000001\", " +
                        "\"ITEM000001\", " +
                        "\"ITEM000001\", " +
                        "\"ITEM000001\", " +
                        "\"ITEM000001\", " +
                        "\"ITEM000003-2\", " +
                        "\"ITEM000005\", " +
                        "\"ITEM000005\", " +
                        "\"ITEM000005\"]";
    }

    @Test
    public void should_calculate_items_given_input_list_without_promotion() throws Exception {
        mockMvc.perform(post("/items")
                .contentType(APPLICATION_JSON).content(inputs))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items", hasSize(3)))
                .andExpect(jsonPath("$.items[0].barcode").value("ITEM000001"))
                .andExpect(jsonPath("$.items[0].name").value("苹果"))
                .andExpect(jsonPath("$.items[0].unit").value("斤"))
                .andExpect(jsonPath("$.items[0].price").value(3.0))
                .andExpect(jsonPath("$.items[0].amount").value(5))
                .andExpect(jsonPath("$.items[0].benefit").value(0.0));
    }

    @Test
    public void should_calculate_items_given_input_list_with_promotion() throws Exception {

        mockMvc.perform(post("/items")
                .contentType(APPLICATION_JSON).content(inputs))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items", hasSize(3)))
                .andExpect(jsonPath("$.items[0].barcode").value("ITEM000001"))
                .andExpect(jsonPath("$.items[0].name").value("苹果"))
                .andExpect(jsonPath("$.items[0].unit").value("斤"))
                .andExpect(jsonPath("$.items[0].price").value(3.0))
                .andExpect(jsonPath("$.items[0].amount").value(5))
                .andExpect(jsonPath("$.items[0].benefit").value(0.0));
    }

    private Goods createGoods(String barcode, String name, String unit, Double price) {
        Goods goods = new Goods(barcode);
        goods.setName(name);
        goods.setPrice(price);
        goods.setUnit(unit);
        return goods;
    }
}
