package com.vmo.springboot.Demo.services;

import com.vmo.springboot.Demo.constant.EProcess;
import com.vmo.springboot.Demo.constant.Status;
import com.vmo.springboot.Demo.dto.Request.ApartmentRequestDto;
import com.vmo.springboot.Demo.dto.Respone.ApartmentResponseDto;
import com.vmo.springboot.Demo.model.Apartment;
import com.vmo.springboot.Demo.model.Leases;
import com.vmo.springboot.Demo.repositories.IApartmentRepository;
import com.vmo.springboot.Demo.repositories.ILeasesRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ApartmentSeviceImpl  {
    @Autowired
     IApartmentRepository iApartmentRepository;
    @Autowired
    ILeasesRepository iLeasesRepository;

    public Apartment add(ApartmentRequestDto apartmentRequestDto) {
        Apartment apartment = new Apartment(
                apartmentRequestDto.getName(),
                apartmentRequestDto.getArea(),
                apartmentRequestDto.getPrice(),
                apartmentRequestDto.getBathroom(),
                apartmentRequestDto.getBedroom(),
                apartmentRequestDto.getStatus(),
                apartmentRequestDto.getImage()
        );
        iApartmentRepository.save(apartment);
        return apartment;

    }

    public ApartmentResponseDto getApartmentDetails(Apartment apartment) {
        Leases leases = iLeasesRepository.findAllByApartmentAndStatus(apartment, EProcess.PROCESSING.getId()).get(0);

        ApartmentResponseDto apartmentResponseDto = new ApartmentResponseDto(
                apartment.getId(),
                apartment.getName(),
                apartment.getStatus(),
                apartment.getArena(),
                apartment.getBedroom(),
                apartment.getBathroom(),
                apartment.getImage(),
                apartment.getPrice(),
                leases.getTenant()
        );
        return apartmentResponseDto;
    }

    public List<Apartment> getApartmentByNameContaining(String name) {
        return iApartmentRepository.findByNameContaining(name);
    }

    @Transactional
    public void deleteApartment(Apartment apartment) {
        apartment.setStatus(Status.DISABLE.getId());
        iApartmentRepository.save(apartment);
    }

    @Transactional
    public Apartment updateApartment(ApartmentRequestDto apartmentRequestDto, Apartment apartment) {

        if (!apartment.getName().equalsIgnoreCase(apartmentRequestDto.getName())) {
            if (checkDuplicateName(apartmentRequestDto.getName()) == true) {
                return null;
            }
            apartment.update(apartmentRequestDto);
            iApartmentRepository.save(apartment);

            return apartment;
        }
        apartment.update(apartmentRequestDto);
        iApartmentRepository.save(apartment);

        return apartment;
    }

    public boolean checkDuplicateName(String name) {
        return iApartmentRepository.findByName(name) != null;
    }

    public List<Apartment> getall() {

        return iApartmentRepository.findAll();
    }


    public Apartment getone(int id) {
        return this.iApartmentRepository.findById(id).orElse(null);
    }

    public Apartment getByIdApartment(Integer id) {
        if (iApartmentRepository.findById(id).isPresent()) {
            return iApartmentRepository.findById(id).get();
        }
        return null;
    }
}
