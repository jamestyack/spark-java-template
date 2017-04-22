Spark Java Starter Template with Dockerfile
-------------------------------------------

Clone repo to chosen name ```git clone https://github.com/jamestyack/spark-java-template.git <desiredname>```

```docker build -t spark-java-template:0.1 .``` builds image that uses maven to run tests/build fat JAR; includes command for starting app. Image is lightweight (jdk-8-onbuild-alpine) - more at https://hub.docker.com/r/library/maven/ and see Dockerfile

... and run/start container (and app) e.g.

```docker run -it -p 4567:4567 spark-java-template:0.1```

Sample endpoint:-

```http://<host>:4567/api/v1/greeting/fred```