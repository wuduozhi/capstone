package com.controllers;

import com.dao.RepairDaoImp;
import com.model.Repair;
import com.model.User;

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
    private RepairDaoImp dao;
    //注入http请求
    @Context
    HttpServletRequest req;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public Repair getRepair(@PathParam("id") Integer id) {
        Repair repair = new Repair();
        repair = dao.get(id);
        return repair;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public List getRepairs(@DefaultValue("0") @QueryParam("page") Integer page, @DefaultValue("10") @QueryParam("size") Integer size) {
        List list = dao.findAll(page, size);
        return list;
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Repair addRepair(@BeanParam Repair repair){
        repair.setStatus(1);
        User u = null;
        HttpSession session= req.getSession(true);
        u =(User)session.getAttribute("user");
        if(u == null){
            return repair;
        }else{
            repair.setUser(u);
        }
        dao.save(repair);
        return repair;
    }

    @PUT
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Repair updateRepair(@BeanParam Repair repair){
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
}

