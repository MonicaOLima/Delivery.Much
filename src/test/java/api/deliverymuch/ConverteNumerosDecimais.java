package api.deliverymuch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConverteNumerosDecimais {
	
	Response response;
	
	@Test
	public void statusCodeDezMil() {
		response = RestAssured.get("http://challengeqa.staging.devmuch.io/10000");
		int code = 200;
		int codeRetornado = response.getStatusCode();
		assertEquals(code, codeRetornado);
	}
	@Test
	public void bodyDezMil() {
		response = RestAssured.get("http://challengeqa.staging.devmuch.io/10000");
		String body = "{\"extenso\": \"dez mil\"}";
		String bodyRetornado = response.asString();
		assertTrue(body.equalsIgnoreCase(bodyRetornado));
}
	@Test
	public void statusCodeMenosDezMil() {
		response = RestAssured.get("http://challengeqa.staging.devmuch.io/-10000");
		assertEquals(200, response.getStatusCode());
}		
	@Test
	public void bodyMenosDezMil() {
		response = RestAssured.get("http://challengeqa.staging.devmuch.io/-10000");
		String body = "{\"extenso\": \"menos dez mil\"}";
		String bodyRetornado = response.asString();
		assertTrue(body.equalsIgnoreCase(bodyRetornado));
}
	@Test
	public void statusCodeDezMilEUm() {
		response = RestAssured.get("http://challengeqa.staging.devmuch.io/10001");
		int code = 400;
		int codeRetornado = response.getStatusCode();
		assertEquals(code, codeRetornado);
	}
	@Test
	public void bodyDezMilEUm() {
		response = RestAssured.get("http://challengeqa.staging.devmuch.io/10001");
		String body = "{\"extenso\": \"Invalid data\"}";
		String bodyRetornado = response.asString();
		assertTrue(body.equalsIgnoreCase(bodyRetornado));
}
	@Test
	public void statusCodeMenosDezMilEUm() {
		response = RestAssured.get("http://challengeqa.staging.devmuch.io/-10001");
		int code = 400;
		int codeRetornado = response.getStatusCode();
		assertEquals(code, codeRetornado);
	}
	@Test
	public void bodyMenosDezMilEUm() {
		response = RestAssured.get("http://challengeqa.staging.devmuch.io/-10001");
		String body = "{\"extenso\": \"Invalid data\"}";
		String bodyRetornado = response.asString();
		assertTrue(body.equalsIgnoreCase(bodyRetornado));
}
	@Test
	public void bodyDadosEmBranco() {
		response = RestAssured.get("http://challengeqa.staging.devmuch.io/");
		String body = "DM - QA Challenge :)";
		String bodyRetornado = response.asString();
		assertTrue(body.equalsIgnoreCase(bodyRetornado));
	}
}
