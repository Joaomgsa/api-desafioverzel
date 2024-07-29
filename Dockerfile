# Use a imagem base do OpenJDK 21
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da aplicação para o contêiner
COPY target/api-desafio-verzel.jar /app/api-desafio-verzel.jar

# Exponha a porta em que a aplicação será executada
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "/app/api-desafio-verzel.jar"]