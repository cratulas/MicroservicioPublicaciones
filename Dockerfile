# Usa OpenJDK como base
FROM openjdk:21-ea-24-oracle

# Crea carpeta de trabajo
WORKDIR /app

# Copia el JAR generado (ajusta el nombre real de tu JAR)
COPY target/foro-publicaciones-0.0.1-SNAPSHOT.jar app.jar

# Copia el wallet al contenedor
COPY src/main/resources/Wallet_BDFullStack3 /app/oracle_wallet

# Expón el puerto correcto
EXPOSE 8082

# Ejecuta la app con el perfil docker que usa el wallet en /app/oracle_wallet
CMD ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]
