package com.vmo.springboot.Demo.controllers;


import com.vmo.springboot.Demo.dto.Request.ApartmentRequestDto;
import com.vmo.springboot.Demo.dto.Respone.ApartmentResponseDto;
import com.vmo.springboot.Demo.dto.Respone.ResponseDto;
import com.vmo.springboot.Demo.model.Apartment;

import com.vmo.springboot.Demo.services.ApartmentSeviceImpl;
import com.vmo.springboot.Demo.services.Interface.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApartmentController extends ResponseController {

    @Autowired
    ApartmentSeviceImpl apartmentService;

    @PostMapping("/apa/add")
    public ResponseEntity<ResponseDto> createApartment(@Valid @RequestBody ApartmentRequestDto apartmentRequestDto) {
        try {

            Apartment apartment = apartmentService.add(apartmentRequestDto);
            return responseUtil.getSuccessResponse(apartment);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/apa/all")
    public ResponseEntity<ResponseDto> getAllApartment() {
        try {
            List<Apartment> apartments = apartmentService.getall();
            return responseUtil.getSuccessResponse(apartments);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "apa/{id}")
    public ResponseEntity<ResponseDto> getApartment(@PathVariable("id") Integer id) {
        try {
            Apartment apartment = apartmentService.getByIdApartment(id);

            return responseUtil.getSuccessResponse(apartment);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping(value = "apa/{id}")
    public ResponseEntity<ResponseDto> deleteApartment(@PathVariable("id") Integer id) {
        try {
            Apartment apartment = apartmentService.getByIdApartment(id);

            apartmentService.deleteApartment(apartment);
            return responseUtil.getSuccessResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping(value = "apa/up/{id}")
    public ResponseEntity<ResponseDto> updateApartment(@PathVariable("id") Integer id, @RequestBody ApartmentRequestDto apartmentRequestDto) {
        try {
            Apartment apartment = apartmentService.getByIdApartment(id);


            Apartment result = apartmentService.updateApartment(apartmentRequestDto, apartment);

            return responseUtil.getSuccessResponse(result);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/alldetail/{id}")
    public ResponseEntity<ResponseDto> getAllDetailApartmentById(@PathVariable Integer id) {
        try {
            Apartment apartment = apartmentService.getByIdApartment(id);

            ApartmentResponseDto apartmentResponseDto = apartmentService.getApartmentDetails(apartment);
            return responseUtil.getSuccessResponse(apartmentResponseDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/filtername")
    public ResponseEntity<ResponseDto> getAllDetailApartmentByName(@Valid @RequestBody String name) {
        try {
            List<Apartment> list = null;

            if (StringUtils.hasText(name)) {
                list = apartmentService.getApartmentByNameContaining(name);
            } else {
                list = apartmentService.getall();
            }
            return responseUtil.getSuccessResponse(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
