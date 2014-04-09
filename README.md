# Dropwizard Handle Exceptions

Sample application showing how to create an exception provider which catches exceptions thrown inside resources and handles them gracefully in your application.

## Setup

To compile:

```
./sbt assembly
```

To run:

```
java -jar target/scala-2.10/dropwizard-handle-exceptions-assembly-0.1.jar server config.yml
```

## Details

This example uses a Jetty Provider ExceptionMapper
([RuntimeExceptionMapper.java](/src/main/java/com/example/providers/RuntimeExceptionMapper.java))
to handle any RuntimeExceptions thrown inside the application, which logs the exception and returns an appropriate response.

```
package com.example.providers;

...
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
...

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException exception) {

        Response response500 = Response
                .serverError()
                .entity(new ErrorView(exception, "500.ftl"))
                .build();

        ...

        return response500;
    }
}
```

The provider should be added to the environment in the Run method of the Service class.

```
package com.example;

...

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

```

Got the idea from [here](http://gary-rowe.com/agilestack/2012/10/23/how-to-implement-a-runtimeexceptionmapper-for-dropwizard/).