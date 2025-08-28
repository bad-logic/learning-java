FROM amazoncorretto:21-alpine3.21

WORKDIR /app
COPY target target
#- cp classpath
# target/classes -> projects compiled classes
# target/dependencies -> project dependencies
CMD ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005","-Dserver.address=0.0.0.0","-cp","target/classes:target/dependency/*","com.example.spring.security.Application"]
