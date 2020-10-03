package com.joraclista.agileengine.challenge.imagelookup.controller;

import com.joraclista.agileengine.challenge.imagelookup.ImageRepository;
import com.joraclista.agileengine.challenge.imagelookup.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Alisa
 * version 1.0.
 */
@RestController
@RequestMapping("/api/search")
public class SearchImagesController {

    @Autowired
    private ImageRepository repository;

    @GetMapping("/{searchTerm}")
    public ResponseEntity<List<Image>> findOne(@PathVariable String searchTerm) {
        return ResponseEntity.ok(repository.getImagesBySearchTerm(searchTerm));
    }

}