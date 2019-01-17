package com.bmo.configmapbooster;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

import com.bmo.configmapbooster.service.MessageProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConfigmapBoosterApplicationTests {

	protected static final String GREETING_PATH = "api/greeting";
	@Value("${local.server.port}")
	private int port;

	@Autowired
	private MessageProperties properties;

	@Test
	public void testGreetingEndpoint() {
		given()
				.baseUri(String.format("http://localhost:%d", port))
				.get(GREETING_PATH)
				.then()
				.statusCode(200)
				.body("content", is(String.format(properties.getMessage(), "Banana")));
	}

	@Test
	public void testGreetingEndpointWithNameParameter() {
		given()
				.baseUri(String.format("http://localhost:%d", port))
				.param("name", "John")
				.get(GREETING_PATH)
				.then()
				.statusCode(200)
				.body("content", is(String.format(properties.getMessage(), "John")));
	}

}

