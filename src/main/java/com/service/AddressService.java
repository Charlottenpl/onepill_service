// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddressService.java

package com.service;

import com.Dao.AddressRepository;
import com.entity.Address;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressService
{
    @Resource
    private AddressRepository addressRepository;

    public List<Address> listAll()
    {
        return addressRepository.findAll();
    }

    public Address findById(int id)
    {
        Address address = null;
        if(addressRepository.findById(Integer.valueOf(id)).isPresent()) {
            address = (Address)addressRepository.findById(Integer.valueOf(id)).get();
        }
        return address;
    }

    public void saveAddress(Address address)
    {
        addressRepository.save(address);
    }

    public void delAddress(int id)
    {
        addressRepository.deleteById(Integer.valueOf(id));
    }

    public Address updateAddress(Address address)
    {
        addressRepository.save(address);
        return findById(address.getId());
    }

    public List findByUserId(String userId)
    {
        return addressRepository.findByUserId(userId);
    }

    public boolean isExist(int id)
    {
        return addressRepository.findById(Integer.valueOf(id)).isPresent();
    }
}
