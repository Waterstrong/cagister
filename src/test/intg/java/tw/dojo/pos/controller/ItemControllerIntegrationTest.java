package tw.dojo.pos.controller;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tw.dojo.pos.BaseIntegrationTest;
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

    @Ignore
    @Test
    public void should_calculate_items_given_input_list() throws Exception {
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

        mockMvc.perform(get("/items"))
                .andExpect(status().isOk());

    }
}
