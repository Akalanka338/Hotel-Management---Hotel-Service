package com.ijse.hotelservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String hotel_name;
    @Column(nullable = false)
    private String hotel_category;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String contact_01;
    @Column(nullable = false)
    private String contact_02;
    @Column(nullable = false)
    private String pets_allow_or_not;


}
