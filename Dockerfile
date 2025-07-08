# Usar una imagen base oficial de OpenJDK 17
FROM eclipse-temurin:17-jre-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el jar generado por Spring Boot al contenedor
COPY target/inventory-service-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto configurado en application.yml
EXPOSE 8083

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

