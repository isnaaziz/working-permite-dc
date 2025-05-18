import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class GuestFormHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            // Display the form
            String response = FormUtils.getFormHtml();
            exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes(StandardCharsets.UTF_8));
            os.close();
        } else if ("POST".equals(exchange.getRequestMethod())) {
            // Handle form submission
            handleFormSubmission(exchange);
        }
    }

    private void handleFormSubmission(HttpExchange exchange) throws IOException {
        // Read the form data
        String formData = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);

        // Parse the form data
        String[] params = formData.split("&");
        String name = FormUtils.getValue(params, "name");
        String phoneNumber = FormUtils.getValue(params, "phoneNumber");
        String company = FormUtils.getValue(params, "company");
        String dataCenter = FormUtils.getValue(params, "dataCenter");
        String visitType = FormUtils.getValue(params, "visitType");
        String companion = FormUtils.getValue(params, "companion");

        // Display the summary
        String response = FormUtils.getSummaryHtml(name, phoneNumber, company, dataCenter, visitType, companion);
        exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes(StandardCharsets.UTF_8));
        os.close();
    }
}