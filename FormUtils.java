public class FormUtils {
    public static String getFormHtml() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Guest Registration</title>
                    <link rel="stylesheet" href="/static/styles.css">
                </head>
                <body>
                    <div class="container">
                        <div class="logo">
                            <img src="/static/logo.png" alt="Company Logo">
                        </div>
                        <h1>Guest Registration Form</h1>
                        <form action="/submit" method="post">
                            <label for="name">Name:</label>
                            <input type="text" id="name" name="name" required>

                            <label for="phoneNumber">Phone Number:</label>
                            <input type="text" id="phoneNumber" name="phoneNumber" required>

                            <label for="company">Company:</label>
                            <input type="text" id="company" name="company" required>

                            <label for="dataCenter">Data Center:</label>
                            <select id="dataCenter" name="dataCenter">
                                <option value="Data Center 1">Data Center 1</option>
                                <option value="Data Center 2">Data Center 2</option>
                                <option value="Data Center 3">Data Center 3</option>
                            </select>

                            <label for="visitType">Visit Type:</label>
                            <select id="visitType" name="visitType">
                                <option value="Preventive Maintenance">Preventive Maintenance</option>
                                <option value="Assessment">Assessment</option>
                                <option value="Troubleshoot">Troubleshoot</option>
                                <option value="Cable Pulling">Cable Pulling</option>
                                <option value="Visit">Visit</option>
                            </select>

                            <label for="companion">Companion:</label>
                            <input type="text" id="companion" name="companion">

                            <button type="submit">Submit</button>
                        </form>
                    </div>
                </body>
                </html>
                """;
    }

    public static String getSummaryHtml(String name, String phoneNumber, String company, String dataCenter,
            String visitType, String companion) {
        return String.format("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Guest Summary</title>
                    <link rel="stylesheet" href="/static/styles.css">
                </head>
                <body>
                    <div class="container">
                        <div class="logo">
                            <img src="/static/logo.png" alt="Company Logo">
                        </div>
                        <h1>Guest Registration Summary</h1>
                        <p><strong>Name:</strong> %s</p>
                        <p><strong>Phone Number:</strong> %s</p>
                        <p><strong>Company:</strong> %s</p>
                        <p><strong>Data Center:</strong> %s</p>
                        <p><strong>Visit Type:</strong> %s</p>
                        <p><strong>Companion:</strong> %s</p>
                        <a href="/">Back to Form</a>
                    </div>
                </body>
                </html>
                """, name, phoneNumber, company, dataCenter, visitType, companion.isEmpty() ? "None" : companion);
    }

    public static String getValue(String[] params, String key) {
        for (String param : params) {
            String[] pair = param.split("=");
            if (pair[0].equals(key)) {
                return pair.length > 1 ? pair[1].replace("+", " ") : "";
            }
        }
        return "";
    }
}