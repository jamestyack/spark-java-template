Spark Java Starter Template with Dockerfile
-------------------------------------------

This builds image that uses maven to run tests/build fat JAR; includes command for starting app. Image is lightweight (jdk-8-onbuild-alpine)

```docker build -t spark-java-template:0.1 .```

... and run/start app (e.g.)

```docker run -it -p 4567:4567 spark-java-template:0.1```