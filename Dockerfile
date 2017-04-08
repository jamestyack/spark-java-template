FROM maven:3.3.9-jdk-8-onbuild-alpine

RUN cp target/spark-java-template-*-jar-with-dependencies.jar ./spark-java-template-fat.jar
CMD ["java", "-jar", "spark-java-template-fat.jar"]