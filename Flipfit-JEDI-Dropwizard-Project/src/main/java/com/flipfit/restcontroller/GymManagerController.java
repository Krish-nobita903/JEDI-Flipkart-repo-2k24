package com.flipfit.controller;

import com.flipfit.bean.Gym;
import com.flipfit.service.GymManagerImpl;
import com.flipfit.service.GymManagerInterface;
import com.flipfit.exception.GymListNotFoundException;
import com.flipfit.exception.UpdateFailedException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gymmanager")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymManagerController {

    private GymManagerImpl gymManagerService;

    public GymManagerController() {
        this.gymManagerService = new GymManagerImpl();
    }

    @PUT
    @Path("/addGymManager")
    public Response addGymManager(@PathParam("name") String name,@PathParam("email") String email,@PathParam("password")String password,@PathParam("firstName")String firstName,@PathParam("lastName")String lastName) {
        try {
            gymManagerService.createGymManager(name, email, password, firstName, lastName);
            return Response.ok().build();
        } catch (GymListNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No gyms found for the provided managerId: " + managerId).build();
        }
    }

    @GET
    @Path("/ownedgyms/{managerId}")
    public Response getOwnedGyms(@PathParam("managerId") String managerId) {
        try {
            List<Gym> ownedGyms = gymManagerService.viewOwnedGyms(managerId);
            return Response.ok(ownedGyms).build();
        } catch (GymListNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No gyms found for the provided managerId: " + managerId).build();
        }
    }

    @POST
    @Path("/enrollgym")
    public Response enrollGym(Gym gym, @QueryParam("managerId") String managerId) {
        try {
            gymManagerService.enrollGym(gym, managerId);
            return Response.status(Response.Status.CREATED)
                    .entity("Gym successfully enrolled under manager: " + managerId).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to enroll gym: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/updategym/{managerId}/{gymId}")
    public Response updateGymDetails(@PathParam("managerId") String managerId,
                                     @PathParam("gymId") String gymId,
                                     @QueryParam("pinCode") String pinCode,
                                     @QueryParam("regionId") String regionId) {
        try {
            gymManagerService.updateGymDetails(managerId, gymId, pinCode, regionId);
            return Response.ok("Gym details updated successfully.").build();
        } catch (UpdateFailedException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update gym details: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/updatepassword")
    public Response updatePassword(@QueryParam("userName") String userName,
                                   @QueryParam("oldPassword") String oldPassword,
                                   @QueryParam("newPassword") String newPassword) {
        try {
            gymManagerService.updatePassword(userName, oldPassword, newPassword);
            return Response.ok("Password updated successfully.").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update password: " + e.getMessage()).build();
        }
    }
}
