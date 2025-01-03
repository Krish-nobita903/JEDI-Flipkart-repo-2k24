package com.flipfit.app;

import com.flipfit.service.AdminServiceOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipfit.restcontroller.*;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<Configuration>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
//          e.jersey().register(new EmployeeRESTController(e.getValidator()));
//        System.out.println("/nAdmin Working/n");
        e.jersey().register(new AdminController(new AdminServiceOperation()));
        e.jersey().register(new GymManagerController());
//        e.jersey().register(new GymController());
        e.jersey().register(new HelloController());
//        e.jersey().register(new UserController());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}