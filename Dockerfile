# Etapa 1: build com Maven
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copia todo o código
COPY . .

# Compila o projeto e gera o .jar (pulando testes para agilizar)
RUN mvn clean package -DskipTests

# Etapa 2: runtime com JDK leve
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia apenas o .jar gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
