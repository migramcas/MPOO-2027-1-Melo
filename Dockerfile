# Compilar desde la raíz: el proyecto contiene cuatro módulos Maven.
FROM maven:3.9.11-eclipse-temurin-25 AS build
WORKDIR /workspace

# No se copian archivos de target/ ni configuraciones del IDE (.dockerignore).
COPY . .

# -am incluye melo-domain, melo-application y melo-infra.
# -DskipTests omite ejecutar pruebas, pero sí las compila.
RUN mvn -B -ntp -pl melo-api -am -DskipTests package

# Imagen ligera para ejecutar la API (sin Maven ni compilador).
FROM eclipse-temurin:25-jre AS runtime
WORKDIR /app
COPY --from=build /workspace/melo-api/target/melo-api-1.0.0.jar /app/melo-api.jar

ENV SERVER_PORT=8080
EXPOSE 8080

# Usuario no privilegiado: la aplicación no necesita permisos de root.
USER 10001:10001
ENTRYPOINT ["java", "-jar", "/app/melo-api.jar"]
