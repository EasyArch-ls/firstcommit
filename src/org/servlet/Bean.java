package org.servlet;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Bean {
    public String conf;
    public Reader reader;
    public SqlSessionFactoryBuilder sfb;
    public SqlSessionFactory sf;
    public SqlSession session;

    public Bean() throws IOException {
        conf = "SqlMapConfig.xml";
        reader = Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        sfb = new SqlSessionFactoryBuilder();
        sf = sfb.build(reader);
        //创建Session
        session = sf.openSession();
    }

    public List queryScenicByArray(List list, int currPage, int pageSize) {
        //从第几条数据开始
        int firstIndex = (currPage - 1) * pageSize;
        //到第几条数据结束
        int lastIndex = currPage * pageSize;
        if (firstIndex<=list.size()) {

            if (lastIndex > list.size()) {
                lastIndex = list.size();
            }
            return list.subList(firstIndex, lastIndex); //直接在list中截取
        }
        return new LinkedList();
    }
}
