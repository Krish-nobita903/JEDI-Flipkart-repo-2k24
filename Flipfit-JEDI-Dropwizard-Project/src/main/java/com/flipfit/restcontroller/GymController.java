package com.flipfit.controller;

import com.flipfit.bean.Slot;
import com.flipfit.service.GymService;
import com.flipfit.service.GymInterface;
import com.flipfit.exception.BookingFailedException;
import com.flipfit.exception.UpdateFailedException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gym")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GymController {

    private final GymInterface gymService;

    public GymController(GymInterface gymService) {
        this.gymService = gymService;
    }

    // Endpoint to view bookings for a specific gym
    @GET
    @Path("/{gymId}/bookings")
    public Response viewBookings(@PathParam("gymId") String gymId) {
        try {
            List<Slot> bookings = gymService.viewBookings(gymId);
            if (bookings.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No bookings found for gym " + gymId)
                        .build();
            }
            return Response.ok(bookings).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to retrieve bookings: " + e.getMessage())
                    .build();
        }
    }

    // Endpoint to update available training slots for a gym
    @PUT
    @Path("/{gymId}/trainings")
    public Response updateTrainingsAvailable(@PathParam("gymId") String gymId, List<String> updatedTrainings) {
        try {
            gymService.updateTrainingsAvailable(gymId, updatedTrainings);
            return Response.ok("Trainings updated successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to update trainings: " + e.getMessage())
                    .build();
        }
    }

    // Endpoint to get available slots for a specific gym
    @GET
    @Path("/{gymId}/available-slots")
    public Response isAvailableSlots(@PathParam("gymId") Integer gymId) {
        try {
            List<Slot> availableSlots = gymService.isAvailableSlots(gymId);
            if (availableSlots == null || availableSlots.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No available slots for gym " + gymId)
                        .build();
            }
            return Response.ok(availableSlots).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to fetch available slots: " + e.getMessage())
                    .build();
        }
    }
}
