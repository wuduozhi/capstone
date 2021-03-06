package com.app;

import com.dao.*;
import com.service.RepairService;
import com.service.ReportService;
import com.service.StatisticService;
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
        bind(NoticeDaoImp.class).to(NoticeDaoImp.class);
        bind(RelationListDaoImp.class).to(RelationListDaoImp.class);
        bind(ReportService.class).to(ReportService.class);
        bind(RepairService.class).to(RepairService.class);
        bind(StatisticService.class).to(StatisticService.class);
    }

}
