package read.it.ratioimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RatioImageView iv_image1;
    private RatioImageView iv_image2;
    private RatioImageView ll_img1;
    private RatioImageView ll_img2;
    private RatioImageView ll_img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        init();
    }

    private void findId() {
        iv_image1 = findViewById(R.id.iv_image1);
        iv_image2 = findViewById(R.id.iv_image2);
        ll_img1 = findViewById(R.id.ll_img1);
        ll_img2 = findViewById(R.id.ll_img2);
        ll_img3 = findViewById(R.id.ll_img3);
    }

    private void init() {
        iv_image1.setRatio(0.7f); //高宽比0.7
        iv_image2.setRatio(0.7f);
        ll_img1.setRatio(0.7f);
        ll_img2.setRatio(0.7f);
        ll_img3.setRatio(0.7f);
    }
}
