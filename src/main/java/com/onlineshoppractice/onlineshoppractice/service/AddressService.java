package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.AddressDTO;
import com.onlineshoppractice.onlineshoppractice.model.Address;
import com.onlineshoppractice.onlineshoppractice.model.User;
import com.onlineshoppractice.onlineshoppractice.repository.AddressRepository;
import com.onlineshoppractice.onlineshoppractice.service.serviceinterface.AddressServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService implements AddressServiceInterface {

    private final AddressRepository addressRepository;

    public void createAddress(Address newAddress) {
        newAddress.setListOfUser(new ArrayList<>());
        addressRepository.save(newAddress);
    }

    public List<AddressDTO> getAllAddressDTO() {
        return addressRepository.findAll()
                .stream()
                .map(this::convertToAddressDTO)
                .collect(Collectors.toList());
    }

    public void updateAddress(Long addressId, Address updateAddress) {
        Address address = findAddressById(addressId);
        if (address != null) {
            address.setCity(updateAddress.getCity());
            address.setPostalCode(updateAddress.getPostalCode());
            address.setStreetName(updateAddress.getStreetName());
            address.setStreetNumber(updateAddress.getStreetNumber());
            address.setApartmentNumber(updateAddress.getApartmentNumber());
            address.setListOfUser(updateAddress.getListOfUser());
        }
    }

    public void removeAddress(Long addressId) {
        Address address = findAddressById(addressId);
        if (address != null) {
            for (User user : address.getListOfUser()){
                user.setAddress(null);
            }
            addressRepository.delete(address);
        }

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

    public Address findAddressById(Long addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        return address.orElse(null);
    }

}
