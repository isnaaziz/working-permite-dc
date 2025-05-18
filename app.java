import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {
        // Create an HTTP server on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Define the handler for the root path
        server.createContext("/", new GuestFormHandler());

        // Serve static CSS files
        server.createContext("/static", new StaticFileHandler());

        // Start the server
        server.setExecutor(null);
        System.out.println("Server is running on http://localhost:8080");
        server.start();
    }
}