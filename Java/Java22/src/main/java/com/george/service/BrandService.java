package com.george.service;

import com.george.pojo.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> selectAll();

    void add(Brand brand);
}
