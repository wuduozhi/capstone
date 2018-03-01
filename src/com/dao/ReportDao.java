package com.dao;

import com.model.Report;

import java.util.List;

public interface ReportDao {
    public abstract void save(Report report);
    public abstract Report get(Integer id);
    public abstract void delete(Report report);
    public abstract void update(Report report);
    public abstract List findAll(Integer page, Integer size);
    public abstract List findAll(Integer page, Integer size,Integer user_id);
}
