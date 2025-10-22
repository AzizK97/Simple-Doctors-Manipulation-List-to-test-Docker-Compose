FROM tomcat:9.0.110-jdk17-temurin-noble

# Remove default ROOT application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the WAR file to webapps
COPY doctorapp/target/doctor-app.war /usr/local/tomcat/webapps/doctor-app.war

# Expose port 8080
EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=5s --start-period=20s --retries=3 \
	CMD curl -f http://localhost:8080/doctor-app/ || exit 1
