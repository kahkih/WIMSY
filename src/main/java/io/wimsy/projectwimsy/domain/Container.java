package io.wimsy.projectwimsy.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Container {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long containerId;
	
	@Column(nullable=false)
	private String containerName;
	
	@OneToMany
	private Set<Item> itemsInContainer = new HashSet<>();
	
	public Container() {}

	public long getContainerId() {
		return containerId;
	}

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	public Set<Item> getItemsInContainer() {
		return itemsInContainer;
	}

	public void setItemsInContainer(Set<Item> itemsInContainer) {
		this.itemsInContainer = itemsInContainer;
	}
	
	public void addItemToContainer(Item item) {
		itemsInContainer.add(item);
	}
	
	public boolean doesContainerIncludeItem(Item item) {
		return itemsInContainer.contains(item);
	}
	
	public void removeItemFromContainer(Item item) {
		itemsInContainer.remove(item);
	}
	
}