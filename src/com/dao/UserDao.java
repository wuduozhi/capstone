package com.dao;

import com.model.User;

import java.util.List;

public interface UserDao {
    public abstract void save(User user);
    public abstract User get(Integer id);
    public abstract void delete(User user);
    public abstract void update(User user);
    public abstract List findAll(Integer page,Integer size);
    public abstract  User login(User user);
}
