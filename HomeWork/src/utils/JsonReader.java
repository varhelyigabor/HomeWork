package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import models.Credentials;

public class JsonReader {

	public static Credentials getCredentialsJackson() {

		ObjectMapper objectMapper = new ObjectMapper();

		Credentials credentials;
		try {
			credentials = objectMapper.readValue(new File("test/resources/credential_jackson.json"), Credentials.class);
			return credentials;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public static Credentials getCredentials() {

		try (Reader reader = new FileReader("test/resources/credential.json")) {
			Gson gson = new Gson();
			Credentials c = gson.fromJson(reader, Credentials.class);

			return c;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
