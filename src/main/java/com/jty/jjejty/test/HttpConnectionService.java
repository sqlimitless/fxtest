package com.jty.jjejty.test;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * 아까 보내줬던 예제코드
 * https://118k.tistory.com/225
 */
public class HttpConnectionService {
    private final String USER_AGENT = "Mozilla/5.0";

    /**
     * 예제 파일인데 사실상 이 함수를 너가 받은 예제 (getTestApi함수같은거)를 여기에 맞춰서 넣어주면 됨
     * 이거 내용은 URL보내기전에 정보 셋팅해주고 호출하면 필요한 데이터를 받아올수있음
     * 그럼 받아와서 StringBuffer response 에다가 받아온 데이터를 저장하고 리턴해줌
     * 
     * 너는 여기에 회사에서 받은 예제처럼 토큰받아오고 인증받아오고 하는 부분이 더 있어서 받아온예제가 이거보다 긴거임
     */
    public String sendGet(String targetUrl) throws Exception {
        URL url = new URL(targetUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // print result
        System.out.println("HTTP 응답 코드 : " + responseCode);
        System.out.println("HTTP body : " + response.toString());
        return response.toString();
    }

    public String sendPost(String targetUrl, String parameters) throws Exception {
        URL url = new URL(targetUrl);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("POST"); // HTTP POST 메소드 설정
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setDoOutput(true); // POST 파라미터 전달을 위한 설정
        // Send post request
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(parameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // print result
        System.out.println("HTTP 응답 코드 : " + responseCode);
        System.out.println("HTTP body : " + response.toString());
        return response.toString();
    }
}
