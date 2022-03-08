package tr.com.argela.obs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class ObsBackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ObsBackendApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onAppRun() {
		System.out.println("OBS App is running");
	}

}
