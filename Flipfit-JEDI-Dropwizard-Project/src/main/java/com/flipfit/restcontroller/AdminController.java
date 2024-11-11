package com.flipfit.restcontroller;

import com.flipfit.bean.User;
import com.flipfit.service.AdminService;
import com.flipfit.service.AdminServiceOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminController {

    private AdminService adminService;
    public AdminController(AdminServiceOperation adminService) {
        this.adminService = adminService;
    }

    @GET
    @Path("/viewUserList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserList(){
        List<User> users = adminService.getUserList();
        return users;
    }

    @POST
    @Path("/addGym")
    @Produces(MediaType.APPLICATION_JSON)
    public void addGym(String regionId,int pinCode){
        adminService.addGym(regionId,pinCode);
    }

    @POST
    @Path("/addRegion")
    @Produces(MediaType.APPLICATION_JSON)
    public void addRegion(String regionName){
        adminService.addRegion(regionName);
    }

    @PUT
    @Path("/updateAdminPassword")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateAdminPassword(String userName,String newPassword){
        adminService.updateAdminPassword(userName,newPassword);
    }
}
