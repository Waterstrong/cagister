package tw.dojo.pos.controller;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.http.HttpStatus.OK;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import tw.dojo.pos.domain.Item;
import tw.dojo.pos.domain.ItemResponse;
import tw.dojo.pos.service.ItemService;

public class ItemControllerTest {

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService itemService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void should_calculate_item_when_given_input_list() {
        String barcode = "ITEM000001";
        List<Item> expectedItems = new ArrayList<>();
        when(itemService.calculateItems(asList(new Item(barcode, 1)))).thenReturn(expectedItems);

        ResponseEntity<?> response = itemController.calculateItems(asList(barcode));

        verify(itemService).calculateItems(anyObject());
        assertThat(response.getStatusCode(), is(OK));
        assertThat(((ItemResponse) response.getBody()).getItems(), is(expectedItems));
    }
}
