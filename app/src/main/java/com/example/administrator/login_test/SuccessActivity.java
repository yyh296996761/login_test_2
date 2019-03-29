package com.example.administrator.login_test;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

                import org.w3c.dom.Text;

public class SuccessActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        textView = (TextView) findViewById(R.id.showid);
        textView.setText("你的id是："+ApplicationData.getInstance().getUserInfo().getId());

    }
}
