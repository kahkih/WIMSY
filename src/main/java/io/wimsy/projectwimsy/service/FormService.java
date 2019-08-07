package io.wimsy.projectwimsy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.wimsy.projectwimsy.domain.Container;
import io.wimsy.projectwimsy.domain.Form;
import io.wimsy.projectwimsy.domain.Item;
import io.wimsy.projectwimsy.repository.ContainerRepository;
import io.wimsy.projectwimsy.repository.ItemRepository;

@Service
@Transactional
public class FormService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ContainerRepository containerRepository;
	
	public void save(Form form) {
		
		Item item = new Item();
		Container container = new Container();
		
		item.setItemName(form.getItemName());
		item.setItemDescription(form.getItemDescription());
		container.setContainerName(form.getContainerName());
		container.addItemToContainer(item);
		
		this.itemRepository.save(item);
		this.containerRepository.save(container);
		
	}
	
}