package io.wimsy.projectwimsy.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.wimsy.projectwimsy.domain.Container;
import io.wimsy.projectwimsy.domain.Form;
import io.wimsy.projectwimsy.domain.Item;

@Service
@Transactional
public class FormService {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ContainerService containerService;
	
	public void save(Form form) {
		
		if (itemService.findByItemName(form.getItemName()) == null && containerService.findByContainerName(form.getContainerName()) == null) {
			
			Item item = new Item();
			Container container = new Container();
			
			item.setItemName(form.getItemName());
			item.setItemDescription(form.getItemDescription());
			container.setContainerName(form.getContainerName());
			
			container.addItemToContainer(item);
			
			this.itemService.save(item);
			this.containerService.save(container);
			
		} else if (itemService.findByItemName(form.getItemName()) == null && containerService.findByContainerName(form.getContainerName()) != null) {
			
			Item item = new Item();
			Container container = containerService.findByContainerName(form.getContainerName());
			
			item.setItemName(form.getItemName());
			item.setItemDescription(form.getItemDescription());
			
			container.addItemToContainer(item);
			
			this.itemService.save(item);
			this.containerService.save(container);
			
		}
		
	}
	
}