package com.example.demo.Controllers;

import com.example.demo.Entities.PetEntities.pet;
import com.example.demo.Services.SearchService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class SearchController {

    private final SearchService searchService;


    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public List<pet> searchForPets(@RequestParam Map<String, String> searchParams) {
        return searchService.searchPets(searchParams, 0);
    }


}
