package com.controllers;
import com.dao.UserDaoImp;
import com.model.Count;
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
        String message =" {\"status\":\"success\",\"name\":\""+u.getName()+"\",\"id\":\""+u.getId()+"\",\"level\":\""+u.getLevel()+"\" }";
        return message;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public List getUsers(@DefaultValue("0")@QueryParam("page") Integer page,@DefaultValue("10")@QueryParam("size") Integer size){
        List<User> list ;
        list = dao.findAll(page,size);
        return list;
    }

    @Path("staff")
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public List getStaffs(@DefaultValue("0")@QueryParam("page") Integer page,@DefaultValue("10")@QueryParam("size") Integer size){
        List<User> list ;
        list = dao.getStaff(page,size);
        return list;
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public User addUser(@BeanParam User user) {
        user.setStatus(1);
        User tmp = dao.login(user);
        if(tmp != null){   //避免重复注册
            return user;
        }
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

    /*
      管理员修改权限
     */
    @Path("level")
    @POST
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public String updateLevel(@FormParam("id") Integer id,@FormParam("level") Integer level){
        User u = null;
        HttpSession session= req.getSession(true);
        u =(User)session.getAttribute("user");
        String message = "";
        if(u==null){
            message = "{\"status\":\"fail\",\"reason\":\"please login\"}";
        }else if(u.getLevel().equals(User.ADMIN) || u.getLevel().equals(User.SUPER) ){
            if(level.equals(User.ADMIN) && !u.getLevel().equals(User.SUPER)){
                message = "{\"status\":\"fail\",\"reason\":\"access is not enough\"}";
            }else {
                User tmp = dao.get(id);
                if(tmp==null){
                    message = "{\"status\":\"fail\",\"reason\":\"id error\"}";
                }else{
                    tmp.setLevel(level);
                    dao.update(tmp);
                    message = "{\"status\":\"success\",\"reason\":\"\"}";
                }
            }
        }else{
            message = "{\"status\":\"fail\",\"reason\":\"access is not enough\"}";
        }

        return message;
    }


    @Path("count")
    @GET
    @Produces({ MediaType.APPLICATION_JSON + ";charset=UTF-8" })
    public Count getCount(){
        Count count = new Count();
        Integer sum = null;
        sum = dao.getCount();
        count.setCount(sum);
        count.setStatus("success");
        count.setKind("User");

        return count;
    }


}
