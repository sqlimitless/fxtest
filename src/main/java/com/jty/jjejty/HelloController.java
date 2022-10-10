package com.jty.jjejty;

import com.jty.jjejty.test.HttpConnectionService;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * 첫 화면하고 연결되어있는 클래스
 */
public class HelloController {

    /**
     * 데이터 통신하고 결과를 보여줄 텍스트영역 
     */
    @FXML
    public TextArea dataTextArea;

    /**
     * 버튼 눌렀을때 반응하는 함수
     */
    @FXML
    protected void onHttpURLConnection () throws Exception {
        /* 예제클래스 NEW 해서 만듬 */
        HttpConnectionService httpConnectionService = new HttpConnectionService();
        
        /* 예제클래스에 잇는 함수 호출 
        * 일딴 URL은 그냥 인터넷에 통신 테스트 할수있는 주소로 함*/
        String returnData = httpConnectionService.sendGet("https://reqres.in/api/users");
        
        /* 리턴 받은 값을 텍스트 영역에 뿌려줌 */
        dataTextArea.setText(returnData);
    }
}