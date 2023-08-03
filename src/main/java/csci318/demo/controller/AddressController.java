package csci318.demo.controller;

import csci318.demo.repository.AddressRepository;
import csci318.demo.model.Address;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    private final AddressRepository addressRepository;

    AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/addresses")
    List<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    @GetMapping("/addresses/{id}")
    Address getAddressById(@PathVariable Long id) {
        return addressRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/addresses")
    Address createAddress(@RequestBody Address newAddress) {
        return addressRepository.save(newAddress);
    }

}
