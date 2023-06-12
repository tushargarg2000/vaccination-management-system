package com.example.vaccineManagement.Services;


import com.example.vaccineManagement.Exceptions.VaccinationAddressNotFound;
import com.example.vaccineManagement.Models.VaccinationCenter;
import com.example.vaccineManagement.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public String addVaccinationCenter(VaccinationCenter vaccinationCenter)throws VaccinationAddressNotFound {

        if(vaccinationCenter.getAddress()==null){
            throw new VaccinationAddressNotFound("Vaccination Address is Empty");
        }

        vaccinationCenterRepository.save(vaccinationCenter);

        return "Vaccination center added at a location "+vaccinationCenter.getAddress();

    }
}
