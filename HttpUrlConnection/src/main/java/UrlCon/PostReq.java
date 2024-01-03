package UrlCon;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostReq {

    public static void main(String[] args) {
        try {
//            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            URL url = new URL("http://localhost:8989/test");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // properties
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            //for output - send data
            con.setDoOutput(true);
            String jsonInputString = "{\"teamName\": \"TN\", \"teamLead\": \"vignesh\"}";
            // write into  - write into resources
            try (OutputStream os = con.getOutputStream()) {
                // string into bytes
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // byte into strin
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                String response = "";
                String res;
                while ((res = br.readLine()) != null) {
                    response += res.trim();
                }
                String test=response.toString();
                JSONObject jsonObject=new JSONObject(test);
                String actualJson=jsonObject.toString(4);
                System.out.println("Response from server: " + actualJson);
            }


                con.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
