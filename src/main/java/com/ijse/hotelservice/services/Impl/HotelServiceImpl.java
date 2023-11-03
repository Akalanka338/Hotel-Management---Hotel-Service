package com.ijse.hotelservice.services.Impl;

import com.ijse.hotelservice.dto.HotelDTO;
import com.ijse.hotelservice.entity.Hotel;
import com.ijse.hotelservice.repo.HotelRepo;
import com.ijse.hotelservice.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    ModelMapper modelMapper;




    @Override
    public void addHotel(HotelDTO hotelDTO) {
        if (hotelRepo.existsById(hotelDTO.getId())){
            throw new RuntimeException(hotelDTO.getId()+"Already Exists");
        }

        Hotel hotel =modelMapper.map(hotelDTO,Hotel.class);
//        vehicle.setVehicle_brand(vehicleDTO.getVehicle_brand());
//        vehicle.setVehicle_img(vehicleDTO.getVehicle_img());
//        vehicle.setVehicle_category(vehicleDTO.getVehicle_category());
//        vehicle.setFuel_type(vehicleDTO.getFuel_type());
//        vehicle.getDriver_contact(vehicleDTO.getDriver_contact());

        hotelRepo.save(hotel);
    }

    @Override
    public void deleteHotel(long id) {
        if (!hotelRepo.existsById(id)){
            throw new RuntimeException("Hotel"+id+"Not Available Deleted");
        }
        hotelRepo.deleteById(id);
    }

    @Override
    public void updateHotel(Hotel hotelDTO) {
        Optional<Hotel>Byid=hotelRepo.findById(hotelDTO.getId());
        if (Byid.isEmpty()){
            throw new RuntimeException("Id doesent Exists");
        }
        hotelRepo.save(modelMapper.map(hotelDTO,Hotel.class));
    }

    @Override
    public ArrayList<HotelDTO> getAllHotels() {
        return modelMapper.map(hotelRepo.findAll(), new TypeToken<ArrayList<HotelDTO>>() {}.getType());
    }

    @Override
    public List<HotelDTO> searchHotelByName(String hotel_name) {
        return modelMapper.map(hotelRepo.findAllBy(hotel_name), new TypeToken<ArrayList<HotelDTO>>() {}.getType());
    }

    @Override
    public Hotel findById(long id) {
        if (!hotelRepo.existsById(id)){
            throw new RuntimeException("Hotel"+id+"Not Available");
        }
        Optional<Hotel>byId=hotelRepo.findById(id);
        return byId.get();
    }
}
