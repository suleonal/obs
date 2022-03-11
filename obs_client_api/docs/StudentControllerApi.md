# StudentControllerApi

All URIs are relative to *https://localhost:51080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addLectureToStudentUsingPUT**](StudentControllerApi.md#addLectureToStudentUsingPUT) | **PUT** /student/add/{lectureId}/{studentId} | addLectureToStudent
[**deleteByIdUsingDELETE2**](StudentControllerApi.md#deleteByIdUsingDELETE2) | **DELETE** /student/delete/{id} | deleteById
[**deleteLectureToStudentUsingDELETE**](StudentControllerApi.md#deleteLectureToStudentUsingDELETE) | **DELETE** /student/deleteLecture/{studentId}/{lectureId} | deleteLectureToStudent
[**findByIdUsingGET2**](StudentControllerApi.md#findByIdUsingGET2) | **GET** /student/{id} | findById
[**getAllUsingGET2**](StudentControllerApi.md#getAllUsingGET2) | **GET** /student/all | getAll
[**getLecturesByStudentIdUsingGET**](StudentControllerApi.md#getLecturesByStudentIdUsingGET) | **GET** /student/lectures/{studentId} | getLecturesByStudentId
[**saveUsingPOST2**](StudentControllerApi.md#saveUsingPOST2) | **POST** /student/save | save


<a name="addLectureToStudentUsingPUT"></a>
# **addLectureToStudentUsingPUT**
> addLectureToStudentUsingPUT(lectureId, studentId, token)

addLectureToStudent

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.StudentControllerApi;


StudentControllerApi apiInstance = new StudentControllerApi();
Long lectureId = 789L; // Long | lectureId
Long studentId = 789L; // Long | studentId
String token = "token_example"; // String | token
try {
    apiInstance.addLectureToStudentUsingPUT(lectureId, studentId, token);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentControllerApi#addLectureToStudentUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lectureId** | **Long**| lectureId |
 **studentId** | **Long**| studentId |
 **token** | **String**| token |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteByIdUsingDELETE2"></a>
# **deleteByIdUsingDELETE2**
> ResponseEntity deleteByIdUsingDELETE2(id, token)

deleteById

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.StudentControllerApi;


StudentControllerApi apiInstance = new StudentControllerApi();
Long id = 789L; // Long | id
String token = "token_example"; // String | token
try {
    ResponseEntity result = apiInstance.deleteByIdUsingDELETE2(id, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentControllerApi#deleteByIdUsingDELETE2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |
 **token** | **String**| token |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="deleteLectureToStudentUsingDELETE"></a>
# **deleteLectureToStudentUsingDELETE**
> deleteLectureToStudentUsingDELETE(lectureId, studentId, token)

deleteLectureToStudent

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.StudentControllerApi;


StudentControllerApi apiInstance = new StudentControllerApi();
Long lectureId = 789L; // Long | lectureId
Long studentId = 789L; // Long | studentId
String token = "token_example"; // String | token
try {
    apiInstance.deleteLectureToStudentUsingDELETE(lectureId, studentId, token);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentControllerApi#deleteLectureToStudentUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lectureId** | **Long**| lectureId |
 **studentId** | **Long**| studentId |
 **token** | **String**| token |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findByIdUsingGET2"></a>
# **findByIdUsingGET2**
> ResponseEntity findByIdUsingGET2(id, token)

findById

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.StudentControllerApi;


StudentControllerApi apiInstance = new StudentControllerApi();
Long id = 789L; // Long | id
String token = "token_example"; // String | token
try {
    ResponseEntity result = apiInstance.findByIdUsingGET2(id, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentControllerApi#findByIdUsingGET2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |
 **token** | **String**| token |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getAllUsingGET2"></a>
# **getAllUsingGET2**
> List&lt;Student&gt; getAllUsingGET2(token)

getAll

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.StudentControllerApi;


StudentControllerApi apiInstance = new StudentControllerApi();
String token = "token_example"; // String | token
try {
    List<Student> result = apiInstance.getAllUsingGET2(token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentControllerApi#getAllUsingGET2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **token** | **String**| token |

### Return type

[**List&lt;Student&gt;**](Student.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getLecturesByStudentIdUsingGET"></a>
# **getLecturesByStudentIdUsingGET**
> List&lt;Lecture&gt; getLecturesByStudentIdUsingGET(studentId, token)

getLecturesByStudentId

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.StudentControllerApi;


StudentControllerApi apiInstance = new StudentControllerApi();
Long studentId = 789L; // Long | studentId
String token = "token_example"; // String | token
try {
    List<Lecture> result = apiInstance.getLecturesByStudentIdUsingGET(studentId, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentControllerApi#getLecturesByStudentIdUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentId** | **Long**| studentId |
 **token** | **String**| token |

### Return type

[**List&lt;Lecture&gt;**](Lecture.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="saveUsingPOST2"></a>
# **saveUsingPOST2**
> Student saveUsingPOST2(student)

save

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.StudentControllerApi;


StudentControllerApi apiInstance = new StudentControllerApi();
Student student = new Student(); // Student | student
try {
    Student result = apiInstance.saveUsingPOST2(student);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentControllerApi#saveUsingPOST2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **student** | [**Student**](Student.md)| student |

### Return type

[**Student**](Student.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

