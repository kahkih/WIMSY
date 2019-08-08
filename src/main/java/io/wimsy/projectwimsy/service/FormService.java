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
		
		Item item;
		Container container;
		
		if (itemService.findByItemName(form.getItemName()) == null && containerService.findByContainerName(form.getContainerName()) == null) {
			
			item = new Item();
			container = new Container();
			
			item.setItemName(form.getItemName());
			item.setItemDescription(form.getItemDescription());
			
			itemService.save(item);
			
			container.setContainerName(form.getContainerName());
			container.addItemToContainer(item);
			
			containerService.save(container);
			
		} else if (itemService.findByItemName(form.getItemName()) == null && containerService.findByContainerName(form.getContainerName()) != null) {
			
			item = new Item();
			container = containerService.findByContainerName(form.getContainerName());
			
			item.setItemName(form.getItemName());
			item.setItemDescription(form.getItemDescription());
			
			itemService.save(item);
			
			container.addItemToContainer(item);
			
			containerService.save(container);
			
		}
		
	}
	
	public void move(Form form) {
		
		Item oldItemEntry;
		Item newItemEntry;
		Container newContainer;
		
		if (itemService.findByItemName(form.getItemName()) != null && containerService.findByContainerName(form.getContainerName()) != null) {
			
			oldItemEntry = itemService.findByItemName(form.getItemName());
			newContainer = containerService.findByContainerName(form.getContainerName());
			
			itemService.delete(oldItemEntry);
			
			newItemEntry = new Item();
			newItemEntry.setItemName(oldItemEntry.getItemName());
			newItemEntry.setItemDescription(oldItemEntry.getItemDescription());
			
			itemService.save(newItemEntry);
			
			newContainer.addItemToContainer(newItemEntry);
			
			containerService.save(newContainer);
			
		} else if (itemService.findByItemName(form.getItemName()) != null && containerService.findByContainerName(form.getContainerName()) == null) {
			
			oldItemEntry = itemService.findByItemName(form.getItemName());
			newContainer = new Container();
			
			itemService.delete(oldItemEntry);
			
			newItemEntry = new Item();
			newItemEntry.setItemName(oldItemEntry.getItemName());
			newItemEntry.setItemDescription(oldItemEntry.getItemDescription());
			
			itemService.save(newItemEntry);
			
			newContainer.setContainerName(form.getContainerName());
			newContainer.addItemToContainer(newItemEntry);
			
			containerService.save(newContainer);
			
		}
		
	}
	
}