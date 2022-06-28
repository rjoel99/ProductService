FROM openjdk:11.0.15-slim-buster@sha256:217e6d238a23a64406dc39ad67482bd0262928144406baf57b69a38546550171 as build
WORKDIR /app
COPY pom.xml .
COPY src /app/src
RUN mvn package -DskipTests

FROM openjdk:11.0.15-jre-slim-buster@sha256:a6ba07428612002089fe8d4c02f77e4957ee9420cba3ee18d6a8a65dcfbfafe2
WORKDIR /usr/app
COPY --from=build /app/target/*.jar .
ENTRYPOINT ["java", "-jar", "product-service.jar"]