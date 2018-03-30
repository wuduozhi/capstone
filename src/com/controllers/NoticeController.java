package com.controllers;

import com.dao.NoticeDaoImp;
import com.model.Count;
import com.model.Notice;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
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
        java.util.Date d = new  java.util.Date();
        Date date = new Date(d.getTime());
        notice.setTime(date);
        dao.save(notice);
        return notice;
    }

    @PUT
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Notice updateNotice(@BeanParam Notice notice){
        if(notice.getId()==null){
            return null;
        }
        Notice n = dao.get(notice.getId());
        notice.setStatus(n.getStatus());
        if(notice.getMessage() != null){
            n.setMessage(notice.getMessage());
        }
        if(notice.getTime() != null){
            n.setTime(notice.getTime());
        }
        if(notice.getTitle()!=null){
            n.setTitle(notice.getTitle());
        }

        dao.update(n);
        return n;
    }

    @DELETE
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public String deleteNotice(@PathParam("id") Integer id){
        Notice notice = dao.get(id);
        String message = "";
        if(notice == null){
            message = "{\"status\":\"false\",\"message\":\"id wrong\"}";
            return message;
        }
        notice.setStatus(0);
        dao.update(notice);
        message = "{\"status\":\"success\",\"message\":\"success\"}";

        return message;
    }

    @Path("count")
    @GET
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Count getCount(){
        Count count = new Count();
        Integer sum = dao.getCount();
        count.setCount(sum);
        count.setStatus("success");
        count.setKind("Notice");

        return count;
    }


}
