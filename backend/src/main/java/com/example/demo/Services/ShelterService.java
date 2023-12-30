package com.example.demo.Services;

import com.example.demo.Entities.AccountEntites.shelter;
import com.example.demo.Entities.AccountEntites.staff;
import com.example.demo.Repositories.RelationRepositories.shelterRepository;
import com.example.demo.Repositories.RelationRepositories.sheltered_atRepository;
import com.example.demo.Repositories.RelationRepositories.works_atRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterService {

    private shelterRepository shelterrepository;
    private works_atRepository works_atrepository;
    private sheltered_atRepository sheltered_atrepository;
    @Autowired
    public ShelterService(
            shelterRepository shelterrepository,
            works_atRepository works_atrepository,
            sheltered_atRepository sheltered_atrepository
    ) {
        this.shelterrepository = shelterrepository;
        this.works_atrepository = works_atrepository;
        this.sheltered_atrepository = sheltered_atrepository;
    }

    public shelter ViewShelterInformation(int shelterID) {
        shelter Myshelter = shelterrepository.findById(shelterID).orElse(null);
        return Myshelter;
        // TODO implement here
    }

    public List<staff> ViewShelterStaff() {
        // TODO implement here
        return null;
    }

    public void ViewShelterPets() {
        // TODO implement here
    }

    public void ViewShelterReviews() {
        // TODO implement here
    }

    public void ViewAdoptionApplications_Current() {
        // TODO implement here
    }

    public void ViewAdoptionApplications_History() {
        // TODO implement here
    }

    public String AcceptAdoptionApplication_InProgress() {
        // TODO implement here
        return null;
    }

    public String AcceptAdoptionApplication_Done() {
        // TODO implement here
        return null;
    }

    public String RejectAdoptionApplication() {
        // TODO implement here
        return null;
    }

    public String AddPet() {
        // TODO implement here
        return null;
    }

    public String EditPetInformation(){
        // TODO implement here
        return null;
    }

    public String AddDocumentForThePet() {
        // TODO implement here
        return null;
    }

    public String RemovePet() {
        // TODO implement here
        return null;
    }

}
