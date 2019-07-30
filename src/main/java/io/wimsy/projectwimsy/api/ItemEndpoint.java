package io.wimsy.projectwimsy.api;

import io.wimsy.projectwimsy.domain.Item;
import io.wimsy.projectwimsy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
produces = MediaType.APPLICATION_JSON_VALUE
)
public class ItemEndpoint {
@Autowired
    ItemService itemService;

@GetMapping(path = "item")
public ResponseEntity<Iterable<Item>> readAllItems() {
    return new ResponseEntity<Iterable<Item>>(this.itemService.findAll(), HttpStatus.OK);
}

@RequestMapping()

}
