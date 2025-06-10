# Usa una imagen base de Java 17
FROM eclipse-temurin:23-jdk

# Crea el directorio del app
WORKDIR /app

# Copia el jar compilado
COPY target/*.jar app.jar

# Expone el puerto del servicio (ajústalo si es necesario)
EXPOSE 8080

# Comando de ejecución
ENTRYPOINT ["java", "-jar", "app.jar"]
