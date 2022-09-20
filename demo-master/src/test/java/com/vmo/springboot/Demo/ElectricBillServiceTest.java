package com.vmo.springboot.Demo;


import com.vmo.springboot.Demo.model.Apartment;
import com.vmo.springboot.Demo.repositories.IApartmentRepository;
import com.vmo.springboot.Demo.services.ApartmentSeviceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ElectricBillServiceTest {
    @InjectMocks
    ApartmentSeviceImpl ApartmentService;

    @Mock
    IApartmentRepository ApartMentRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    //get all
    @Test
    public void whenGetAll_shouldReturnList() {
        // 1. create mock data
        List<Apartment> mockProducts = new ArrayList<>();
        mockProducts.add(new Apartment(1,"jij",1,1,1,1,"d",1));
        // 2. define behavior of Repository
        when(ApartMentRepository.findAll()).thenReturn(mockProducts);
        // 3. call service method
        List<Apartment> actualProducts = ApartmentService.getall();
        // 4. assert the result
        assertThat(actualProducts.size()).isEqualTo(mockProducts.size());
        // 4.1 ensure repository is called
        verify(ApartMentRepository).findAll();
    }

    //get by id
    @Test
    public void whenGetInvalidOne_shouldThrowException() {
        Integer invalidProductId = 1;

        when(ApartMentRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(null));

        assertThatThrownBy(() ->  ApartmentService.getone(invalidProductId).getId());

        verify(ApartMentRepository).findById(any(Integer.class));
    }

    // create apartment
    @Test
    public void whenSaveUser_shouldReturnUser() {
//        Apartment user = new Apartment();
//        user.setName("Test Name");
//
//        when(ApartMentRepository.save(ArgumentMatchers.any(Apartment.class))).thenReturn(user);
//        Apartment created = ApartmentService.add(user);
//        assertThat(created.getName()).isSameAs(user.getName());
//        verify(ApartMentRepository).save(user);
    }

//    @Test
//    public void whenGivenId_shouldDeleteUser_ifFound(){
//        Apartment user = new Apartment();
//        user.setName("Test Name");
//        user.setId(1);
//
//        when(ApartMentRepository.findById(user.getId())).thenReturn(Optional.of(user));
//
//        ApartmentService.delete(user.getId());
//        verify(ApartMentRepository).deleteById(user.getId());
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void should_throw_exception_when_user_doesnt_exist() {
//        Apartment user = new Apartment();
//        user.setId(89);
//        user.setName("Test Name");
//        user.setArena(2);
//
//        given(ApartMentRepository.findById(anyInt())).willReturn(Optional.ofNullable(null));
//        ApartmentService.delete(user.getId());
//    }
}
