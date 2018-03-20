package com.controllers;

import com.dao.RelationListDaoImp;
import com.dao.RepairDaoImp;
import com.dao.ReportDaoImp;
import com.model.*;
import com.service.RepairService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("Repair")
public class RepairController {
    @Inject    //依赖注入？
    private RepairService repairService;
    @Inject    //依赖注入？
    private RepairDaoImp dao;
    @Inject    //依赖注入？
    private RelationListDaoImp listDao;
    @Inject    //依赖注入？
    private ReportDaoImp reportDao;
    //注入http请求
    @Context
    HttpServletRequest req;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public Repair getRepair(@PathParam("id") Integer id) {
        Repair repair = new Repair();
        repair = repairService.getRepair(id);
        return repair;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public List getRepairs(@DefaultValue("0") @QueryParam("page") Integer page, @DefaultValue("10") @QueryParam("size") Integer size) {
        HttpSession session= req.getSession(true);
        User user =(User)session.getAttribute("user");
        List list = null;
        if(user==null){
            return null;
        }else if(user.getLevel().equals(User.ADMIN)){
            list = repairService.getRepairs(page,size);
        }else{
            list = repairService.getRepairs(page, size,user.getId());
        }
        return list;
    }



    @POST
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Repair addRepair(@BeanParam Repair repair,@FormParam("report_id") Integer report_id){
        User u = null;
        Report report = reportDao.get(report_id);
        HttpSession session= req.getSession(true);
        u =(User)session.getAttribute("user");

        if(u == null){
            return repair;
        }else if(u.getId().equals(report.getStaff().getId())){
            repair.setUser(u);
        }else{
            return repair;
        }
        repair.setStatus(1);
        dao.save(repair);
        RelationList l = new RelationList();
        l.setRepair_id(repair);
        l.setReport_id(report);
        listDao.save(l);
        report.setStatus(Report.DEALL);
        reportDao.update(report);
        return repair;
    }

    @PUT
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Repair updateRepair(@BeanParam Repair repair){
        if(repair.getId()==null){
            return null;
        }
        Repair re = dao.get(repair.getId());
        repair.setStatus(re.getStatus());
        dao.update(repair);
        return repair;
    }

    @DELETE
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public void delRepair(@PathParam("id") Integer id){
        Repair repair = dao.get(id);
        repair.setStatus(0);
        dao.update(repair);
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
        count.setKind("Repair");

        return count;
    }
}


