package com.george.mapper;

import com.george.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    public List<Brand> selectAll();
    Brand searchByIdBrand(int id);
}
