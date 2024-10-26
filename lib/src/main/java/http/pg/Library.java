/*
 * This source file was generated by the Gradle 'init' task
 */
package http.pg;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;

import http.pg.models.EchoRequestBody;
import http.pg.models.EchoResponseBody;

public class Library {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public String getEcho(String message)
            throws RequestException, IOException, InterruptedException, URISyntaxException {
        String uri = "https://postman-echo.com/post";

        EchoRequestBody reqBody = new EchoRequestBody();
        reqBody.message = message;
        String reqJson = gson.toJson(reqBody);
        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(reqJson))
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        if (response.statusCode() < 200 || response.statusCode() > 299) {
            throw new RequestException(String.valueOf(response.statusCode()));
        }
        return gson.fromJson(response.body(), EchoResponseBody.class).data.message;
    }

}
