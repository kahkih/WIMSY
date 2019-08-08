package io.wimsy.projectwimsy.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.wimsy.projectwimsy.domain.Container;
import io.wimsy.projectwimsy.repository.ContainerRepository;

@Service
@Transactional
public class ContainerService {

	@Autowired
	ContainerRepository containerRepository;
	
	public Iterable<Container> findAll() {
		return containerRepository.findAll();
	}
	
	public Container findByContainerName(String containerName) {
		return containerRepository.findByContainerName(containerName);
	}
	
	public Container save(Container container) {
		return containerRepository.save(container);
	}
	
}