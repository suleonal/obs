# TeacherControllerApi

All URIs are relative to *https://localhost:51080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteByIdUsingDELETE3**](TeacherControllerApi.md#deleteByIdUsingDELETE3) | **DELETE** /teacher/delete/{id} | deleteById
[**findByIdUsingGET3**](TeacherControllerApi.md#findByIdUsingGET3) | **GET** /teacher/{id} | findById
[**getAllUsingGET3**](TeacherControllerApi.md#getAllUsingGET3) | **GET** /teacher/all | getAll
[**getLecturesByTeacherIdUsingGET**](TeacherControllerApi.md#getLecturesByTeacherIdUsingGET) | **GET** /teacher/lectures/{teacherId} | getLecturesByTeacherId
[**saveUsingPOST3**](TeacherControllerApi.md#saveUsingPOST3) | **POST** /teacher/save | save


<a name="deleteByIdUsingDELETE3"></a>
# **deleteByIdUsingDELETE3**
> ResponseEntity deleteByIdUsingDELETE3(id, token)

deleteById

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.TeacherControllerApi;


TeacherControllerApi apiInstance = new TeacherControllerApi();
Long id = 789L; // Long | id
String token = "token_example"; // String | token
try {
    ResponseEntity result = apiInstance.deleteByIdUsingDELETE3(id, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeacherControllerApi#deleteByIdUsingDELETE3");
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

<a name="findByIdUsingGET3"></a>
# **findByIdUsingGET3**
> ResponseEntity findByIdUsingGET3(id, token)

findById

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.TeacherControllerApi;


TeacherControllerApi apiInstance = new TeacherControllerApi();
Long id = 789L; // Long | id
String token = "token_example"; // String | token
try {
    ResponseEntity result = apiInstance.findByIdUsingGET3(id, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeacherControllerApi#findByIdUsingGET3");
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

<a name="getAllUsingGET3"></a>
# **getAllUsingGET3**
> List&lt;Teacher&gt; getAllUsingGET3(token)

getAll

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.TeacherControllerApi;


TeacherControllerApi apiInstance = new TeacherControllerApi();
String token = "token_example"; // String | token
try {
    List<Teacher> result = apiInstance.getAllUsingGET3(token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeacherControllerApi#getAllUsingGET3");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **token** | **String**| token |

### Return type

[**List&lt;Teacher&gt;**](Teacher.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getLecturesByTeacherIdUsingGET"></a>
# **getLecturesByTeacherIdUsingGET**
> List&lt;Lecture&gt; getLecturesByTeacherIdUsingGET(teacherId, token)

getLecturesByTeacherId

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.TeacherControllerApi;


TeacherControllerApi apiInstance = new TeacherControllerApi();
Integer teacherId = 56; // Integer | teacherId
String token = "token_example"; // String | token
try {
    List<Lecture> result = apiInstance.getLecturesByTeacherIdUsingGET(teacherId, token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeacherControllerApi#getLecturesByTeacherIdUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teacherId** | **Integer**| teacherId |
 **token** | **String**| token |

### Return type

[**List&lt;Lecture&gt;**](Lecture.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="saveUsingPOST3"></a>
# **saveUsingPOST3**
> Teacher saveUsingPOST3(teacher)

save

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.TeacherControllerApi;


TeacherControllerApi apiInstance = new TeacherControllerApi();
Teacher teacher = new Teacher(); // Teacher | teacher
try {
    Teacher result = apiInstance.saveUsingPOST3(teacher);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeacherControllerApi#saveUsingPOST3");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teacher** | [**Teacher**](Teacher.md)| teacher |

### Return type

[**Teacher**](Teacher.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

