package com.controllers;

import com.model.Statistic;
import com.service.StatisticService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("Statistic")
public class StatisticController {
    @Inject
    StatisticService statisticService;
    /*
      统计数据查询
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public List getStatistic(@BeanParam Statistic statistic){
        List list = statisticService.getStatistics(statistic);
        return list;
    }

}
