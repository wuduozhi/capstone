package com.controllers;
import com.dao.UserDaoImp;
import com.model.User;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("User")
public class UserController {
    @Inject    //依赖注入？
    private UserDaoImp dao;
    //注入http请求
    @Context
    HttpServletRequest req;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public User getUser(@PathParam("id") Integer id){
        User u = new User();
        u = dao.get(id);
        return u;
    }

    @POST
    @Path("login")
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public String login(@BeanParam User user){
        User u = dao.login(user);
        if(u == null){
            return "{\"status\":\"faile\"}";
        }else{
            HttpSession session= req.getSession(true);
            session.setAttribute("user",u);
        }
        String message =" {\"status\":\"success\",\"name\":\""+u.getName()+"\"}";
        return message;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public List getUsers(@DefaultValue("0")@QueryParam("page") Integer page,@DefaultValue("10")@QueryParam("size") Integer size){
        List<User> list ;
        list = dao.findAll(page,size);
        return list;
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public User addUser(@BeanParam User user) {
        user.setStatus(1);
        dao.save(user);
        return user;
    }

    @PUT
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public User updateUser(@BeanParam User user) {
        dao.update(user);
        return user;
    }

    @DELETE
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public void deleteUser(@PathParam("id") Integer id) {
        User user = dao.get(id);
        user.setStatus(0);
        dao.update(user);
    }


}
