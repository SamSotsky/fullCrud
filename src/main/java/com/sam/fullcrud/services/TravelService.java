package com.sam.fullcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sam.fullcrud.models.Travel;
import com.sam.fullcrud.repo.TravelRepo;



@Service
public class TravelService {
	 // adding the book repository as a dependency
    private final TravelRepo travelRepo;
    
    public TravelService(TravelRepo travelRepo) {
        this.travelRepo = travelRepo;
    }
    
    
    
    
    
    
    // returns all the books
    public List<Travel> allTravels() {
        return travelRepo.findAll();
    }
    
    // creates a book
    public Travel createTravel(Travel b) {
        return travelRepo.save(b);
    }
    // retrieves a book
    public Travel findTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepo.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
    
 // UPDATE a book
    public Travel updateTravel(Travel b) {
        return travelRepo.save(b);
    }
    
//    Deletes a book
    public void deleteTravel(Long id) {
    	travelRepo.deleteById(id);
    }
}
