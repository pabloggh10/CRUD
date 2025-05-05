FROM amazoncorretto:17-alpine-jdk

# Crear un directorio de trabajo
WORKDIR /app

# Copiar el JAR al contenedor
COPY target/crud-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando de entrada
ENTRYPOINT ["java","-jar","app.jar"]
