package com.bottomline.app.autocomplete;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends CrudRepository<Name, Integer> {

	public static final String FIND_NAMES = "SELECT name FROM name";

	@Query(value = FIND_NAMES, nativeQuery = true)
	public List<String> findAllNames();
	
}
