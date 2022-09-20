package com.vmo.springboot.Demo.services.Interface;


import com.vmo.springboot.Demo.dto.Request.LeasesRequestDto;
import com.vmo.springboot.Demo.model.Apartment;
import com.vmo.springboot.Demo.model.Leases;
import com.vmo.springboot.Demo.model.Tenant;

import java.util.List;

public interface ILeases {
    public Leases add(LeasesRequestDto leasesdto, Apartment apartment, Tenant tenant);
    public Leases update(Leases leases,LeasesRequestDto leasesdto, Apartment apartment, Tenant tenant);
    public  String delete(int id);
    public List<Leases> getall();
    public Leases getone(int id);

}
