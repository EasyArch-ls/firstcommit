package org.mybatis;

import org.apache.ibatis.annotations.Param;
import org.bean.Students;

import java.util.List;

public interface Student {
    List<Students> findAll(@Param("college")String college);
    List<Students> findword(@Param("college")String college,@Param("word")String word);
    boolean insert(@Param("bid")String bid,@Param("sid")String sid,@Param("cid")String cid,@Param("name")String name,@Param("sex")String sex,@Param("phone")String phone,@Param("number")String number,@Param("college")String college,@Param("other")String other);
    int update(@Param("id")String id,@Param("bid")String bid,@Param("sid")String sid,@Param("cid")String cid,@Param("name")String name,@Param("phone")String phone,@Param("other")String other,@Param("college")String college);
    boolean delete(@Param("id")String id,@Param("college") String college);
}
