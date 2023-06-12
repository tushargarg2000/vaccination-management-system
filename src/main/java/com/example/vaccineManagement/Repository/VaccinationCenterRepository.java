package com.example.vaccineManagement.Repository;

import com.example.vaccineManagement.Models.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {
}
