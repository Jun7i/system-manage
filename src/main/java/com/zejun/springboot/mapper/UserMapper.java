package com.zejun.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zejun.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
// @Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * from sys_course")
    List<User> findAll();

    @Insert("INSERT INTO sys_course(course, description, term, grade,units, instructor, rating) VALUES (#{course}, #{description}, " +
            "#{term}, #{grade}, #{units}, #{instructor}, #{rating})")
    int insert(User user);

    int update(User user);

    @Delete("delete from sys_course where id = #{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select * from sys_course where course like #{course} limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize, String course);

    @Select("select count(*) from sys_course where course like concat('%', #{course}, '%') ")
    Integer selectTotal(String course);
}

