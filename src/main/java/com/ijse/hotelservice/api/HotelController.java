package com.ijse.hotelservice.api;

import com.ijse.hotelservice.dto.HotelDTO;
import com.ijse.hotelservice.entity.Hotel;
import com.ijse.hotelservice.services.HotelService;
import com.ijse.hotelservice.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/hotel")
@CrossOrigin
public class HotelController {

    @Autowired
    HotelService hotelService;

    @Autowired
    ModelMapper mapper;


    @PostMapping
    public ResponseUtil saveHotel(@RequestParam("id") Long id,
                                    @RequestParam("hotel_name") String Hotel_name,
                                    @RequestParam("hotel_category") String Hotel_category,
                                    @RequestParam("location") String location,
                                    @RequestParam("email") String email,
                                    @RequestParam("contact_01") String contact1,
                                    @RequestParam("contact_02") String contact2,
                                    @RequestParam(" pets_allow_or_not") String  pets_allow_or_not)
                                  throws IOException {
        HotelDTO hotel= new HotelDTO(id,Hotel_name,Hotel_category,location,email,contact1,contact2,pets_allow_or_not);
        System.out.println(hotel.getHotel_name());

        hotelService.addHotel(hotel);
        return new ResponseUtil("200", "Hotel Added Successfull", null);
    }


    @PutMapping
    public ResponseUtil updateHotel(@RequestParam("id") Long id,
                                    @RequestParam("hotel_name") String Hotel_name,
                                    @RequestParam("hotel_category") String Hotel_category,
                                    @RequestParam("location") String location,
                                    @RequestParam("email") String email,
                                    @RequestParam("contact_01") String contact_01,
                                    @RequestParam("contact_02") String contact_02,
                                    @RequestParam(" pets_allow_or_not") String  pets_allow_or_not) throws IOException {


        Hotel existsHotel = hotelService.findById(id);

        if ( existsHotel != null) {
            existsHotel.setHotel_name(Hotel_name);
            existsHotel.setHotel_category(Hotel_category);
            existsHotel.setLocation(location);
            existsHotel.setEmail(email);
            existsHotel.setContact_01(contact_01);
            existsHotel.setContact_02(contact_02);
            existsHotel.setPets_allow_or_not(pets_allow_or_not);


            hotelService.updateHotel(existsHotel);
            return new ResponseUtil("200", "Updated Hotel Data Successfull!", null);
        } else {
            return new ResponseUtil("404", "Hotel not found", null);
        }
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteHotel(@RequestParam Long id){

        hotelService.deleteHotel(id);
        return new ResponseUtil("200" ,id+"Deleted SuccessFull",null);

    }
    @GetMapping
    public ResponseUtil getAllHotels(){
        ArrayList<HotelDTO> hotelDTOS=hotelService.getAllHotels();

        return new ResponseUtil("200", "Show All Hotels", hotelDTOS);
    }

    @GetMapping(value = "api/search",params ="hotel_name",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseUtil searchByHotelName(@RequestParam String hotel_name){
        List<HotelDTO> hotelDTOArrayList=hotelService.searchHotelByName(hotel_name);
        return new ResponseUtil("200", hotel_name+"Searching", hotelDTOArrayList);

    }






}
