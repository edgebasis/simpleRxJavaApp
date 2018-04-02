package com.edgebasis.simplerxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Observable;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    Button btnRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRun = (Button)findViewById(R.id.btnRun);


        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testObservable();
            }
        });
    }

    private void testObservable() {
        rx.Observable.from(new Integer[]{1,2,3}).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.e("onNext obser", String.valueOf(integer));
            }
        });
    }
}
