package com.example.demo.Services;

import com.example.demo.Entities.PetEntities.pet;
import com.example.demo.EntitySearch.SearchFilter;
import com.example.demo.EntitySearch.SearchSpecification;
import com.example.demo.Repositories.PetRepositories.petRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {

    private final petRepository petRepository;

    @Autowired
    public SearchService(petRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<pet> searchPets(Map<String, String> searchParams, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return petRepository.findAll(createSearchSpecification(searchParams), pageable).getContent();
    }

    private <T> Specification<T> createSearchSpecification(Map<String, String> searchParams) {
        SearchSpecification<T> searchSpecification = new SearchSpecification<>();
        List<Specification<T>> specifications = new ArrayList<>();
        for (Map.Entry<String, String> entry : searchParams.entrySet()) {
            SearchFilter searchFilter = SearchFilter.builder()
                    .field(entry.getKey())
                    .operator(SearchFilter.QueryOperator.LIKE)
                    .value(entry.getValue())
                    .build();
            specifications.add(searchSpecification.createSpecification(searchFilter));
        }
        return searchSpecification.intersection(specifications);
    }
}
