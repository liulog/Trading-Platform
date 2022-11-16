//package com.hust.trade.transaction.controller;
//
//import com.hust.trade.transaction.mapper.UserMapper;
//import javax.annotation.Resource;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//  @Resource
//  UserMapper userMapper;
//
//  @GetMapping("/{id}")
//  public String getById(@PathVariable Long id){
//    System.out.println("id ==> "+id);
//    return "hello.spring boot!";
//  }
//
//}
