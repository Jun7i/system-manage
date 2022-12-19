package com.zejun.springboot.controller;

import com.zejun.springboot.entity.User;
import com.zejun.springboot.mapper.UserMapper;
import com.zejun.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    // Add or edit
    @PostMapping
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> findAll() {
        // List<User> all= userMapper.findAll();
        return userService.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){

        return userService.removeByIds(ids);
    }

    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String course) {
        pageNum = (pageNum - 1) * pageSize;
        course = "%" + course +"%";
        List<User> data = userMapper.selectPage(pageNum, pageSize, course);
        Integer total = userMapper.selectTotal(course);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);

        return res;
    }
}
