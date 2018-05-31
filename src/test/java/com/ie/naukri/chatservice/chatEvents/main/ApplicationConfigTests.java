package com.ie.naukri.chatservice.chatEvents.main;

import com.ie.naukri.test.utils.SystemPropertyActiveProfileResolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class, webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "dev", resolver = SystemPropertyActiveProfileResolver.class)
public class ApplicationConfigTests {

	@Test
	public void contextLoads() {
	}

}
