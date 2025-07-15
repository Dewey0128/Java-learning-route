package com.george.mapper;

import com.george.pojo.Student;

import java.util.List;

// 3. 在Mapper接口中定义方法，方法名就是SQL映射文件中sql语句的id，并保持参数类型和返回值类型一致
public interface StudentMapper {
    List<Student> selectAll();
}
