# Dockerfile
FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=123456

# Copy the init SQL script into the container
COPY ./src/main/resources/init.sql /docker-entrypoint-initdb.d/
