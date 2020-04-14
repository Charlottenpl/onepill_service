// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddressService.java

package com.Address.service;

import com.Address.Dao.AddressRepository;
import com.entity.Address;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressService
{
    @Resource
    private AddressRepository addressRepository;

    //查询全部地址
    public List<Address> listAll()
    {
        return addressRepository.findAll();
    }

    //根据ID查询地址
    public Address findById(int id)
    {
        Address address = null;
        if(addressRepository.findById(Integer.valueOf(id)).isPresent()) {
            address = (Address)addressRepository.findById(Integer.valueOf(id)).get();
        }
        return address;
    }

    //添加或者保存地址
    public void saveAddress(Address address)
    {
        addressRepository.save(address);
    }

    //删除地址
    public void delAddress(int id)
    {
        addressRepository.deleteById(Integer.valueOf(id));
    }

    //根据UserId查询地址
    public List findByUserId(int userId)
    {
        return addressRepository.findByUserId(userId);
    }

    //判断ID为id的地址是否存在
    public boolean isExist(int id)
    {
        return addressRepository.findById(Integer.valueOf(id)).isPresent();
    }
}
