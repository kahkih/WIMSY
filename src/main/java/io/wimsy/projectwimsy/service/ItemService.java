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

}
