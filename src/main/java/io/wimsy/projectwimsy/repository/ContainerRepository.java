package io.wimsy.projectwimsy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.wimsy.projectwimsy.domain.Container;

@Repository
public interface ContainerRepository extends CrudRepository<Container, Long> {
	
	Container findByContainerName(String containerName);
	
}