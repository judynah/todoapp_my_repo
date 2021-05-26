package efs.task.todoapp.web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebServerFactory {
    public static HttpServer createServer() {
        try{
            final HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);

            server.createContext("/todo/task", new HttpHandler() {
                @Override
                public void handle(HttpExchange exchange) throws IOException {

                    try {
                        System.out.println("Method: " + exchange.getRequestMethod());
                        System.out.println("URI: " + exchange.getRequestURI());

                        final List<String> delayHeaderValues = exchange.getRequestHeaders().get("delay");
                        final Long delaySeconds = delayHeaderValues == null || delayHeaderValues.isEmpty() ? 0L : Long.valueOf(delayHeaderValues.get(0));
                        System.out.println("Delay: " + delaySeconds);

                        final String requestBody = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
                        System.out.println("Request Body: " + requestBody);

                        TimeUnit.SECONDS.sleep(delaySeconds);

                        final String responseText = new String("Rensponse Body: "+ requestBody);
                        final  byte[] responseTextBytes = responseText.getBytes(StandardCharsets.UTF_8);

                        exchange.getResponseHeaders().add("app-version", "1.0 (build: n/a");
                        exchange.sendResponseHeaders(200, responseTextBytes.length);
                        exchange.getResponseBody().write(responseTextBytes);
                        exchange.close();

                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
            return server;
        }catch(Exception e){
            throw new RuntimeException("Unable to start server ", e);

        }

    }
}
