package com.controllers;

import com.dao.ReportDaoImp;
import com.dao.UserDaoImp;
import com.model.Count;
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
        }else if(u.getLevel().equals(User.ADMIN)){
            list = reportService.getReports(page,size);
            return list;
        }else{
            list = reportService.getReports(page,size,u.getId());
            return list;
        }
    }

    /*
      返回指定维修人员的订单的未处理订单
     */
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
            if(!u.getLevel().equals(User.STAFF)){
                return null;
            }
            list = reportService.getManage(page,size,u.getId());
            return list;
        }
    }

    /*
      为一项报修指定维修人员
     */
    @Path("staff")
    @POST
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Report addStaff(@FormParam("id") Integer id, @FormParam("staff_id")Integer staff_id){
        Report report = dao.get(id);
        if(report != null){
            User staff = userDao.get(staff_id);
            if(staff.getLevel().equals(User.STAFF)){
                report.setStaff(staff);
                dao.update(report);
            }else{
                return report;
            }
        }
        return report;
    }

    /*
        添加评价
     */
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
        if(report.getId()==null){
            return null;
        }
        Report re = dao.get(report.getId());
        report.setStatus(re.getStatus());
        if(report.getStaff()!=null){
            re.setStaff(report.getStaff());
        }
        if(report.getJudge() != null){
            re.setJudge(report.getJudge());
        }
        if(report.getAddress() != null){
            re.setAddress( report.getAddress());
        }
        if(report.getArea() != null){
            re.setArea(report.getArea());
        }
        if(report.getCompany() != null){
            re.setCompany(report.getCompany());
        }
        if(report.getDepartment()!=null){
            re.setDepartment(report.getDepartment());
        }
        if(report.getDescription()!=null){
            re.setDescription(report.getDescription());
        }
        if(report.getKind() != null){
            re.setKind(report.getKind());
        }
        if(report.getName() != null){
            re.setName(report.getName());
        }
        if(report.getPhone() != null){
            re.setPhone(report.getPhone());
        }
        if(report.getUser() != null){
            re.setUser(report.getUser());
        }
        dao.update(re);
        return re;
    }

    @DELETE
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public String delReport(@PathParam("id") Integer id){
        Report report = dao.get(id);
        String message = "";
        if(report == null){
            message = "{\"status\":\"false\",\"message\":\"id wrong\"}";
            return message;
        }
        report.setStatus(0);
        dao.update(report);
        message = "{\"status\":\"success\",\"message\":\"success\"}";

        return message;
    }

    @Path("count")
    @GET
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Count getCount(){
        User u = null;
        HttpSession session= req.getSession(true);
        u =(User)session.getAttribute("user");
        if(u.getLevel().equals(User.ADMIN)){
            u = null;
        }
        Count count = new Count();
        Integer sum = dao.getCount(u);
        count.setCount(sum);
        count.setStatus("success");
        count.setKind("Report");

        return count;
    }
}
