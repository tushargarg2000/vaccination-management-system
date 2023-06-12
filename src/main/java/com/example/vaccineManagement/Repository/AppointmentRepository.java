package com.example.vaccineManagement.Repository;

import com.example.vaccineManagement.Models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
