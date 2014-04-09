package com.example;

import com.example.providers.RuntimeExceptionMapper;
import com.example.resources.UserResource;

import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

public class ExampleService extends com.yammer.dropwizard.Service<ExampleConfiguration> {

    public static void main(String[] args) throws Exception
    {
        new com.example.ExampleService().run(args);
    }

    @Override
    public void initialize(Bootstrap bootstrap) {
        bootstrap.setName("dropwizard-handle-exceptions");
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(ExampleConfiguration configuration, Environment environment) throws Exception {
        environment.addResource(new UserResource());

        environment.addProvider(new RuntimeExceptionMapper());
    }
}
