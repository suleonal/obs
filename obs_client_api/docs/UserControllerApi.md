# UserControllerApi

All URIs are relative to *https://localhost:51080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getLoggedUserUsingGET**](UserControllerApi.md#getLoggedUserUsingGET) | **GET** /user/logged-user | getLoggedUser
[**loginUsingPUT**](UserControllerApi.md#loginUsingPUT) | **PUT** /user/login/{user}/{password} | login
[**logoutUsingDELETE**](UserControllerApi.md#logoutUsingDELETE) | **DELETE** /user/logout/{token} | logout


<a name="getLoggedUserUsingGET"></a>
# **getLoggedUserUsingGET**
> LoggedUser getLoggedUserUsingGET(token)

getLoggedUser

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.UserControllerApi;


UserControllerApi apiInstance = new UserControllerApi();
String token = "token_example"; // String | token
try {
    LoggedUser result = apiInstance.getLoggedUserUsingGET(token);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserControllerApi#getLoggedUserUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **token** | **String**| token |

### Return type

[**LoggedUser**](LoggedUser.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="loginUsingPUT"></a>
# **loginUsingPUT**
> String loginUsingPUT(password, user)

login

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.UserControllerApi;


UserControllerApi apiInstance = new UserControllerApi();
String password = "password_example"; // String | password
String user = "user_example"; // String | user
try {
    String result = apiInstance.loginUsingPUT(password, user);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserControllerApi#loginUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **password** | **String**| password |
 **user** | **String**| user |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="logoutUsingDELETE"></a>
# **logoutUsingDELETE**
> logoutUsingDELETE(token)

logout

### Example
```java
// Import classes:
//import tr.com.argela.obs.client.invoker.ApiException;
//import tr.com.argela.obs.client.api.UserControllerApi;


UserControllerApi apiInstance = new UserControllerApi();
String token = "token_example"; // String | token
try {
    apiInstance.logoutUsingDELETE(token);
} catch (ApiException e) {
    System.err.println("Exception when calling UserControllerApi#logoutUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **token** | **String**| token |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

