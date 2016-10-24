package com.ladwa.aditya.challenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ladwa.aditya.challenge.data.model.LeaderBoard;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aditya on 24-Oct-16.
 */

public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.ViewHolder> {

    private ArrayList<LeaderBoard> mLeaderBoardArrayList;
    private Context mContext;
    private LeaderBoard leaderBoard;

    public LeaderBoardAdapter(ArrayList<LeaderBoard> mLeaderBoardArrayList, Context mContext) {
        this.mLeaderBoardArrayList = mLeaderBoardArrayList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view_leaderboard, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        leaderBoard = mLeaderBoardArrayList.get(position);

        holder.teamName.setText("Team " + (position + 1) + " " + leaderBoard.getTeamName());
        holder.played.setText("Played: " + leaderBoard.getPlayed());
        holder.won.setText(new StringBuilder().append("Won: ").append(leaderBoard.getWon()).toString());
        holder.loss.setText("Loss: " + leaderBoard.getLost());
        holder.drawn.setText("Drawn: " + leaderBoard.getDrawn());
        holder.goalDifference.setText("Goal Difference: " + leaderBoard.getGoalDifference());


    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (mLeaderBoardArrayList == null)
            return 0;
        else return mLeaderBoardArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.teamNameTv)
        TextView teamName;
        @BindView(R.id.playedTv)
        TextView played;

        @BindView(R.id.wonTv)
        TextView won;

        @BindView(R.id.lossTv)
        TextView loss;

        @BindView(R.id.drawnTv)
        TextView drawn;

        @BindView(R.id.goalDifference)
        TextView goalDifference;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
