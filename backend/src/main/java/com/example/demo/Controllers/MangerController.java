package com.example.demo.Controllers;

import com.example.demo.Entities.AccountEntites.shelter;
import com.example.demo.Services.MangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/manager")
public class MangerController {

    private final MangerService mangerService;


    @Autowired
    public MangerController(MangerService mangerService) {
        this.mangerService = mangerService;
    }

    @RequestMapping("/updateShelterInfo")
    public String UpdateShelterInfo(@RequestBody shelter shelter_info) {
        return mangerService.EditShelterInformation(shelter_info);
    }

    @RequestMapping("/createShelter")
    public String CreateShelter(@RequestBody shelter shelter_info, @RequestParam int managerId) {
        return mangerService.AddShelter(shelter_info, managerId);
    }

    @RequestMapping(value="/getShelters", method=RequestMethod.GET)
    public Iterable<shelter> GetShelters(@RequestParam int managerId) {
        return mangerService.ViewShelters(managerId);
    }

    @RequestMapping("/addStaff")
    public String AddStaff(@RequestParam String staffEmail, @RequestParam Integer shelterID, @RequestParam String staffType) {
        return mangerService.AddStaffToShelter(staffEmail, shelterID, staffType);
    }

    @RequestMapping("/removeStaff")
    public String RemoveStaff(@RequestParam String staffEmail, @RequestParam Integer shelterID) {
        return mangerService.RemoveStaffFromShelter(staffEmail, shelterID);
    }
}
