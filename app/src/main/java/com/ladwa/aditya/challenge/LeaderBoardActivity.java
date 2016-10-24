package com.ladwa.aditya.challenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.ladwa.aditya.challenge.data.model.LeaderBoard;

import java.util.ArrayList;
import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaderBoardActivity extends AppCompatActivity {

    public static final String TAG = LeaderBoardActivity.class.getSimpleName();

    @BindView(R.id.recyclerview_leaderboard)
    RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private LeaderBoardAdapter leaderBoardAdapter;

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
            Log.d(TAG, String.valueOf(leader.getGoalDifference()));
        }

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        leaderBoardAdapter = new LeaderBoardAdapter(leaderBoards, this);
        recyclerView.setAdapter(leaderBoardAdapter);

    }

    public class LeaderBoardComparator implements Comparator<LeaderBoard> {

        @Override
        public int compare(LeaderBoard leaderBoard, LeaderBoard t1) {
            int v1 = leaderBoard.getPoints().compareTo(t1.getPoints());
            if (v1 == 0) {
                return leaderBoard.getGoalDifference().compareTo(t1.getGoalDifference());
            } else {
                return v1;
            }
        }
    }

}
