package com.cg.mm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MallService {

    @Autowired
    private MallRepository mallRepository;

    // Retrieve all malls from the database
    public List<Mall> findAllMalls() {
        return mallRepository.findAll();
    }

    // Find a single mall by ID
    public Optional<Mall> findMallById(Long id) {
        return mallRepository.findById(id);
    }

    // Save or update a mall
    public Mall saveMall(Mall mall) {
        return mallRepository.save(mall);
    }

    // Delete a mall by ID
    public void deleteMall(Long id) {
        mallRepository.deleteById(id);
    }
}
