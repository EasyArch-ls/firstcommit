package org.mybatis;

import org.apache.ibatis.annotations.Param;
import org.bean.Dormitories;
import org.bean.Manager;
import org.bean.Students;
import org.bean.Teachers;

import java.util.List;

public interface Dormitory {
    List<Students> findAlls();

    List<Dormitories> findAlld();

    List<Teachers> findAllt();

    String dlogin(@Param("name") String name, @Param("password") String password);

    Manager findemail(@Param("email") String email);

    boolean dinsert(@Param("bid") String bid, @Param("sid") String sid, @Param("tfuze") String tfuze, @Param("pfuze") String pfuze, @Param("pnumber") String pnumber, @Param("pphone") String pphone, @Param("tphone") String tphone);

    int dupdate(@Param("id") String id, @Param("bid") String bid, @Param("sid") String sid, @Param("tfuze") String tfuze, @Param("pfuze") String pfuze, @Param("pnumber") String pnumber, @Param("pphone") String pphone, @Param("tphone") String tphone);

    boolean ddelete(@Param("id") String id);
}
