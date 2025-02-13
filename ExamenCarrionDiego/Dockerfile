# Imagen base de Java 17
FROM openjdk:21-jdk-slim

# Configurar el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado por Spring Boot
COPY target/*.jar app.jar

# Exponer el puerto en el que corre el servicio
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]