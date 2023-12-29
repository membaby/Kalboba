package com.example.demo.Services;

import com.example.demo.Entities.AccountEntites.shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MangerService {

    @Autowired
    public MangerService() {
    }

    /*public void EditProfile() {
        // TODO implement here
    }*/

    public void EditShelterInformation(shelter myshelter) {
        // TODO implement here
    }

    public void AddStaffToShelter(String staffEmail,Integer shelterID) {
        // TODO implement here
    }

    public void RemoveStaffFromShelter(String staffEmail,Integer shelterID) {
        // TODO implement here
    }

    public void AddShelter(shelter newShelter) {
        // TODO implement here
    }


}
