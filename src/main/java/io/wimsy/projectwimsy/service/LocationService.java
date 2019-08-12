package io.wimsy.projectwimsy.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.wimsy.projectwimsy.domain.Container;
import io.wimsy.projectwimsy.domain.Location;
import io.wimsy.projectwimsy.repository.LocationRepository;

@Service
@Transactional
public class LocationService {

	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	ContainerService containerService;
	
	public Iterable<Location> findAll() {
		return locationRepository.findAll();
	}
	
	public Location findByLocationName(String locationName) {
		return locationRepository.findByLocationName(locationName);
	}
	
	public Location save(Location location) {
		return locationRepository.save(location);
	}
	
	public Container findByContainerName(String locationName, String containerName) {
		
		Location location = findByLocationName(locationName);
		Container container = containerService.findByContainerName(containerName);
		
		if (location != null && location.doesLocationIncludeContainer(container)) {
			
			return containerService.findByContainerName(containerName);
			
		} else {
			
			return null;
			
		}
		
	}
	
}