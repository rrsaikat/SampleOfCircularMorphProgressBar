package rezwan.pstu.cse12.samples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import rezwan.pstu.cse12.view.CircularMorphLayout;

public class MainActivity extends AppCompatActivity {

    private CircularMorphLayout cmLayout;
    private TextView mStartButtonTxt;
    private ProgressBar pb;
    private Button btStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmLayout = (CircularMorphLayout)findViewById(R.id.cml_proceed_layout);
        pb =(ProgressBar)findViewById(R.id.progressBar);
        btStop =(Button)findViewById(R.id.btnStop);
        mStartButtonTxt = (TextView)findViewById(R.id.tv_proceed);
        mStartButtonTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cmLayout.setDuration(800);
                cmLayout.revealFrom(mStartButtonTxt.getWidth() / 2f,
                        mStartButtonTxt.getHeight() / 2f,
                        mStartButtonTxt.getWidth() / 2f,
                        mStartButtonTxt.getHeight() / 2f).setListener(
                        () -> {
                            mStartButtonTxt.setVisibility(View.GONE);
                            pb.setVisibility(View.VISIBLE);
                        }).start();

            }
        });

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartButtonTxt.setVisibility(View.VISIBLE);
                pb.setVisibility(View.INVISIBLE);
                cmLayout.reverse();
            }
        });
    }
}
