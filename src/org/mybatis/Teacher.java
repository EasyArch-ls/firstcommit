package org.mybatis;

import org.apache.ibatis.annotations.Param;
import org.bean.Teachers;

import java.util.List;

public interface Teacher {
    Teachers login(@Param("name") String name ,@Param("password") String password);
    Teachers email(@Param("email")String email);
    boolean findemail(@Param("email")String email);
    boolean insert(@Param("name")String name, @Param("password")String password,@Param("phone")String phone, @Param("email")String email, @Param("college")String college);
    int update(@Param("id")String id,@Param("name")String name, @Param("password")String password,@Param("phone")String phone, @Param("email")String email, @Param("college")String college);
    boolean deletet(@Param("id")String id);
}
