# Etapa de construcción
FROM gradle:jdk17 AS builder

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos de Gradle y el código fuente
COPY ./customer-service .

# Construir el proyecto
RUN gradle build --no-daemon

# Etapa de ejecución
FROM openjdk:17-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el JAR construido desde la etapa de construcción
COPY --from=builder /app/build/libs/*.jar app.jar

# Exponer el puerto que usa la aplicación
EXPOSE 8084

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]