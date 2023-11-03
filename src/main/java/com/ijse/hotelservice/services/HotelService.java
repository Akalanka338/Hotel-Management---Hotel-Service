package com.ijse.hotelservice.services;

import com.ijse.hotelservice.dto.HotelDTO;
import com.ijse.hotelservice.entity.Hotel;


import java.util.ArrayList;
import java.util.List;

public interface HotelService {

    void  addHotel(HotelDTO hotelDTO);

    void  deleteHotel(long id);

    void updateHotel(Hotel hotelDTO);

    ArrayList<HotelDTO>getAllHotels();

    List<HotelDTO> searchHotelByName(String hotel_name);

    Hotel findById(long id);


}
