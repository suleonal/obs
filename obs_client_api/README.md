# obs-api-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>tr.com.argela</groupId>
    <artifactId>obs-api-client</artifactId>
    <version>1.8</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "tr.com.argela:obs-api-client:1.8"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/obs-api-client-1.8.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import tr.com.argela.obs.client.invoker.*;
import tr.com.argela.obs.client.invoker.auth.*;
import tr.com.argela.obs.client.model.*;
import tr.com.argela.obs.client.api.GradeControllerApi;

import java.io.File;
import java.util.*;

public class GradeControllerApiExample {

    public static void main(String[] args) {
        
        GradeControllerApi apiInstance = new GradeControllerApi();
        Long id = 789L; // Long | id
        String token = "token_example"; // String | token
        try {
            apiInstance.deleteByIdUsingDELETE(id, token);
        } catch (ApiException e) {
            System.err.println("Exception when calling GradeControllerApi#deleteByIdUsingDELETE");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost:51080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*GradeControllerApi* | [**deleteByIdUsingDELETE**](docs/GradeControllerApi.md#deleteByIdUsingDELETE) | **DELETE** /grade/delete/{id} | deleteById
*GradeControllerApi* | [**findByIdUsingGET**](docs/GradeControllerApi.md#findByIdUsingGET) | **GET** /grade/{id} | findById
*GradeControllerApi* | [**getAllUsingGET**](docs/GradeControllerApi.md#getAllUsingGET) | **GET** /grade/all | getAll
*GradeControllerApi* | [**getGradeLectureByIdUsingGET**](docs/GradeControllerApi.md#getGradeLectureByIdUsingGET) | **GET** /grade/lecture/{lectureId} | getGradeLectureById
*GradeControllerApi* | [**getGradeStudentByIdUsingGET**](docs/GradeControllerApi.md#getGradeStudentByIdUsingGET) | **GET** /grade/student/{studentId} | getGradeStudentById
*GradeControllerApi* | [**getGradesByLectureStudentIdUsingGET**](docs/GradeControllerApi.md#getGradesByLectureStudentIdUsingGET) | **GET** /grade/control/{lectureId}/{studentId} | getGradesByLectureStudentId
*GradeControllerApi* | [**saveUsingPOST**](docs/GradeControllerApi.md#saveUsingPOST) | **POST** /grade/save | save
*GradeControllerApi* | [**valueUsingPUT**](docs/GradeControllerApi.md#valueUsingPUT) | **PUT** /grade/value/{lectureId}/{studentId}/{value} | value
*LectureControllerApi* | [**assignTeacherToLectureUsingPUT**](docs/LectureControllerApi.md#assignTeacherToLectureUsingPUT) | **PUT** /lecture/assign/{teacherId}/{lectureId} | assignTeacherToLecture
*LectureControllerApi* | [**deleteByIdUsingDELETE1**](docs/LectureControllerApi.md#deleteByIdUsingDELETE1) | **DELETE** /lecture/delete/{id} | deleteById
*LectureControllerApi* | [**findByIdUsingGET1**](docs/LectureControllerApi.md#findByIdUsingGET1) | **GET** /lecture/{id} | findById
*LectureControllerApi* | [**getAllUsingGET1**](docs/LectureControllerApi.md#getAllUsingGET1) | **GET** /lecture/all | getAll
*LectureControllerApi* | [**saveUsingPOST1**](docs/LectureControllerApi.md#saveUsingPOST1) | **POST** /lecture/save | save
*StudentControllerApi* | [**addLectureToStudentUsingPUT**](docs/StudentControllerApi.md#addLectureToStudentUsingPUT) | **PUT** /student/add/{lectureId}/{studentId} | addLectureToStudent
*StudentControllerApi* | [**deleteByIdUsingDELETE2**](docs/StudentControllerApi.md#deleteByIdUsingDELETE2) | **DELETE** /student/delete/{id} | deleteById
*StudentControllerApi* | [**deleteLectureToStudentUsingDELETE**](docs/StudentControllerApi.md#deleteLectureToStudentUsingDELETE) | **DELETE** /student/deleteLecture/{studentId}/{lectureId} | deleteLectureToStudent
*StudentControllerApi* | [**findByIdUsingGET2**](docs/StudentControllerApi.md#findByIdUsingGET2) | **GET** /student/{id} | findById
*StudentControllerApi* | [**getAllUsingGET2**](docs/StudentControllerApi.md#getAllUsingGET2) | **GET** /student/all | getAll
*StudentControllerApi* | [**getLecturesByStudentIdUsingGET**](docs/StudentControllerApi.md#getLecturesByStudentIdUsingGET) | **GET** /student/lectures/{studentId} | getLecturesByStudentId
*StudentControllerApi* | [**saveUsingPOST2**](docs/StudentControllerApi.md#saveUsingPOST2) | **POST** /student/save | save
*TeacherControllerApi* | [**deleteByIdUsingDELETE3**](docs/TeacherControllerApi.md#deleteByIdUsingDELETE3) | **DELETE** /teacher/delete/{id} | deleteById
*TeacherControllerApi* | [**findByIdUsingGET3**](docs/TeacherControllerApi.md#findByIdUsingGET3) | **GET** /teacher/{id} | findById
*TeacherControllerApi* | [**getAllUsingGET3**](docs/TeacherControllerApi.md#getAllUsingGET3) | **GET** /teacher/all | getAll
*TeacherControllerApi* | [**getLecturesByTeacherIdUsingGET**](docs/TeacherControllerApi.md#getLecturesByTeacherIdUsingGET) | **GET** /teacher/lectures/{teacherId} | getLecturesByTeacherId
*TeacherControllerApi* | [**saveUsingPOST3**](docs/TeacherControllerApi.md#saveUsingPOST3) | **POST** /teacher/save | save
*UserControllerApi* | [**getLoggedUserUsingGET**](docs/UserControllerApi.md#getLoggedUserUsingGET) | **GET** /user/logged-user | getLoggedUser
*UserControllerApi* | [**loginUsingPUT**](docs/UserControllerApi.md#loginUsingPUT) | **PUT** /user/login/{user}/{password} | login
*UserControllerApi* | [**logoutUsingDELETE**](docs/UserControllerApi.md#logoutUsingDELETE) | **DELETE** /user/logout/{token} | logout


## Documentation for Models

 - [Grade](docs/Grade.md)
 - [Lecture](docs/Lecture.md)
 - [LoggedUser](docs/LoggedUser.md)
 - [ResponseEntity](docs/ResponseEntity.md)
 - [Student](docs/Student.md)
 - [Teacher](docs/Teacher.md)
 - [User](docs/User.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



