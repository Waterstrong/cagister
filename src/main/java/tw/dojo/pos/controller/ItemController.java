package tw.dojo.pos.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import tw.dojo.pos.domain.Item;
import tw.dojo.pos.domain.ItemResponse;
import tw.dojo.pos.service.ItemService;
import tw.dojo.pos.util.PosDataParser;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    public ResponseEntity<?> calculateItems(List<String> inputs) {
        List<Item> calculatedItems = itemService.calculateItems(PosDataParser.parse(inputs));
        return new ResponseEntity<>(new ItemResponse(calculatedItems), OK);
    }
}
