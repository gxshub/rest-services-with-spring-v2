package csci318.demo.controller;

import csci318.demo.model.Address;
import csci318.demo.model.Library;
import csci318.demo.repository.AddressRepository;
import csci318.demo.repository.LibraryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    private final LibraryRepository libraryRepository;
    private final AddressRepository addressRepository;

    // @Autowired
    LibraryController(LibraryRepository libraryRepository, AddressRepository addressRepository) {
        this.libraryRepository = libraryRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/libraries")
    List<Library> all() {
        return libraryRepository.findAll();
    }

    @GetMapping("/libraries/{id}")
    Library findLibraryById(@PathVariable Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping("/libraries")
    Library createLibrary(@RequestBody Library newLibrary) {
        return libraryRepository.save(newLibrary);
    }

    @PutMapping("/libraries/{id}")
    Library updateLibraryName(@PathVariable Long id, @RequestBody Library library) {
        Library library1 = libraryRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        library1.setName(library.getName());
        return libraryRepository.save(library1);
    }

    @PutMapping("/libraries/{id}/address/{addressId}")
    Library updateLibraryAddress(@PathVariable Long id, @PathVariable Long addressId) {
        Library library = libraryRepository.findById(id).orElseThrow(RuntimeException::new);
        Address address = addressRepository.findById(addressId).orElseThrow(RuntimeException::new);
        library.setAddress(address);
        return libraryRepository.save(library);
    }
}
