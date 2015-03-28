package com.rnlwjd0613.todaychicken;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    String[] datas = {"네네치킨","굽네치킨","비비큐"};

    // 액티비티가 실행 될때 최초로 불리는 함수
    // 대체적으로 액티비티의 각종 요소들을 초기화 하는 작업을 진행
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 이 액티비티의 메인 뷰를 res-->layout-->activity_main.xml 로 지정
        setContentView(R.layout.activity_main);

        // 버튼의 인스턴스를 layout 에서 가져옴
        View button = findViewById(R.id.button);

        // 버튼에 클릭 이벤트 리스너를 설정
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼이 눌렸을 때 실행된다

                // 텍스트필드(EditText) 에 문자열을 가져온다
                EditText editText = (EditText) findViewById(R.id.editText);

                // 문자열의 해시코드를 구한다.
                String nameString = editText.getText().toString();
                int hashCode = nameString.hashCode();

                // 데이터에 매핑을 위해 나머지 연산을 사용한다.
                int index = hashCode % datas.length;

                // 결과값에 절대값을 구한다.
                index = Math.abs(index);

                // 결과값을 인덱스로 하는 데이터를 화면에 보여준다.
                Toast.makeText(getApplicationContext(), datas[index], Toast.LENGTH_SHORT).show();
                
            }
        });
    }
}
