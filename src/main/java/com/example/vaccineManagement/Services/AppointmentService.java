package com.example.vaccineManagement.Services;


import com.example.vaccineManagement.Dtos.RequestDtos.AppointmentReqDto;
import com.example.vaccineManagement.Enums.Gender;
import com.example.vaccineManagement.Exceptions.DoctorNotFound;
import com.example.vaccineManagement.Exceptions.UserNotFound;
import com.example.vaccineManagement.Models.Appointment;
import com.example.vaccineManagement.Models.Doctor;
import com.example.vaccineManagement.Models.User;
import com.example.vaccineManagement.Repository.AppointmentRepository;
import com.example.vaccineManagement.Repository.DoctorRepository;
import com.example.vaccineManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender emailSender;

    public String bookAppointment(AppointmentReqDto appointmentReqDto)throws DoctorNotFound, UserNotFound {

        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentReqDto.getDocId()); //null/0
        if(!doctorOptional.isPresent()){
            throw new DoctorNotFound("DoctorId not found");
        }
        Optional<User> userOptional = userRepository.findById(appointmentReqDto.getUserId());
        if(!userOptional.isPresent()){
            throw new UserNotFound("UserId not found");
        }
        Doctor doctor = doctorOptional.get();
        User user = userOptional.get();

        Appointment appointment = new Appointment();

        //Creating the object and setting of its attributes
        appointment.setAppointmentDate(appointmentReqDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentReqDto.getAppointmentTime());
        //Setting the foreign key attributes
        appointment.setDoctor(doctor);
        appointment.setUser(user);

        //Saving it before so that I can get the PK of the appointment table...
        appointment = appointmentRepository.save(appointment);

        doctor.getAppointmentList().add(appointment);
        user.getAppointmentList().add(appointment);

        doctorRepository.save(doctor);
        userRepository.save(user);

        //Send an email to the sender

        String body = " Hi ! "+user.getName()+"\n" +
                "You have successfully booked an appointment on "+appointment.getAppointmentDate() + "at "+appointment.getAppointmentTime()+"\n"+
                "You doctor is "+doctor.getName()+ "\n"+
                "Please reach at "+doctor.getVaccinationCenter().getAddress()+"\n"
                + "Mask is mandatory";


        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("springacciojob@gmail.com");
        mailMessage.setTo(user.getEmailId());
        mailMessage.setSubject("Appointment Confirmed !!");
        mailMessage.setText(body);

        emailSender.send(mailMessage);


        String enteredString

                if(enteredString.equals(Gender.FEMALE)|| enteredString.equals(Gender.MALE))



        return "Appointment booked successfully";

    }

}
