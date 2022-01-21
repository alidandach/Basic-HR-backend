FROM maven:3-jdk-11

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN mvn package

CMD [ "sh", "-c", "mvn spring-boot:run" ]
