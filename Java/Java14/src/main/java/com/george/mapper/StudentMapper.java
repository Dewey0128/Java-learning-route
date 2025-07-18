package com.george.mapper;

import com.george.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// 3. 在Mapper接口中定义方法，方法名就是SQL映射文件中sql语句的id，并保持参数类型和返回值类型一致
public interface StudentMapper {
    /* 注解开发 ：
        使用注解来映射简单浯句会使代码显得更加简洁，但对于稍微复杂一点的浯句，Java注解不仅力不从心，还会让你本就复杂的SQL语句更加混引堪。
        因此，如果需要做一些很复杂的操作，最好用XML来映射语句。
        选择何种方式来配置映射，以及认为是否应该统一映射浯句定义的形式，完全取决于团队。
        换句话说，永远不要拘泥于一种方式，你可以很轻松的在基于汪解和XML的语句映射方式间自由移植和切换。
    * */
    @Select("select * from student")
    List<Student> selectAll();
}
