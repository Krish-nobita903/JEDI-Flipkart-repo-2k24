package com.flipfit.controller;

import com.flipfit.bean.Gym;
import com.flipfit.bean.Slot;
import com.flipfit.service.GymService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/gyms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymController {

    private final GymService gymService;

    // Constructor injection for GymService
    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    // Endpoint to create a gym
    @POST
    @Path("/create")
    public Response createGym(Gym gym) {
        boolean isCreated = gymService.createGym(gym.getRegionId(), gym.getPincode(), gym.getSlotsAvailable());
        if (isCreated) {
            return Response.status(Response.Status.CREATED)
                    .entity("Gym successfully created")
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to create gym")
                    .build();
        }
    }

    // Endpoint to update a gym
    @PUT
    @Path("/update")
    public Response updateGym(Gym gym) {
        boolean isUpdated = gymService.updateGym(gym);
        if (isUpdated) {
            return Response.status(Response.Status.OK)
                    .entity("Gym successfully updated")
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Failed to update gym")
                    .build();
        }
    }

    // Endpoint to view a gym
    @GET
    @Path("/{gymId}")
    public Response viewGym(@PathParam("gymId") String gymId) {
        Gym gym = gymService.viewGym(gymId);
        if (gym != null) {
            return Response.ok(gym).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Gym not found")
                    .build();
        }
    }

    // Endpoint to delete a gym
    @DELETE
    @Path("/{gymId}")
    public Response deleteGym(@PathParam("gymId") String gymId) {
        boolean isDeleted = gymService.deleteGym(gymId);
        if (isDeleted) {
            return Response.status(Response.Status.OK)
                    .entity("Gym successfully deleted")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Gym not found")
                    .build();
        }
    }
}
