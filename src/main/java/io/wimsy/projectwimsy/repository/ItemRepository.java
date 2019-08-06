package io.wimsy.projectwimsy.repository;

import io.wimsy.projectwimsy.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	
	Item findByName(String name);

}