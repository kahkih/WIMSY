package io.wimsy.projectwimsy.service;

import io.wimsy.projectwimsy.domain.Item;
import io.wimsy.projectwimsy.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Iterable<Item> findAll() {
        return this.itemRepository.findAll();
    }

    public Item findByItemName(String itemName) {
    	return this.itemRepository.findByItemName(itemName);
    }
    
    public Item save(Item item) {
    	return this.itemRepository.save(item);
    }
    
    public Item updateByItemName(String itemName, String itemDescription) {
    	Item itemToUpdate = this.findByItemName(itemName);
    	itemToUpdate.setItemDescription(itemDescription);
    	return this.itemRepository.save(itemToUpdate);
    }
    
}