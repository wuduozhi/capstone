package com.dao;

import com.model.Repair;
import java.util.List;

public interface RepairDao {
    public abstract void save(Repair repair);
    public abstract Repair get(Integer id);
    public abstract void delete(Repair repair);
    public abstract void update(Repair repair);
    public abstract List findAll(Integer page, Integer size);
}
