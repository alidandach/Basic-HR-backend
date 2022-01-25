# Getting Started

#### I wrote this challenge using java and based on Spring/Spring boot Framework with Postgres. I use basic authentication for authentication. 

The docker-compose has three phases to run this application:
1. pull postgres database
2. run postgres db
3. run the API

###### Note: The API contains initial data

### Run Instruction using docker:
1. clone the project
2. navigate to the project director
3. `docker-compose up`

###### Note: The running container reserve the port 9595 for API and you can change it from `docker-compose.yml` and after you finish please run this command `docker-compose down --volumes`

### Run Instruction without docker
- Make sure you have java 11
- create a new db named 'hr-db' on your postgresql server (You can edit `src/main/resources/application.yaml` if you want to change the db name)
- At the runtime the API create a new schema and tables with initial data
- You can build a new jar file using maven `./mvn package`
- Run it using java `java -jar target/hr-app.jar`


### Overall:
- You have the postman collection `Challenge 1.postman_collection.json`
- Also, I put swagger `http://localhost:9595/swagger-ui`
- I write test cases

### Example of API response:

```json
{
  "status": "Illegal operation",
  "code": 2005,
  "errorDetails": [
    {
      "reason": "the department name cannot be null or empty"
    }
  ]
}
```

```json
{
  "status": "Success",
  "code": 1000
}
```

```json
{
  "status": "Invalid Method Argument",
  "code": 2001,
  "errorDetails": [
    {
      "reason": "Required request body is missing"
    }
  ]
}
```

```json
{
  "status": "Illegal operation",
  "code": 2005,
  "errorDetails": [
    {
      "reason": "Duplicate Record"
    }
  ]
}
```

```json
{
  "id": 1,
  "employees": {
    "totalPages": 2,
    "totalElements": 4,
    "data": [
      {
        "id": 3,
        "name": "X3",
        "email": "X3@ccc.net",
        "address": "LEB"
      },
      {
        "id": 4,
        "name": "X4",
        "email": "X4@ccc.net",
        "address": "LEB"
      }
    ]
  }
}
```