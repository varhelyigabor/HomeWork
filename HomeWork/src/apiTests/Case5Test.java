package apiTests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Person;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Case5Test {

	final OkHttpClient client = new OkHttpClient();

	String run(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}
	}

	@Test
	public static void GetUsersTest() throws IOException {

		Logger logger = LoggerFactory.getLogger("logger");
		Case5Test test = new Case5Test();
		String response = test.run("https://jsonplaceholder.typicode.com/users");

		ObjectMapper om = new ObjectMapper();
		Person[] root = om.readValue(response, Person[].class);

		for (Person person : root) {
			logger.info("{} | {}", person.name, person.email);
		}
		assertTrue(root[0].email.contains("@"), "@ is expected in the email address");
	}
}
