package com.example.vaccineManagement.Dtos.RequestDtos;


import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentReqDto {

    private Integer docId;

    //int --> 0

    private Integer userId;

    private Date appointmentDate;

    private LocalTime appointmentTime;

}
