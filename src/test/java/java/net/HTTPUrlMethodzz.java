package java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HTTPUrlMethodzz {

	private void getMethod() throws IOException {
		// 1. Url class ku object creation
		URL url = new URL("https://dummy.restapiexample.com/api/v1/employees");

		// 2. connect and store in parent
		URLConnection openConnection = url.openConnection(); // child
		HttpURLConnection connection = (HttpURLConnection) openConnection; // upcasting - child to parent

		// 3. set request type
		connection.setRequestMethod("GET");

		// 4. connect
		connection.connect();

		// 5. get response code
		int responseCode = connection.getResponseCode();
		System.out.println("Response code: " + responseCode);

		// 6. Get the response msg
		String responseMessage = connection.getResponseMessage();
		System.out.println("Response message: " + responseMessage);

		// 7. Response body - Inputstream class
		InputStream inputStream = connection.getInputStream();

		// 8. to read inputstream we need inputstream reader
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		// 9. To read from input stream reader we need buffer reader
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String line;
		StringBuffer buffer = new StringBuffer();
		while ((line = bufferedReader.readLine()) != null) {
			buffer.append(line);
		}
		System.out.println(buffer);
	}

	// Post
	private void postMethodExample() throws IOException {

		URL url = new URL("https://dummy.restapiexample.com/api/v1/create");
		URLConnection openConnection = url.openConnection();
		HttpURLConnection connection = (HttpURLConnection) openConnection;
		connection.setRequestMethod("POST");

		// Set request property (Content-Type as key and application/json as value)
		connection.setRequestProperty("Content-Type", "application/json");

		// mark setdooutput as true
		connection.setDoOutput(true);

		// body
		String jsonBody = "{\"name\":\"Messi\",\"salary\":\"100000\",\"age\":\"38\"}";
		byte[] bytes = jsonBody.getBytes();

		// write in output stream
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(bytes);

		int responseCode = connection.getResponseCode();
		System.out.println(responseCode);

		String responseMessage = connection.getResponseMessage();
		System.out.println(responseMessage);

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String line;
		StringBuffer buffer = new StringBuffer();

		while ((line = bufferedReader.readLine()) != null) {
			buffer.append(line);
		}
		System.out.println(buffer);
	}

	// PUT
	private void putMethodExample() throws IOException {
		URL url = new URL("	https://dummy.restapiexample.com/api/v1/update/677");
		URLConnection openConnection = url.openConnection();
		HttpURLConnection connection = (HttpURLConnection) openConnection;
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);

		String jsonBody = "{\"name\":\"Lionel Messi\",\"salary\":\"2000000\",\"age\":\"39\"}";
		byte[] bytes = jsonBody.getBytes();

		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(bytes);

		System.out.println(connection.getResponseCode());
		System.out.println(connection.getResponseMessage());

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String line;
		StringBuffer buffer = new StringBuffer();
		while ((line = bufferedReader.readLine()) != null) {
			buffer.append(line);
		}
		System.out.println(buffer);

	}

	private void deleteMethodExamp() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/delete/677");
		URLConnection openConnection = url.openConnection();
		HttpURLConnection connection = (HttpURLConnection) openConnection;
		connection.setRequestMethod("DELETE");
		System.out.println(connection.getResponseCode());
		System.out.println(connection.getResponseMessage());

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line;

		StringBuffer buffer = new StringBuffer();

		while ((line = bufferedReader.readLine()) != null) {
			buffer.append(line);

		}
		System.out.println(buffer);

	}

	public static void main(String[] args) throws IOException {
		HTTPUrlMethodzz httpUrlMethodzz = new HTTPUrlMethodzz();
		// httpUrlMethodzz.getMethod();
		// httpUrlMethodzz.postMethodExample();
		// httpUrlMethodzz.putMethodExample();
		httpUrlMethodzz.deleteMethodExamp();
	}
}
