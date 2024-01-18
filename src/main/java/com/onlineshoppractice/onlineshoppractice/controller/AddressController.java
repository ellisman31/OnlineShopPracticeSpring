package com.onlineshoppractice.onlineshoppractice.controller;

import com.onlineshoppractice.onlineshoppractice.dto.AddressDTO;
import com.onlineshoppractice.onlineshoppractice.model.Address;
import com.onlineshoppractice.onlineshoppractice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getAllAddress")
    @ResponseBody
    public List<AddressDTO> getAllAddress() {
        return addressService.getAllAddressDTO();
    }

    @PostMapping("/createAddress")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
    }
}
