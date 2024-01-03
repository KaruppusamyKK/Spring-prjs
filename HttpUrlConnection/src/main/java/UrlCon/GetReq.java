package UrlCon;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetReq {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://rickandmortyapi.comss/api/character/10");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");
            int statusCode = con.getResponseCode();
            String statusMessage = con.getResponseMessage();
            System.out.println("Status Code: " + statusCode+" "+statusMessage);
                try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                String response = "";
                String res;
                while ((res = br.readLine()) != null) {
                    response += res.trim();
                }
                String test = response.toString();
                JSONObject jsonObject = new JSONObject(test);
                jsonObject.remove("origin");
                jsonObject.remove("location");
                jsonObject.remove("image");
                jsonObject.remove("episode");
                jsonObject.remove("url");
                String actualJson = jsonObject.toString(4);
                System.out.println("Response  :" + actualJson);

            }
            con.disconnect();

        }catch (Exception e) {
            System.out.println("Why exception  :"+e.getMessage());
            e.printStackTrace();
        }
    }
}
