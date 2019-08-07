package io.wimsy.projectwimsy.api;

import io.wimsy.projectwimsy.domain.Item;
import io.wimsy.projectwimsy.service.ContainerService;
import io.wimsy.projectwimsy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
public class ItemEndpoint {
	
	@Autowired
    ItemService itemService;
	
	@Autowired
	ContainerService containerService;

	@GetMapping(path="item")
	public ResponseEntity<Iterable<Item>> readAllItems() {
		return new ResponseEntity<Iterable<Item>>(this.itemService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("item/{itemName}")
    public Item findByItemName(@PathVariable String itemName) {
		return this.itemService.findByItemName(itemName);
    }

    @PostMapping("item")
    public Item newItem(@RequestBody Item item) {
        return this.itemService.save(item);
    }
    
    @PutMapping("item/{itemName}/{itemDescription}")
    public Item putById(@PathVariable String itemName, @PathVariable String itemDescription) {
    	return this.itemService.updateByItemName(itemName, itemDescription);
    } 
    
}