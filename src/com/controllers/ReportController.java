package com.controllers;

import com.dao.ReportDaoImp;
import com.dao.UserDaoImp;
import com.model.Report;
import com.model.User;
import com.service.ReportService;
import io.swagger.models.auth.In;

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
    private ReportService reportService;
    @Inject    //依赖注入？
    private ReportDaoImp dao;
    @Inject    //依赖注入？
    private UserDaoImp userDao;
    //注入http请求
    @Context
    HttpServletRequest req;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public Report getReport(@PathParam("id") Integer id){
        Report report ;
        report = reportService.getReport(id);
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
            list = reportService.getReports(page,size,u.getId());
            return list;
        }
    }

    @Path("manage")
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public List getNotReports(@DefaultValue("0")@QueryParam("page") Integer page, @DefaultValue("10")@QueryParam("size") Integer size){
        List<Report> list ;
        User u = null;
        HttpSession session= req.getSession(true);
        u =(User)session.getAttribute("user");
        if(u == null){
            return null;
        }else{
            if(u.getLevel()!=User.STAFF){
                return null;
            }
            list = dao.findAllNotDeal(page,size,u.getId());
            return list;
        }
    }

    @Path("staff")
    @POST
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Report addManage(@FormParam("id") Integer id, @FormParam("staff_id")Integer staff_id){
        Report report = dao.get(id);
        if(report.getStaff() == null){
            User staff = userDao.get(staff_id);
            if(staff.getLevel() == User.STAFF){
                report.setStaff(staff);
                dao.update(report);
            }else{
                return report;
            }
        }
        return report;
    }

    @Path("judge")
    @POST
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Report addJudge(@FormParam("id") Integer id, @FormParam("judge")String judge){
        Report report = dao.get(id);
        if(report.getJudge() == null){
            report.setJudge(judge);
            dao.update(report);
        }
        return report;
    }


    @POST
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Report addReport(@BeanParam Report report){
        report.setStatus(Report.NOT_DEALL);
        User u = null;
        HttpSession session= req.getSession(true);
        u =(User)session.getAttribute("user");
        if(u == null){
            return null;
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
