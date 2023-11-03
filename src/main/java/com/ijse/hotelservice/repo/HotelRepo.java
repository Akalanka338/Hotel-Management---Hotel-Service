package com.ijse.hotelservice.repo;

import com.ijse.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long> {


    void deleteById(long id);

    @Query(value = "SELECT v FROM Hotel v WHERE v.hotel_name = :hotel_name")
   ArrayList<Hotel> findAllBy(String hotel_name);


}
