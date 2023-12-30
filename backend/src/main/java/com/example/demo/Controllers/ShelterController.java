package com.example.demo.Controllers;

import com.example.demo.Entities.AccountEntites.shelter;
import com.example.demo.Entities.PetEntities.pet;
import com.example.demo.Entities.AccountEntites.staff;
import com.example.demo.Services.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shelter")
public class ShelterController {

    private final ShelterService shelterService;


    @Autowired
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @RequestMapping("/getShelterInfo")
    public shelter getShelterInfo(@RequestParam int shelterID) {
        return shelterService.ViewShelterInformation(shelterID);
    }

    @RequestMapping("/getShelterPets")
    public List<pet> getShelterPets(@RequestParam int shelterID) {
        return shelterService.ViewShelterPets(shelterID);
    }

    @RequestMapping("/getShelterStaff")
    public List<staff> getShelterStaff(@RequestParam int shelterID) {
        return shelterService.ViewShelterStaff(shelterID);
    }

    @RequestMapping("/applications")
    public Map<String, List<?>> getShelterApplications(@RequestParam int shelterID) {
        Map<String, List<?>> applications = new java.util.HashMap<>();
        applications.put("open", shelterService.ViewAdoptionApplications_Current(shelterID));
        applications.put("closed", shelterService.ViewAdoptionApplications_History(shelterID));
        return applications;
    }

    @RequestMapping("/setApplicationUnderReview")
    public String setApplicationUnderReview(@RequestParam int petID, @RequestParam int adopterID, @RequestParam int shelterID) {
        return shelterService.AcceptAdoptionApplication_UnderReview(petID, adopterID, shelterID);
    }

    @RequestMapping("/setApplicationInProgress")
    public String setApplicationInProgress(@RequestParam int petID, @RequestParam int adopterID, @RequestParam int shelterID) {
        return shelterService.AcceptAdoptionApplication_InProgress(petID, adopterID, shelterID);
    }



}
