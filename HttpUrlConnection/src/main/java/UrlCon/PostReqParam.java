package UrlCon;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostReqParam {

    public static void main(String[] args) {
        try {

            String teamName = "Devops";
            String teamLead = "hello";

            String apiURL = "http://localhost:8989/param?";



            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            // append as query string ---
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Accept", "application/json");


            con.setDoOutput(true);
            try (OutputStream os = con.getOutputStream()) {
                String param = "teamName=" +teamName+"&teamLead="+teamLead;
                byte[] input = param.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                System.out.println("coming to br");
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