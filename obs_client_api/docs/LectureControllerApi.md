# LectureControllerApi

All URIs are relative to *https://localhost:51080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**assignTeacherToLectureUsingPUT**](LectureControllerApi.md#assignTeacherToLectureUsingPUT) | **PUT** /lecture/assign/{teacherId}/{lectureId} | assignTeacherToLecture
[**deleteByIdUsingDELETE1**](LectureControllerApi.md#deleteByIdUsingDELETE1) | **DELETE** /lecture/delete/{id} | deleteById
[**findByIdUsingGET1**](LectureControllerApi.md#findByIdUsingGET1) | **GET** /lecture/{id} | findById
[**getAllUsingGET1**](LectureControllerApi.md#getAllUsingGET1) | **GET** /lecture/all | getAll
[**saveUsingPOST1**](LectureControllerApi.md#saveUsingPOST1) | **POST** /lecture/save | save


<a name="assignTeacherToLectureUsingPUT"></a>
# **assignTeacherToLectureUsingPUT**
> assignTeacherToLectureUsingPUT(lectureId, teacherId)

assignTeacherToLecture

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.LectureControllerApi;


LectureControllerApi apiInstance = new LectureControllerApi();
Long lectureId = 789L; // Long | lectureId
Long teacherId = 789L; // Long | teacherId
try {
    apiInstance.assignTeacherToLectureUsingPUT(lectureId, teacherId);
} catch (ApiException e) {
    System.err.println("Exception when calling LectureControllerApi#assignTeacherToLectureUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lectureId** | **Long**| lectureId |
 **teacherId** | **Long**| teacherId |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="deleteByIdUsingDELETE1"></a>
# **deleteByIdUsingDELETE1**
> deleteByIdUsingDELETE1(id)

deleteById

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.LectureControllerApi;


LectureControllerApi apiInstance = new LectureControllerApi();
Long id = 789L; // Long | id
try {
    apiInstance.deleteByIdUsingDELETE1(id);
} catch (ApiException e) {
    System.err.println("Exception when calling LectureControllerApi#deleteByIdUsingDELETE1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findByIdUsingGET1"></a>
# **findByIdUsingGET1**
> Lecture findByIdUsingGET1(id)

findById

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.LectureControllerApi;


LectureControllerApi apiInstance = new LectureControllerApi();
Long id = 789L; // Long | id
try {
    Lecture result = apiInstance.findByIdUsingGET1(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LectureControllerApi#findByIdUsingGET1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |

### Return type

[**Lecture**](Lecture.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getAllUsingGET1"></a>
# **getAllUsingGET1**
> List&lt;Lecture&gt; getAllUsingGET1()

getAll

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.LectureControllerApi;


LectureControllerApi apiInstance = new LectureControllerApi();
try {
    List<Lecture> result = apiInstance.getAllUsingGET1();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LectureControllerApi#getAllUsingGET1");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Lecture&gt;**](Lecture.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="saveUsingPOST1"></a>
# **saveUsingPOST1**
> Lecture saveUsingPOST1(lecture)

save

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.LectureControllerApi;


LectureControllerApi apiInstance = new LectureControllerApi();
Lecture lecture = new Lecture(); // Lecture | lecture
try {
    Lecture result = apiInstance.saveUsingPOST1(lecture);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LectureControllerApi#saveUsingPOST1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lecture** | [**Lecture**](Lecture.md)| lecture |

### Return type

[**Lecture**](Lecture.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

