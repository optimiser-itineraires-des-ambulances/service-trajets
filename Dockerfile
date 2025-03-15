FROM openjdk:17-slim
# Switch to root user to install additional packages
USER root

# Add MongoDB official repository
RUN apt-get update && apt-get install -y wget gnupg && \
    wget -qO - https://www.mongodb.org/static/pgp/server-4.4.asc | apt-key add - && \
    echo "deb http://repo.mongodb.org/apt/debian buster/mongodb-org/4.4 main" | tee /etc/apt/sources.list.d/mongodb-org-4.4.list && \
    apt-get update && apt-get install -y mongodb-org-shell && apt-get clean

VOLUME /tmp
ADD target/service-trajet-docker.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]