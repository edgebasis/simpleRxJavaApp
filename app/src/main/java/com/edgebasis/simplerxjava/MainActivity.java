package com.edgebasis.simplerxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

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
                testObservableInterval();
            }
        });
    }

    private void testObservableInterval() {
        rx.Observable.interval(2, TimeUnit.SECONDS).subscribe(new Subscriber<Long>() {


            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {
                if(aLong==5)
                    unsubscribe();
                Log.i("onNext interv", String.valueOf(aLong));
            }
        });

    }

    private void testObservableJust() {
        rx.Observable.just(1,2,3,4,5,6,7,8,9,10).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i("onNext Just", String.valueOf(integer));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void testObservableFrom() {
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
