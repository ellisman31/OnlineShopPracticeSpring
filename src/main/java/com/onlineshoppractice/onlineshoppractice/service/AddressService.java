package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.AddressDTO;
import com.onlineshoppractice.onlineshoppractice.model.Address;
import com.onlineshoppractice.onlineshoppractice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void createAddress(Address address) {
        address.setListOfUser(new ArrayList<>());
        addressRepository.save(address);
    }

    public List<AddressDTO> getAllAddressDTO() {
        return addressRepository.findAll()
                .stream()
                .map(this::convertToAddressDTO)
                .collect(Collectors.toList());
    }

    private AddressDTO convertToAddressDTO(Address address) {
        AddressDTO newAddressDTO = new AddressDTO();

        newAddressDTO.setCity(address.getCity());
        newAddressDTO.setPostalCode(address.getPostalCode());
        newAddressDTO.setStreetName(address.getStreetName());
        newAddressDTO.setStreetNumber(address.getStreetNumber());
        newAddressDTO.setApartmentNumber(address.getApartmentNumber());
        newAddressDTO.setListOfUser(address.getListOfUser());

        return newAddressDTO;
    }

}
