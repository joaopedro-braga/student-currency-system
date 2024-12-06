FROM maven:3.8.4-openjdk-17-slim AS build  

WORKDIR /app

COPY scs-backend/pom.xml .  
COPY scs-backend/src ./src      

RUN mvn dependency:go-offline -B 
RUN mvn package -DskipTests       

FROM openjdk:17-jdk-slim        

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar 

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]