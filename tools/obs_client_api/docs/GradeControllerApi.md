# GradeControllerApi

All URIs are relative to *https://localhost:51080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteByIdUsingDELETE**](GradeControllerApi.md#deleteByIdUsingDELETE) | **DELETE** /grade/delete/{id} | deleteById
[**findByIdUsingGET**](GradeControllerApi.md#findByIdUsingGET) | **GET** /grade/{id} | findById
[**getAllUsingGET**](GradeControllerApi.md#getAllUsingGET) | **GET** /grade/all | getAll
[**getGradeLectureByIdUsingGET**](GradeControllerApi.md#getGradeLectureByIdUsingGET) | **GET** /grade/lecture/{lectureId} | getGradeLectureById
[**getGradeStudentByIdUsingGET**](GradeControllerApi.md#getGradeStudentByIdUsingGET) | **GET** /grade/student/{studentId} | getGradeStudentById
[**getGradesByLectureStudentIdUsingGET**](GradeControllerApi.md#getGradesByLectureStudentIdUsingGET) | **GET** /grade/control/{lectureId}/{studentId} | getGradesByLectureStudentId
[**saveUsingPOST**](GradeControllerApi.md#saveUsingPOST) | **POST** /grade/save | save
[**valueUsingPUT**](GradeControllerApi.md#valueUsingPUT) | **PUT** /grade/value/{lectureId}/{studentId}/{value} | value


<a name="deleteByIdUsingDELETE"></a>
# **deleteByIdUsingDELETE**
> deleteByIdUsingDELETE(id, token)

deleteById

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.GradeControllerApi;


GradeControllerApi apiInstance = new GradeControllerApi();
Long id = 789L; // Long | id
String token = "token_example"; // String | token
try {
    apiInstance.deleteByIdUsingDELETE(id, token);
} catch (ApiException e) {
    System.err.println("Exception when calling GradeControllerApi#deleteByIdUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |
 **token** | **String**| token |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findByIdUsingGET"></a>
# **findByIdUsingGET**
> ResponseEntity findByIdUsingGET(id, token)

findById

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.GradeControllerApi;


GradeControllerApi apiInstance = new GradeControllerApi();
Long id = 789L; // Long | id
String token = "token_example"; // String | token
try {
    ResponseEntity result = apiInstance.findByIdUsingGET(id, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GradeControllerApi#findByIdUsingGET");
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

<a name="getAllUsingGET"></a>
# **getAllUsingGET**
> List&lt;Grade&gt; getAllUsingGET(token)

getAll

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.GradeControllerApi;


GradeControllerApi apiInstance = new GradeControllerApi();
String token = "token_example"; // String | token
try {
    List<Grade> result = apiInstance.getAllUsingGET(token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GradeControllerApi#getAllUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **token** | **String**| token |

### Return type

[**List&lt;Grade&gt;**](Grade.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getGradeLectureByIdUsingGET"></a>
# **getGradeLectureByIdUsingGET**
> List&lt;Grade&gt; getGradeLectureByIdUsingGET(lectureId, token)

getGradeLectureById

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.GradeControllerApi;


GradeControllerApi apiInstance = new GradeControllerApi();
Long lectureId = 789L; // Long | lectureId
String token = "token_example"; // String | token
try {
    List<Grade> result = apiInstance.getGradeLectureByIdUsingGET(lectureId, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GradeControllerApi#getGradeLectureByIdUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lectureId** | **Long**| lectureId |
 **token** | **String**| token |

### Return type

[**List&lt;Grade&gt;**](Grade.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getGradeStudentByIdUsingGET"></a>
# **getGradeStudentByIdUsingGET**
> List&lt;Grade&gt; getGradeStudentByIdUsingGET(studentId, token)

getGradeStudentById

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.GradeControllerApi;


GradeControllerApi apiInstance = new GradeControllerApi();
Long studentId = 789L; // Long | studentId
String token = "token_example"; // String | token
try {
    List<Grade> result = apiInstance.getGradeStudentByIdUsingGET(studentId, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GradeControllerApi#getGradeStudentByIdUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentId** | **Long**| studentId |
 **token** | **String**| token |

### Return type

[**List&lt;Grade&gt;**](Grade.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getGradesByLectureStudentIdUsingGET"></a>
# **getGradesByLectureStudentIdUsingGET**
> List&lt;Grade&gt; getGradesByLectureStudentIdUsingGET(lectureId, studentId, token)

getGradesByLectureStudentId

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.GradeControllerApi;


GradeControllerApi apiInstance = new GradeControllerApi();
Long lectureId = 789L; // Long | lectureId
Long studentId = 789L; // Long | studentId
String token = "token_example"; // String | token
try {
    List<Grade> result = apiInstance.getGradesByLectureStudentIdUsingGET(lectureId, studentId, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GradeControllerApi#getGradesByLectureStudentIdUsingGET");
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

[**List&lt;Grade&gt;**](Grade.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="saveUsingPOST"></a>
# **saveUsingPOST**
> Grade saveUsingPOST(grade)

save

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.GradeControllerApi;


GradeControllerApi apiInstance = new GradeControllerApi();
Grade grade = new Grade(); // Grade | grade
try {
    Grade result = apiInstance.saveUsingPOST(grade);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GradeControllerApi#saveUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **grade** | [**Grade**](Grade.md)| grade |

### Return type

[**Grade**](Grade.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="valueUsingPUT"></a>
# **valueUsingPUT**
> Grade valueUsingPUT(lectureId, studentId, token, value)

value

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.GradeControllerApi;


GradeControllerApi apiInstance = new GradeControllerApi();
Long lectureId = 789L; // Long | lectureId
Long studentId = 789L; // Long | studentId
String token = "token_example"; // String | token
Integer value = 56; // Integer | value
try {
    Grade result = apiInstance.valueUsingPUT(lectureId, studentId, token, value);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GradeControllerApi#valueUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lectureId** | **Long**| lectureId |
 **studentId** | **Long**| studentId |
 **token** | **String**| token |
 **value** | **Integer**| value |

### Return type

[**Grade**](Grade.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

