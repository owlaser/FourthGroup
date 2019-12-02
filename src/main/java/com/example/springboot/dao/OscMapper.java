package com.example.springboot.dao;

import com.example.springboot.domain.Osc;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Component注解不添加也没事，只是不加service那边引入OscMapper会有错误提示，但不影响
 */
@Component
@Mapper
public interface OscMapper {
    @Select("SELECT * FROM osc")
    List<Osc> getAll();

    @Select("SELECT * FROM osc WHERE name = #{name}")
    List<Osc> getFromName(String name);

    @Insert("INSERT INTO osc(name,url,groupId,artifactId,version) VALUES(#{name},#{url},#{groupId},#{artifactId},#{version})")
    void insert(Osc osc);

//    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
//    void update(User user);
//
//    @Delete("DELETE FROM users WHERE id =#{id}")
//    void delete(Long id);



}
