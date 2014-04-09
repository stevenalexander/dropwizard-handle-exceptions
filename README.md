# Dropwizard Handle Exceptions

Sample application showing how to create an exception provider which catches exceptions thrown inside resources and handles them gracefully in your application.

This is a simple dropwizard implementation for returning HTML, using Freemarker as the templating engine. It's based on the Dropwizard example [here](http://dropwizard.codahale.com/manual/views/). Uses SBT for build.

## Setup

To compile:

```
./sbt assembly
```

To run:

```
java -jar target/scala-2.10/dropwizard-handle-exceptions-assembly-0.1.jar server config.yml
```
