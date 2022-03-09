package com.argela.obs.frontend.ui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tr.com.argela.obs.client.api.GradeControllerApi;
import tr.com.argela.obs.client.api.LectureControllerApi;
import tr.com.argela.obs.client.api.StudentControllerApi;
import tr.com.argela.obs.client.api.TeacherControllerApi;
import tr.com.argela.obs.client.api.UserControllerApi;
import tr.com.argela.obs.client.invoker.ApiClient;

@Configuration
public class FrontendConfig {
    
    @Bean
    public ApiClient getApiClient(){
        ApiClient apiClient = new ApiClient();
		apiClient.setBasePath("http://localhost:51080");
        return apiClient;
    }

    @Bean
    public UserControllerApi getUserControllerApi(){
        return new UserControllerApi(getApiClient());
    }

    @Bean
    public StudentControllerApi getStudentControllerApi(){
        return new StudentControllerApi(getApiClient());
    }

    @Bean
    public TeacherControllerApi getTeacherControllerApi(){
        return new TeacherControllerApi(getApiClient());
    }

    @Bean
    public GradeControllerApi getGradeControllerApi(){
        return new GradeControllerApi(getApiClient());
    }

    @Bean
    public LectureControllerApi getLectureControllerApi(){
        return new LectureControllerApi(getApiClient());
    }


}
