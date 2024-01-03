package UrlCon;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PathVariable {

    public static void main(String[] args) {
        try {

            Long Id= 29L;
            URL url = new URL("http://localhost:8989/path/"+Id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");


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
