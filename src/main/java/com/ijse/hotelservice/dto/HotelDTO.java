package com.ijse.hotelservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

public class HotelDTO {
    private long id;
    private String hotel_name;
    private String hotel_category;
    private String location;
    private String email;
    private String contact_01;
    private String contact_02;
    private String pets_allow_or_not;

}
