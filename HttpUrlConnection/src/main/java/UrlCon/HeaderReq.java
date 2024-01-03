package UrlCon;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class HeaderReq {

    public static void main(String[] args) {
        try {
            String teamName = "teamNameHeader";
            String teamLead = "teamLeadHeader";

            String apiURL = "http://localhost:8989/header";

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("teamName", teamName); // http metadata
            con.setRequestProperty("teamLead", teamLead);

            con.setDoOutput(true);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                JSONObject jsonObject = new JSONObject(response.toString());
                String actualJson = jsonObject.toString(4);
                System.out.println("Response from server: " + actualJson);
            }

            con.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
