package com.example.vaccineManagement.Repository;


import com.example.vaccineManagement.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    public Doctor findByEmailId(String emailId);

}
