package com.onlineshoppractice.onlineshoppractice.controller;

import com.onlineshoppractice.onlineshoppractice.dto.AddressDTO;
import com.onlineshoppractice.onlineshoppractice.model.Address;
import com.onlineshoppractice.onlineshoppractice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

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
