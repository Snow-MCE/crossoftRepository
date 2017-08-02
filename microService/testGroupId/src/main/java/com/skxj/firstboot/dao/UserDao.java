package com.skxj.firstboot.dao;

import com.skxj.firstboot.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Snow on 7/11/2017.
 */

@Repository
public interface UserDao {
    public void add(User t);

    public void update(User t);

    public void updateBySelective(User t);

    public void delete(Object id);

    public User queryById(Object id);

    public List<User> queryBySelective(User t);

    public int queryByCount(User t);

    public List<User> queryByList(User t);
}
