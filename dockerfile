# Use a imagem base do OpenJDK 21
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da aplicação para o contêiner
COPY target/api-desafioverzel-0.0.1-SNAPSHOT.jar /app/api-desafioverzel-0.0.1-SNAPSHOT.jar


# Porta em que a aplicação será executada
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "/app/api-desafioverzel-0.0.1-SNAPSHOT.jar"]