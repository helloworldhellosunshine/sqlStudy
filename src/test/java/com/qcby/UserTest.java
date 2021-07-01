package com.qcby;

import com.qcby.Dao.UserDao;
import com.qcby.entity.ClassName;
import com.qcby.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest {

    private InputStream in = null;
    private SqlSession session = null;
    private UserDao mapper = null;

    @Before
    public void init() throws IOException {
        //加载主配置文件，目的是为了构建SqlSessionFactory对象
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //通过SqlSessionFactory工厂对象创建SqlSesssion对象
        session = factory.openSession();
        //通过Session创建UserDao接口代理对象
        mapper = session.getMapper(UserDao.class);
    }

    @After
    public void destory() throws IOException {
        //释放资源
        session.close();
        in.close();
    }

    /**
     * 测试查询所有的方法
     */
    @Test
    public void findAll() throws IOException {
        List<User> users = mapper.findAll();
        for (User user:users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void findById() {
        User user = mapper.findById(2);
        System.out.println(user.toString());
    }


    @Test
    public void insert(){
        User user = new User();
        user.setAddress("保定");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setUsername("张三");


        int code = mapper.insert(user);
        session.commit();
        System.out.println(code);
    }

    @Test
    public void delete(){
        int code = mapper.delete(2);
        session.commit();
        System.out.println(code);
    }

    @Test
    public void insertGetId(){
        User user = new User();
        user.setAddress("保定");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setUsername("张三");

        mapper.insertGetId(user);
        session.commit();
        System.out.println(user.getId());
    }

    // void --- 默认没有返回值
    // ------ 基本数据类型
    // 引用数据类型 ---
    @Test
    public void  likeByName(){

        User user = new User();
        user.setUsername("熊大");
        user.setSex("男");
        List<User> users = mapper.likeByName(user);
        for (User user1: users) {
            System.out.println(user1);
        }

    }

    @Test
    public void foreach(){
        List<Integer> ids = new ArrayList<Integer>();
        //ids.add(1);
        List<User> users = mapper.foreach(ids);
        for (User user: users) {
            System.out.println(user.toString());
        }
    }




}
