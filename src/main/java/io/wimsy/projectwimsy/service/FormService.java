package io.wimsy.projectwimsy.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.wimsy.projectwimsy.domain.Container;
import io.wimsy.projectwimsy.domain.Form;
import io.wimsy.projectwimsy.domain.Item;
import io.wimsy.projectwimsy.domain.Location;

@Service
@Transactional
public class FormService {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ContainerService containerService;
	
	@Autowired
	LocationService locationService;
	
	public void save(Form form) {
		
		Item item;
		Container container;
		Location location;
		
		boolean isNewItem = itemService.findByItemName(form.getItemName()) == null;
		boolean isNewContainer = containerService.findByContainerName(form.getContainerName()) == null;
		boolean isNewLocation = locationService.findByLocationName(form.getLocationName()) == null;
		
		if (isNewItem && isNewContainer && isNewLocation) {
			
			item = new Item();
			container = new Container();
			location = new Location();
			
			item.setItemName(form.getItemName());
			item.setItemDescription(form.getItemDescription());
			
			itemService.save(item);
			
			container.setContainerName(form.getContainerName());
			container.addItemToContainer(item);
			
			containerService.save(container);
			
			location.setLocationName(form.getLocationName());
			location.addContainerToLocation(container);
			
			locationService.save(location);
			
		} else if (isNewItem && isNewContainer && !isNewLocation) {
			
			item = new Item();
			container = new Container();
			location = locationService.findByLocationName(form.getLocationName());
			
			item.setItemName(form.getItemName());
			item.setItemDescription(form.getItemDescription());
			
			itemService.save(item);
			
			container.setContainerName(form.getContainerName());
			container.addItemToContainer(item);
			
			containerService.save(container);
			
			location.addContainerToLocation(container);
			
			locationService.save(location);
			
		} else if (isNewItem && !isNewContainer && !isNewLocation) {
			
			item = new Item();
			container = containerService.findByContainerName(form.getContainerName());
			location = locationService.findByLocationName(form.getLocationName());
			
			if (location.doesLocationIncludeContainer(container)) {
				
				item.setItemName(form.getItemName());
				item.setItemDescription(form.getItemDescription());
				
				itemService.save(item);
				
				container.addItemToContainer(item);
				
				containerService.save(container);
				
				location.addContainerToLocation(container);
				
				locationService.save(location);
				
			}
			
		}
		
	}
	
	public void move(Form form) {
		
		Item item;
		Container container;
		Location location;
		
		boolean isNewItem = itemService.findByItemName(form.getItemName()) == null;
		boolean isNewContainer = containerService.findByContainerName(form.getContainerName()) == null;
		boolean isNewLocation = locationService.findByLocationName(form.getLocationName()) == null;
		
		if (!isNewItem && !isNewContainer && !isNewLocation) {
			
			item = itemService.findByItemName(form.getItemName()); // Te verplaatsen item
			container = containerService.findByContainerName(form.getContainerName()); // Doel container (evt. de huidige)
			location = locationService.findByLocationName(form.getLocationName()); // Doel location (evt. de huidige)
			
			
			

		} else if (itemService.findByItemName(form.getItemName()) != null && containerService.findByContainerName(form.getContainerName()) == null) {
			
//			oldItemEntry = itemService.findByItemName(form.getItemName());
//			newContainer = new Container();
//			
//			itemService.delete(oldItemEntry);
//			
//			newItemEntry = new Item();
//			newItemEntry.setItemName(oldItemEntry.getItemName());
//			newItemEntry.setItemDescription(oldItemEntry.getItemDescription());
//			
//			itemService.save(newItemEntry);
//			
//			newContainer.setContainerName(form.getContainerName());
//			newContainer.addItemToContainer(newItemEntry);
//			
//			containerService.save(newContainer);
			
		}
		
	}
	
}