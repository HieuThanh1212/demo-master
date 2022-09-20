package com.vmo.springboot.Demo.services.Interface;

import java.util.List;

public interface IGenericService<T> {
    public T add(T apartment);
    public T update(T apartment);
     public  String delete(int id);
    public List<T> getall();
    public T getone(int id);
    public T getByIdApartment(Integer idy);
}
