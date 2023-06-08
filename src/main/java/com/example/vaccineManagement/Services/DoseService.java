package com.example.vaccineManagement.Services;


import com.example.vaccineManagement.Models.Dose;
import com.example.vaccineManagement.Models.User;
import com.example.vaccineManagement.Repository.DoseRepository;
import com.example.vaccineManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    UserRepository userRepository;

    public String giveDose(String doseId, Integer userId){

        User user = userRepository.findById(userId).get();

        //An Entity of that model has been created
        //This entity will be saved in the database
        Dose dose = new Dose();

        //setting its attributes
        dose.setDoseId(doseId);
        dose.setUser(user);

        //Setting the child object in that corresponding
        user.setDose(dose);

        userRepository.save(user);

        //Child will automatically get saved because of cascading effect.

        return "Dose Given to user successfully";
    }


}
