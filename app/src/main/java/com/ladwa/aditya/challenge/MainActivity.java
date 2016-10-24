package com.ladwa.aditya.challenge;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.helpshift.support.Support;
import com.ladwa.aditya.challenge.data.RestEndpoint;
import com.ladwa.aditya.challenge.data.model.LeaderBoard;
import com.ladwa.aditya.challenge.data.model.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ArrayList<LeaderBoard> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_message:
                Support.showConversation(this);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.imageview_download)
    public void onClickImageView() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.downloading));
        progressDialog.show();
        new RestEndpoint().getMatch().subscribe(new Subscriber<Match>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, getString(R.string.complete));
                progressDialog.cancel();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, e.toString());

            }

            @Override
            public void onNext(Match match) {
                showNextActivity(match);
            }
        });

    }

    private void showNextActivity(Match match) {

        list = new ArrayList<>();

        LeaderBoard alpha = new LeaderBoard();
        alpha.setTeamName("Alpha");
        alpha.setPoints(match.getAlpha().getTeamPoint());
        alpha.setGoalDifference(match.getAlpha().getTeamGoalDiff());
        alpha.setWon(match.getAlpha().getWon());
        alpha.setLost(match.getAlpha().getLoss());
        alpha.setDrawn(match.getAlpha().getDraw());

        list.add(alpha);
        LeaderBoard bravo = new LeaderBoard();

        bravo.setTeamName("Bravo");
        bravo.setPoints(match.getBravo().getTeamPoint());
        bravo.setGoalDifference(match.getBravo().getTeamGoalDiff());
        bravo.setWon(match.getBravo().getWon());
        bravo.setLost(match.getBravo().getLoss());
        bravo.setDrawn(match.getBravo().getDraw());

        list.add(bravo);
        LeaderBoard charli = new LeaderBoard();

        charli.setTeamName("Charlie");
        charli.setPoints(match.getCharlie().getTeamPoint());
        charli.setGoalDifference(match.getCharlie().getTeamGoalDiff());
        charli.setWon(match.getCharlie().getWon());
        charli.setLost(match.getCharlie().getLoss());
        charli.setDrawn(match.getCharlie().getDraw());

        list.add(charli);
        LeaderBoard delta = new LeaderBoard();

        delta.setTeamName("Delta");
        delta.setPoints(match.getDelta().getTeamPoint());
        delta.setGoalDifference(match.getDelta().getTeamGoalDiff());
        delta.setWon(match.getDelta().getWon());
        delta.setLost(match.getDelta().getLoss());
        delta.setDrawn(match.getDelta().getDraw());

        list.add(delta);
        LeaderBoard echo = new LeaderBoard();

        echo.setTeamName("Echo");
        echo.setPoints(match.getEcho().getTeamPoint());
        echo.setGoalDifference(match.getEcho().getTeamGoalDiff());
        echo.setWon(match.getEcho().getWon());
        echo.setLost(match.getEcho().getLoss());
        echo.setDrawn(match.getEcho().getDraw());

        list.add(echo);

        Collections.sort(list, new LeaderBoardComparator());
        Collections.reverse(list);

        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.download_complete)
                .setMessage(R.string.dialog_message_complete)
                .setIcon(R.drawable.ic_check_circle_black_24dp)
                .show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.hide();
                Intent intent = new Intent(MainActivity.this, LeaderBoardActivity.class);
                intent.putParcelableArrayListExtra(getString(R.string.extra_list), list);
                startActivity(intent);
            }
        }, 2000);
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
