package com.ladwa.aditya.challenge;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.ladwa.aditya.challenge.data.RestEndpoint;
import com.ladwa.aditya.challenge.data.model.Match;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.imageview_download)
    public void onClickImageView() {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Downloading");
        progressDialog.show();
        new RestEndpoint().getMatch().subscribe(new Subscriber<Match>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "OnComplete");
                progressDialog.cancel();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, e.toString());

            }

            @Override
            public void onNext(Match match) {
                Log.d(TAG, match.getAlpha().getMatch1());
            }
        });

    }
}
