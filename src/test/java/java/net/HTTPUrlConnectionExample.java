package java.net;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

//Check how the HTTP method work through automation

public class HTTPUrlConnectionExample {

	private void gETmethodExample() throws IOException {

		// 1. Create url class and pass url
		URL url = new URL("https://dummy.restapiexample.com/api/v1/employee/1");

		// 2. open the url connection
		URLConnection openConnection = url.openConnection();

		// 3. store in the parent class
		HttpURLConnection connection = (HttpURLConnection) openConnection;

		// 4. set the request type
		connection.setRequestMethod("GET");

		// 5. connect
		connection.connect();

		// 6.Get the status code form the connection object and print
		int responseCode = connection.getResponseCode();
		System.out.println("The GET method response code is:" + responseCode);

		// 7. Get response message and print
		String responseMessage = connection.getResponseMessage();
		System.out.println("GET method Response meaasge: " + responseMessage);

		// 8. create input stream reader for reading the response body
		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReaderreader = new InputStreamReader(inputStream);

		// 9. create a buffered reader and pass the input stream reader
		BufferedReader bufferedReader = new BufferedReader(inputStreamReaderreader);

		// 10. Read the line using read line method and create String buffer and Loop
		// the read line action as long as the lines are available in the respone
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		while ((line=bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
		}
		System.out.println(stringBuffer);
		System.out.println("---------------------------");
	}

	private void pOSTMethodExample() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/create");
		URLConnection openConnection = url.openConnection();
		HttpURLConnection connection = (HttpURLConnection) openConnection;
		connection.setRequestMethod("POST");

		// Set request property(Content-type = application/json) and setdooutput is true
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);

		// form the post body
		String jsonBody = "{\"name\":\"Rohit\",\"salary\":\"1500000\",\"age\":\"33\"}";
		byte[] inputJson = jsonBody.getBytes();

		// write this post body to output stream
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(inputJson);

		System.out.println("The response code for POST method: " + connection.getResponseCode());
		System.out.println("response message: " + connection.getResponseMessage());

		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReaderreader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReaderreader);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
		}
		System.out.println(stringBuffer);
		System.out.println("---------------------------");
	}

	private void pUTRequestExample() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/update/469");
		URLConnection openConnection = url.openConnection();
		HttpURLConnection connection = (HttpURLConnection) openConnection;
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		String jsonBody = "{\"name\":\"Rohit Sharma\",\"salary\":\"1500000\",\"age\":\"35\"}";
		byte[] inputJson = jsonBody.getBytes();
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(inputJson);
		System.out.println("PUT response code: " + connection.getResponseCode());
		System.out.println("PUT response message: " + connection.getResponseMessage());
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
	
	
	
	private void dELETEMethodExample() throws IOException {
		URL url = new URL("https://dummy.restapiexample.com/api/v1/delete/6547");
		URLConnection openConnection = url.openConnection();
		HttpURLConnection connection =(HttpURLConnection)openConnection;
		connection.setRequestMethod("DELETE");
		System.out.println("Response code: "+connection.getResponseCode());
		System.out.println("Response Message: "+connection.getResponseMessage());
		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line;
		StringBuffer buffer = new StringBuffer();
		while ((line=bufferedReader.readLine())!=null) {
			buffer.append(line);			
		}
		System.out.println("Respone Body: ");
	System.out.println(buffer);
	
	}

	public static void main(String[] args) throws IOException {
		HTTPUrlConnectionExample example = new HTTPUrlConnectionExample();
//		example.gETmethodExample();
//		example.pOSTMethodExample();
//		example.pUTRequestExample();
		example.dELETEMethodExample();
	}
}
