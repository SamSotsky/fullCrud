package com.sam.fullcrud.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.sam.fullcrud.models.Travel;


@Repository
public interface TravelRepo extends CrudRepository<Travel, Long>{
	List<Travel> findAll();
}
