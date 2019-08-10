package io.wimsy.projectwimsy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.wimsy.projectwimsy.domain.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
	
	Location findByLocationName(String locationName);

}