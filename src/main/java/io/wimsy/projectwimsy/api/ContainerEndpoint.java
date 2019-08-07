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
import io.wimsy.projectwimsy.service.ContainerService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
public class ContainerEndpoint {
	
	@Autowired
	ContainerService containerService;
	
	@GetMapping(path="containers")
	public ResponseEntity<Iterable<Container>> readAllContainers() {
		return new ResponseEntity<Iterable<Container>>(this.containerService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="containers/{containerName}")
	public Container findByContainerName(@PathVariable String containerName) {
		return this.containerService.findByContainerName(containerName);
	}
	
}