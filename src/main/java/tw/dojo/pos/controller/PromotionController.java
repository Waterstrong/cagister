package tw.dojo.pos.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.dojo.pos.service.PromotionService;

@RestController
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @RequestMapping(method = POST, value = "/promotion/discount/{barcode}/{percent}")
    public ResponseEntity<?> createPercentDiscount(@PathVariable("barcode") String barcode,
                                                @PathVariable("percent") Integer percent) {
        promotionService.createPercentDiscount(barcode, percent);
        return new ResponseEntity<>(CREATED);
    }

}
