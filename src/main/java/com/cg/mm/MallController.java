package com.cg.mm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/malls") // Base path set here for all the methods
public class MallController {

    @Autowired
    private MallService mallService;

    // Get all malls
    @GetMapping // Correctly uses the base path
    public List<Mall> getAllMalls() {
        return mallService.findAllMalls();
    }

    // Get a single mall by ID
    @GetMapping("/{id}") // Correctly appends the ID to the base path
    public ResponseEntity<Mall> getMallById(@PathVariable Long id) {
        try {
            Mall mall = mallService.findMallById(id).orElseThrow();
            return new ResponseEntity<>(mall, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new mall
    @PostMapping // Correctly uses the base path
    public ResponseEntity<Mall> createMall(@RequestBody Mall mall) {
        Mall savedMall = mallService.saveMall(mall);
        return new ResponseEntity<>(savedMall, HttpStatus.CREATED);
    }

    // Update existing mall
    @PutMapping("/{id}") // Correctly appends the ID to the base path
    public ResponseEntity<?> updateMall(@PathVariable Long id, @RequestBody Mall mallDetails) {
        try {
            Mall existingMall = mallService.findMallById(id).orElseThrow();
            existingMall.setName(mallDetails.getName());
            existingMall.setLocation(mallDetails.getLocation());
            final Mall updatedMall = mallService.saveMall(existingMall);
            return new ResponseEntity<>(updatedMall, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a mall
    @DeleteMapping("/{id}") // Correctly appends the ID to the base path
    public ResponseEntity<Void> deleteMall(@PathVariable Long id) {
        try {
            Mall mall = mallService.findMallById(id).orElseThrow();
            mallService.deleteMall(mall.getId());
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
