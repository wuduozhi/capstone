package com.app;

import com.dao.RepairDaoImp;
import com.dao.ReportDaoImp;
import com.dao.UserDaoImp;
import com.model.Report;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/*
    用于绑定class，用于依赖注入(Ioc)
 */
public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(UserDaoImp.class).to(UserDaoImp.class);
        bind(ReportDaoImp.class).to(ReportDaoImp.class);
        bind(RepairDaoImp.class).to(RepairDaoImp.class);
    }

}
