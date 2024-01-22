package com.onlineshoppractice.onlineshoppractice.service.serviceinterface;

import com.onlineshoppractice.onlineshoppractice.dto.AddressDTO;
import com.onlineshoppractice.onlineshoppractice.model.Address;

import java.util.List;

public interface AddressServiceInterface {

    void createAddress(Address newAddress);
    List<AddressDTO> getAllAddressDTO();
    void updateAddress(Long addressId, Address updateAddress);
    void removeAddress(Long addressId);
    Address findAddressById(Long addressId);

}
