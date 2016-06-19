package tw.dojo.pos.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static tw.dojo.pos.util.PosDataParser.parse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.dojo.pos.domain.Item;
import tw.dojo.pos.domain.ItemResponse;
import tw.dojo.pos.service.ItemService;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = GET, value = "/items")
    public ResponseEntity<?> calculateItems(@RequestBody List<String> inputs) {
        List<Item> calculatedItems = itemService.calculateItems(parse(inputs));
        return new ResponseEntity<>(new ItemResponse(calculatedItems), OK);
    }
}
