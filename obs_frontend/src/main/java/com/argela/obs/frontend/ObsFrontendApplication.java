package com.argela.obs.frontend;

import java.util.List;

import com.argela.obs.frontend.ui.console.MainView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.util.SystemPropertyUtils;

import tr.com.argela.obs.client.api.StudentControllerApi;
import tr.com.argela.obs.client.api.UserControllerApi;
import tr.com.argela.obs.client.invoker.ApiClient;
import tr.com.argela.obs.client.model.Lecture;
import tr.com.argela.obs.client.model.Student;

import org.springframework.boot.context.event.ApplicationReadyEvent;

@SpringBootApplication
public class ObsFrontendApplication {

	@Autowired
	MainView mainView;

	public static void main(String[] args) {
		SpringApplication.run(ObsFrontendApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onAppRun() {
		mainView.start();  // entry point of application
	}

}
