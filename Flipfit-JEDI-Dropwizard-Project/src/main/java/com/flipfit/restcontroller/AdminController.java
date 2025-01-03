package com.flipfit.restcontroller;

import com.flipfit.bean.User;
import com.flipfit.service.AdminService;
import com.flipfit.service.AdminServiceOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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
    public Response addGym(@QueryParam("regionId") String regionId,@QueryParam("pinCode") int pinCode){
        try {
            adminService.addGym(regionId, pinCode);
            return Response.status(Response.Status.CREATED)
                    .entity("Gym successfully added under region: " + regionId).build();
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to add gym: " + e.getMessage()).build();
        }
    }

    @POST
    @Path("/addRegion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRegion(@QueryParam("regionName") String regionName){
        try {
            adminService.addRegion(regionName);
            return Response.status(Response.Status.CREATED)
                    .entity("Region added successfully: " + regionName).build();
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to add region: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/updateAdminPassword")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAdminPassword(@QueryParam("userName") String userName,@QueryParam("newPassword") String newPassword){
        try {
            adminService.updateAdminPassword(userName, newPassword);
            return Response.ok("Admin Password updated successfully").build();
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update password: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("userName") String userName,@QueryParam("password") String password){
        try {
            String adminUserId=adminService.login(userName, password);
            if(adminUserId == null){
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }
            return Response.ok(adminUserId).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Failed to login: " + e.getMessage()).build();
        }
    }


    @PUT
    @Path("/addAdmin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAdmin(@QueryParam("userName") String userName,@QueryParam("password") String password, @QueryParam("firstName") String firstName ,@QueryParam("lastName") String lastName ,@QueryParam("email") String email) {
        try {
            adminService.addAdminUser(userName, password, firstName, lastName, email);
            return Response.ok("Admin added successfully").build();
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update password: " + e.getMessage()).build();
        }
    }
}
