package io.wimsy.projectwimsy.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long locationId;
	
	@Column(nullable=false)
	private String locationName;
	
	@OneToMany
	private Set<Container> containersInLocation = new HashSet<>();
	
	public Location() {}

	public long getLocationId() {
		return locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Set<Container> getContainersInLocation() {
		return containersInLocation;
	}

	public void setContainersInLocation(Set<Container> containersInLocation) {
		this.containersInLocation = containersInLocation;
	}
	
	public void addContainerToLocation(Container container) {
		containersInLocation.add(container);
	}
	
	public boolean doesLocationIncludeContainer(Container container) {
		return containersInLocation.contains(container);
	}
	
//	public void removeContainerFromLocation(Container container) {
//		containersInLocation.remove(container);
//	}
	
}