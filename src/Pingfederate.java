import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Pingfederate {
    public Pingfederate() {

    }
    public void run() throws IOException {
        System.out.println("Version 2.2.0");
        String host = System.getenv("HOST");
        String port = System.getenv("PORT");
        URL url = new URL(String.format("%s", host));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Custom-Header", "Nginx");
        System.out.println("Request headers:=====================");
        Map<String, List<String>> requestHeaders = con.getRequestProperties();
        for (Map.Entry<String, java.util.List<String>> entry : requestHeaders.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        System.out.println("Response headers:=====================");
        Map<String, List<String>> responseHeaders = con.getHeaderFields();
        for (Map.Entry<String, java.util.List<String>> entry : responseHeaders.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println(content.toString());
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Pingfederate pingfederate = new Pingfederate();
        while (true) {
            pingfederate.run();
            Thread.sleep(120000);
        }
    }
}
