package com.george.mapper;

import com.george.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface BrandMapper {

    List<Brand> selectAll();

    Brand searchByIdBrand(int id);

    /*
        1.POJO 类型             直接使用。要求 `属性名` 和 `参数占位符名称` 一致
        2.Map 集合类型            直接使用。要求 `map集合的键名` 和 `参数占位符名称` 一致
        3.Collection 集合类型   可以使用 `@Param` 注解替换map集合中默认的 arg 键名。==
            Mybatis 会将集合封装到 map 集合中，如下：
               > map.put("arg0"，collection集合);
               > map.put("collection"，collection集合;
        4.List 集合类型  ==可以使用 `@Param` 注解替换map集合中默认的 arg 键名。==
             Mybatis 会将集合封装到 map 集合中，如下：
               > map.put("arg0"，list集合);
               > map.put("collection"，list集合);
               > map.put("list"，list集合);
        5.Array 类型  ==可以使用 `@Param` 注解替换map集合中默认的 arg 键名。==
          Mybatis 会将集合封装到 map 集合中，如下：
              > map.put("arg0"，数组);
              > map.put("array"，数组);
        6.其他类型
          比如int类型，`参数占位符名称` 叫什么都可以。尽量做到见名知意
          */
    List<Brand> selectAllByStatusAndBrandNameAndCompanyName(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    List<Brand> selectAllByStatusAndBrandNameAndBrandName2(Brand brand);

    List<Brand> selectAllByStatusAndBrandNameAndBrandName3(Map map);

    List<Brand> selectByConditionSingle(Map map);

    void add(Brand brand);

    int add1(Brand brand);

    void updateById(Brand brand);

    void updateId(Brand brand);

    int deleteById(int id);

    int deleteByIds(@Param("ids") int[] ids);
}
