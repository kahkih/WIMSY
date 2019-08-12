package io.wimsy.projectwimsy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.wimsy.projectwimsy.domain.Container;
import io.wimsy.projectwimsy.domain.Location;
import io.wimsy.projectwimsy.service.LocationService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
public class LocationEndpoint {

	@Autowired
	LocationService locationService;
	
	@GetMapping
	public ResponseEntity<Iterable<Location>> readAllLocations() {
		return new ResponseEntity<Iterable<Location>>(locationService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="{locationName}")
	public Location findByLocationName(@PathVariable String locationName) {
		return locationService.findByLocationName(locationName);
	}
	
	@GetMapping(path="{locationName}/{containerName}")
	public Container findByContainerName(@PathVariable String locationName, @PathVariable String containerName) {
		return locationService.findByContainerName(locationName, containerName);
	}
	
}