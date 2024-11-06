//package org.Pokedex;
//
//import com.google.gson.Gson;
//
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws MalformedURLException {
//        //definindo a conexão como nula
//        HttpURLConnection connection = null;
//        String line;
//        try {
//            URL url = new URL("https://pokeapi.co/api/v2/pokemon/ditto");
//            //Resposta a da API
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Accept", "application/json");
//
//            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//
//                InputStream inputStream = connection.getInputStream();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//                StringBuilder jsonText = new StringBuilder();
//
//
//                while ((line = reader.readLine()) != null) {
//                    jsonText.append(line);
//                }
//                reader.close();
//
//                System.out.println(jsonText.toString());
//
//            } else {
//                System.out.println(connection.getResponseCode());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            connection.disconnect();
//        }
//
//        Gson gson = new Gson();
//
//        String json = gson.fromJson(, ApiPokedex.class);
//
//
//
//
//    }
//}