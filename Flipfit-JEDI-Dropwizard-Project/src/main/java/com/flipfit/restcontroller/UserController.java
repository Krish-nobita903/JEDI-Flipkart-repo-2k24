package com.flipfit.restcontroller;

import com.flipfit.bean.Slot;
import com.flipfit.service.FlipFitUserService;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    FlipFitUserService userService;

    public UserController(FlipFitUserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/viewBookedSlots")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Slot> viewBookedSlots(@QueryParam("userId") String userId){
        List<Slot> slots = userService.viewBookedSlots(userId);
        return slots;
    }

    @PUT
    @Path("/updateUserInfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserInfo(@QueryParam("userId") String userId, @QueryParam("phoneNumber") String phoneNumber,@QueryParam("emailAddress") String emailAddress,@QueryParam("password") String password){
        try{
            userService.updateUserInfo(userId, phoneNumber, emailAddress, password);
            return Response.ok("User Info updated successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update user info: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/addUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@QueryParam("userName") String userName,@QueryParam("email") String email, @QueryParam("password") String password,@QueryParam("firstName") String firstName,@QueryParam("lastName") String lastName,@QueryParam("phoneNumber") String phoneNumber,@QueryParam("bodyWeight") double bodyWeight){
        try{
            userService.addUser(userName, email, password, firstName, lastName, phoneNumber, bodyWeight);
            return Response.ok("User Info updated successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update user info: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/cancelSlot")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancelSlot(@QueryParam("userId") String userId,@QueryParam("slotId") String slotId){
        try{
            userService.cancelSlot(userId, slotId);
            return Response.ok("Slot canceled successfully").build();
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update user info: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("userName") String userName,@QueryParam("password") String password){
        try {
            String userId=userService.login(userName, password);
            if(userId == null){
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }
            return Response.ok(userId).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Failed to login: " + e.getMessage()).build();
        }
    }
}
