# MVP SURVEY SYSTEM
MvpSurveyApplication version 1.0.0-SNAPSHOT

"Building a RESTful Web Service with Spring Boot using an H2 in-memory database"

# Technologies used
* Java 17
* Spring Boot
* H2 Database(in-memory database)
* Postman(for API testing)

# Libraries used
* Lombok
* SLF4j
* Junit5
* Jacoco

#Build
* Maven

#Functionality
* createSurvey - to create a survey with multiple-choice questions
* getSurveyById - to get survey based on surveyId
* getAllSurveys - to get All surveys

#APIs
Please find below request & response files path 
* Request : src/main/resources/json_request/CreateSurveyRequest.json
* Response : src/main/resources/json_request/CreateSurveyResponse.json

| No  | Name         | API                                             | method | Request                  | Response                  |
|-----|--------------|-------------------------------------------------|--------|--------------------------|---------------------------|
| 1   | createSurvey | localhost:8080/surveySystem/createSurvey | POST   | CreateSurveyRequest.json | CreateSurveyResponse.json |
| 2   |    getSurveyById  |    localhost:8080/surveySystem/getSurveyById?surveyId=1                                            | GET    | NONE                     | NONE                      |
| 3   |    getAllSurveys  |        localhost:8080/surveySystem/getAllSurveys                                         | GET    | NONE                     | NONE                      |
|     |      |                                                 |        |                          |                           |
