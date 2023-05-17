package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Router implements HttpHandler {
	private Map<String, HttpHandler> routes;

	public Router() {
		this.routes = new HashMap<>();
	}

	public void addRoute(String path, HttpHandler handler) {
		routes.put(path, handler);
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		String requestPath = exchange.getRequestURI().getPath();
		HttpHandler handler = routes.get(requestPath);

		if (handler != null) {
			handler.handle(exchange);
		} else {
			// 处理未知路径的逻辑，如返回 404 Not Found
			String response = "Not Found";
			exchange.sendResponseHeaders(404, response.getBytes().length);

			OutputStream outputStream = exchange.getResponseBody();
			outputStream.write(response.getBytes());
			outputStream.close();
		}
	}
}