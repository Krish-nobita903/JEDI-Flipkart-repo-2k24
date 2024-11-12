package com.flipfit.restcontroller;

import com.flipfit.bean.Gym;
import com.flipfit.service.GymManagerInterface;
import com.flipfit.exception.GymListNotFoundException;
import com.flipfit.exception.UpdateFailedException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gym-manager")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymManagerController {

    private final GymManagerInterface gymManagerService;

    // Constructor injection for GymManagerService
    public GymManagerController(GymManagerInterface gymManagerService) {
        this.gymManagerService = gymManagerService;
    }

    // Endpoint to view gyms owned by the manager
    @GET
    @Path("/{managerId}/gyms")
    public Response viewOwnedGyms(@PathParam("managerId") String managerId) {
        try {
            List<Gym> ownedGyms = gymManagerService.viewOwnedGyms(managerId);
            if (ownedGyms == null || ownedGyms.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No gyms found for Manager ID: " + managerId)
                        .build();
            }
            return Response.ok(ownedGyms).build();
        } catch (GymListNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No gyms found: " + e.getMessage())
                    .build();
        }
    }

    // Endpoint to enroll a new gym
    @POST
    @Path("/{managerId}/gyms")
    public Response enrollGym(@PathParam("managerId") String managerId, Gym gym) {
        try {
            gymManagerService.enrollGym(gym, managerId);
            return Response.status(Response.Status.CREATED)
                    .entity("Gym enrolled successfully")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to enroll gym: " + e.getMessage())
                    .build();
        }
    }

    // Endpoint to update gym details
    @PUT
    @Path("/{managerId}/gyms/{gymId}")
    public Response updateGymDetails(@PathParam("managerId") String managerId,
                                     @PathParam("gymId") String gymId,
                                     @QueryParam("pinCode") String pinCode,
                                     @QueryParam("regionId") String regionId) {
        try {
            gymManagerService.updateGymDetails(managerId, gymId, pinCode, regionId);
            return Response.status(Response.Status.OK)
                    .entity("Gym details updated successfully")
                    .build();
        } catch (UpdateFailedException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update gym details: " + e.getMessage())
                    .build();
        }
    }

    // Endpoint to update the gym slots (currently empty implementation in GymManagerImpl)
    @PUT
    @Path("/{managerId}/gyms/slots")
    public Response updateSlot(@PathParam("managerId") String managerId) {
        try {
            gymManagerService.updateSlot();
            return Response.status(Response.Status.OK)
                    .entity("Slots updated successfully")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to update slots: " + e.getMessage())
                    .build();
        }
    }

    // Endpoint to update the manager's password
    @PUT
    @Path("/{managerId}/password")
    public Response updatePassword(@PathParam("managerId") String managerId,
                                   @QueryParam("oldPassword") String oldPassword,
                                   @QueryParam("newPassword") String newPassword) {
        try {
            gymManagerService.updatePassword(managerId, oldPassword, newPassword);
            return Response.status(Response.Status.OK)
                    .entity("Password updated successfully")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to update password: " + e.getMessage())
                    .build();
        }
    }
}
