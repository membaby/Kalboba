package com.example.demo.Services;

import com.example.demo.Entities.AccountEntites.adopter;
import com.example.demo.Entities.AccountEntites.shelter;
import com.example.demo.Entities.PetEntities.pet;
import com.example.demo.Entities.RecordsEntities.Status;
import com.example.demo.Entities.RecordsEntities.adoption_application_open;
import com.example.demo.Repositories.AccountRepositories.adopterRepository;
import com.example.demo.Repositories.AccountRepositories.shelterRepository;
import com.example.demo.Repositories.PetRepositories.petRepository;
import com.example.demo.Repositories.RecordsRepositories.adoption_application_openRepository;
import com.example.demo.Repositories.RelationRepositories.adopted_byRepository;
import com.example.demo.Repositories.RelationRepositories.sheltered_atRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdopterService {
    private shelterRepository shelterrepository;
    private sheltered_atRepository sheltered_atrepository;
    private petRepository petrepository;
    private adopterRepository adopterrepository;
    private adoption_application_openRepository adoption_application_openrepository;
    private adopted_byRepository adopted_byrepository;
    @Autowired
    public AdopterService(
            shelterRepository shelterrepository,
            sheltered_atRepository sheltered_atrepository,
            petRepository petrepository,
            adopterRepository adopterrepository,
            adoption_application_openRepository adoption_application_openrepository,
            adopted_byRepository adopted_byrepository
    ) {
        this.shelterrepository = shelterrepository;
        this.sheltered_atrepository = sheltered_atrepository;
        this.petrepository = petrepository;
        this.adopterrepository = adopterrepository;
        this.adoption_application_openrepository = adoption_application_openrepository;
        this.adopted_byrepository = adopted_byrepository;
    }

    public String ApplyForAdoption(adoption_application_open application) {
        int petId = application.getPet_id();
        int adopterId = application.getAdopter_id();
        pet myPet = petrepository.findById(petId).orElse(null);
        if (myPet == null) {
            return "Pet not found";
        }
        adopter myAdopter = adopterrepository.findById(adopterId).orElse(null);
        if (myAdopter == null) {
            return "Adopter not found";
        }
        shelter myShelter = sheltered_atrepository.findShelterBypet_id(petId);
        if (myShelter == null) {
            return "Shelter not found";
        }

        application.setShelter_id(myShelter.getId());
        application.setStatus(Status.Unopened);
        application.setPet(myPet);
        application.setAdopter(myAdopter);
        application.setShelter(myShelter);
        adoption_application_openrepository.save(application);
        return "Success";
    }

    public List<pet> ViewAdoptedAnimals(Integer adopterID) {
        List<pet> petList = adopted_byrepository.findPetsByadopter_id(adopterID);
        return petList;
        // TODO implement here
    }

    public List<adoption_application_open> ViewAdoptionApplications(Integer adopterID) {
        List<adoption_application_open> adoption_application_openList = adoption_application_openrepository.findAdoption_application_opensByadopter_id(adopterID);
        return adoption_application_openList;
        // TODO implement here
    }

    public String AboutMe(Integer adopterID) {
        String aboutMe = adopterrepository.findById(adopterID).orElse(null).getAbout();
        return aboutMe;
        // TODO implement here
    }

    public String EditAboutMe(Integer adopterID, String aboutMe) {
        adopter myAdopter = adopterrepository.findById(adopterID).orElse(null);
        myAdopter.setAbout(aboutMe);
        adopterrepository.save(myAdopter);
        return "Success";
        // TODO implement here
    }

    /*public void EditMyProfile() {
        // TODO implement here
    }*/

}
