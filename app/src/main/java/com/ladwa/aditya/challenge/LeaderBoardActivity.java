package com.ladwa.aditya.challenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.ladwa.aditya.challenge.data.model.LeaderBoard;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class LeaderBoardActivity extends AppCompatActivity {

    public static final String TAG = LeaderBoardActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<LeaderBoard> leaderBoards = getIntent().getParcelableArrayListExtra(getString(R.string.extra_list));

        for (LeaderBoard leader :
                leaderBoards) {
            Log.d(TAG, leader.getTeamName());
        }
    }

}
