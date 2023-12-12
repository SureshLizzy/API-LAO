package unirest.connection;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UnirestExample {

	private void getMethodExample() throws UnirestException {
		HttpResponse<JsonNode> asJson = Unirest.get("https://dummy.restapiexample.com/api/v1/employees").asJson();
		System.out.println("Response Code: " + asJson.getStatus());
		System.out.println("Response message: " + asJson.getStatusText());
		System.out.println("Response body: " + asJson.getBody());
	}

	private void postMethodExample() throws UnirestException {
		HttpResponse<JsonNode> asJson = Unirest.post("https://dummy.restapiexample.com/api/v1/create").body("{\"name\":\"Ronaldo\",\"salary\":\"1000000\",\"age\":\"33\"}").asJson();
		System.out.println("Response Code: " + asJson.getStatus());
		System.out.println("Response message: " + asJson.getStatusText());
		System.out.println("Response body: " + asJson.getBody());
	}
	
	private void putMethodExample() throws UnirestException {
		HttpResponse<JsonNode> asJson = Unirest.put("https://dummy.restapiexample.com/api/v1/update/6209").body("{\\\"name\\\":\\\"Christiano Ronaldo\\\",\\\"salary\\\":\\\"1000000\\\",\\\"age\\\":\\\"34\\\"}").asJson();
		System.out.println("Response Code: " + asJson.getStatus());
		System.out.println("Response message: " + asJson.getStatusText());
		System.out.println("Response body: " + asJson.getBody());
	}

	private void deleteMethodExample() throws UnirestException {
		HttpResponse<JsonNode> asJson = Unirest.delete("https://dummy.restapiexample.com/api/v1/delete/6209").asJson();
		System.out.println("Response Code: " + asJson.getStatus());
		System.out.println("Response message: " + asJson.getStatusText());
		System.out.println("Response body: " + asJson.getBody());
	}
	
	public static void main(String[] args) throws UnirestException {
		UnirestExample example = new UnirestExample();
//		example.getMethodExample();
//		example.postMethodExample();
//		example.putMethodExample();
		example.deleteMethodExample();
	}
}
