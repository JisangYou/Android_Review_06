package orgs.androidtown.sampleintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int CODE_NUMBER = 10000;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, CODE_NUMBER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE_NUMBER) {
            Toast.makeText(getApplicationContext(), "onActivityResult 메소드 호출됨. 요청 코드 : " + requestCode + ", 결과코드 : " + resultCode, Toast.LENGTH_SHORT).show();

            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
//                String name = data.getExtras().getString("name"); // 두개의 차이?
                Toast.makeText(getApplicationContext(), "응답으로 전달된 name : "+name, Toast.LENGTH_LONG).show();
            }

        }
    }
}

























