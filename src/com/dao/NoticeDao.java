package com.dao;

import com.model.Notice;

import java.util.List;

public interface NoticeDao {
    public abstract void save(Notice notice);
    public abstract Notice get(Integer id);
    public abstract void delete(Notice notice);
    public abstract void update(Notice notice);
    public abstract List findAll(Integer page, Integer size);
    public abstract List findAll(Integer page, Integer size,Integer user_id);
}
