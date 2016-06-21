package tw.dojo.pos.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.dojo.pos.domain.Goods;
import tw.dojo.pos.service.GoodsService;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(method = POST, value = "/goods")
    public ResponseEntity<?> saveGoods(@RequestBody Goods goods) {
        return new ResponseEntity<>(goodsService.saveGoods(goods), CREATED);
    }

}
