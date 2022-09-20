package com.vmo.springboot.Demo.services;

import com.vmo.springboot.Demo.model.ServiceOther;
import com.vmo.springboot.Demo.repositories.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@org.springframework.stereotype.Service
public class ServiceOtherServicesIpml  {
    @Autowired
    IServiceRepository iServiceRepository;

    public Set<ServiceOther> getServiceListById(Set<Integer> ids) {
        Set<ServiceOther> serviceOthers = iServiceRepository.findAllByIdIn(ids);
        return serviceOthers;
    }

    public int getTotalServicePriceIn(Set<ServiceOther> serviceOthers) {
        int sum = 0;

        for (ServiceOther serviceOther : serviceOthers) {
            sum += serviceOther.getPrice();
        }
        return sum;
    }
}
