package com.controllers;

import com.dao.ReportDaoImp;
import com.model.Report;
import com.model.User;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("Report")
public class ReportController {
    @Inject    //依赖注入？
    private ReportDaoImp dao;
    //注入http请求
    @Context
    HttpServletRequest req;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public Report getReport(@PathParam("id") Integer id){
        Report report = new Report();
        report = dao.get(id);
        return report;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public List getReports(@DefaultValue("0")@QueryParam("page") Integer page, @DefaultValue("10")@QueryParam("size") Integer size){
        List<Report> list ;
        User u = null;
        HttpSession session= req.getSession(true);
        u =(User)session.getAttribute("user");
        if(u == null){
            return null;
        }else{
            list = dao.findAll(page,size,u.getId());
            return list;
        }
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Report addReport(@BeanParam Report report){
        report.setStatus(1);
        User u = null;
        HttpSession session= req.getSession(true);
        u =(User)session.getAttribute("user");
        if(u == null){

        }else{
            report.setUser(u);
        }
        dao.save(report);
        return report;
    }

    @PUT
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Report updateReport(@BeanParam Report report){
        dao.update(report);
        return report;
    }

    @DELETE
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public void delReport(@PathParam("id") Integer id){
        Report report = dao.get(id);
        report.setStatus(0);
        dao.update(report);
    }

}
