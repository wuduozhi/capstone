package com.controllers;

import com.dao.NoticeDaoImp;
import com.model.Notice;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("Notice")
public class NoticeController {
    @Inject    //依赖注入？
    private NoticeDaoImp dao;
    //注入http请求
    @Context
    HttpServletRequest req;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public Notice getNotice(@PathParam("id") Integer id){
        Notice notice = dao.get(id);
        return notice;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public List getNotices(@DefaultValue("0") @QueryParam("page") Integer page, @DefaultValue("10") @QueryParam("size") Integer size){
        List list = dao.findAll(page, size);
        return list;
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Notice addNotice(@BeanParam Notice notice){
        notice.setStatus(1);
        dao.save(notice);
        return notice;
    }

    @PUT
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Notice updateNotice(@BeanParam Notice notice){
        dao.update(notice);
        return notice;
    }

    @DELETE
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public void deleteNotice(@PathParam("id") Integer id){
        Notice notice = dao.get(id);
        notice.setStatus(0);
        dao.update(notice);
    }
}
