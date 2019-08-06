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

    public Item findByName(String name) {
    	return this.itemRepository.findByName(name);
    }
    
    public Item save(Item item) {
    	return this.itemRepository.save(item);
    }
    
    public Item updateByName(String name, String description) {
    	Item itemToUpdate = this.findByName(name);
    	itemToUpdate.setDescription(description);
    	return this.itemRepository.save(itemToUpdate);
    }
    
}