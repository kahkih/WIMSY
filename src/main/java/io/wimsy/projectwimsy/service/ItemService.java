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

    public Item findByItemName(String itemName) {
    	return itemRepository.findByItemName(itemName);
    }
    
    public Item save(Item item) {
    	return itemRepository.save(item);
    }
    
    public void delete(Item item) {
    	itemRepository.delete(item);
    }
    
}