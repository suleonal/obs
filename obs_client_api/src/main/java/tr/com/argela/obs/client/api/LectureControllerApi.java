package tr.com.argela.obs.client.api;

import tr.com.argela.obs.client.invoker.ApiClient;

import tr.com.argela.obs.client.model.Lecture;
import tr.com.argela.obs.client.model.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-03-14T16:52:04.716+03:00")
@Component("tr.com.argela.obs.client.api.LectureControllerApi")
public class LectureControllerApi {
    private ApiClient apiClient;

    public LectureControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public LectureControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * assignTeacherToLecture
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param lectureId lectureId
     * @param teacherId teacherId
     * @param token token
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void assignTeacherToLectureUsingPUT(Long lectureId, Long teacherId, String token) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'lectureId' is set
        if (lectureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lectureId' when calling assignTeacherToLectureUsingPUT");
        }
        
        // verify the required parameter 'teacherId' is set
        if (teacherId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teacherId' when calling assignTeacherToLectureUsingPUT");
        }
        
        // verify the required parameter 'token' is set
        if (token == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'token' when calling assignTeacherToLectureUsingPUT");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("lectureId", lectureId);
        uriVariables.put("teacherId", teacherId);
        String path = UriComponentsBuilder.fromPath("/lecture/assign/{teacherId}/{lectureId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        if (token != null)
        headerParams.add("token", apiClient.parameterToString(token));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * deleteById
     * 
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * @param id id
     * @param token token
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteByIdUsingDELETE1(Long id, String token) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteByIdUsingDELETE1");
        }
        
        // verify the required parameter 'token' is set
        if (token == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'token' when calling deleteByIdUsingDELETE1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/lecture/delete/{id}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        if (token != null)
        headerParams.add("token", apiClient.parameterToString(token));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * findById
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id id
     * @param token token
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity findByIdUsingGET1(Long id, String token) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling findByIdUsingGET1");
        }
        
        // verify the required parameter 'token' is set
        if (token == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'token' when calling findByIdUsingGET1");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/lecture/{id}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        if (token != null)
        headerParams.add("token", apiClient.parameterToString(token));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<ResponseEntity> returnType = new ParameterizedTypeReference<ResponseEntity>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * getAll
     * 
     * <p><b>200</b> - OK
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param token token
     * @return List&lt;Lecture&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Lecture> getAllUsingGET1(String token) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'token' is set
        if (token == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'token' when calling getAllUsingGET1");
        }
        
        String path = UriComponentsBuilder.fromPath("/lecture/all").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        if (token != null)
        headerParams.add("token", apiClient.parameterToString(token));

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Lecture>> returnType = new ParameterizedTypeReference<List<Lecture>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * save
     * 
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param lecture lecture
     * @return Lecture
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Lecture saveUsingPOST1(Lecture lecture) throws RestClientException {
        Object postBody = lecture;
        
        // verify the required parameter 'lecture' is set
        if (lecture == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lecture' when calling saveUsingPOST1");
        }
        
        String path = UriComponentsBuilder.fromPath("/lecture/save").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "*/*"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Lecture> returnType = new ParameterizedTypeReference<Lecture>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
