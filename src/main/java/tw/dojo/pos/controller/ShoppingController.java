package tw.dojo.pos.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static tw.dojo.pos.util.PosDataParser.parse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.dojo.pos.domain.Receipt;
import tw.dojo.pos.domain.ShoppingItem;
import tw.dojo.pos.service.ItemService;

@RestController
public class ShoppingController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = POST, value = "/items")
    public ResponseEntity<?> generateReceipt(@RequestBody List<String> inputs) {
        List<ShoppingItem> shoppingItems = itemService.calculateItems(parse(inputs));
        return new ResponseEntity<>(new Receipt(shoppingItems), OK);
    }
}
