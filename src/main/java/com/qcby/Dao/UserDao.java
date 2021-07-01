package com.qcby.Dao;

import com.qcby.entity.ClassName;
import com.qcby.entity.User;

import java.security.PublicKey;
import java.util.List;

public interface UserDao {
    /**
     * 全部查询
     * @return
     */
    public List<User> findAll();

    /**
     * 根据id进行查询
     * @param id
     */
    public User findById(int id);

    /**
     *  插入数据
     * @param user
     * @return
     */
    public int insert(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(int id);



    /**
     * 获取插入的id
     * @param user
     * @return
     */
    public int insertGetId(User user);

    /**
     * 通过姓名模糊查询
     * @return
     */
    public List<User> likeByName(User user);


    List<ClassName> getUser3();


    /**
     * foreach
     * @param ids
     * @return
     */
    public List<User> foreach(List<Integer> ids);


}
