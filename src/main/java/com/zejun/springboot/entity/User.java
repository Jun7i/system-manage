package com.zejun.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName(value = "sys_course")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String course;
    // @JsonIgnore
    private String description; //not display password
    private String term;
    private String grade;
    private String units;
    private String instructor;
    private String rating;

}
