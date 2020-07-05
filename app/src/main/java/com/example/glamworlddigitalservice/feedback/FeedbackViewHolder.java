package com.example.glamworlddigitalservice.feedback;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glamworlddigitalservice.R;

public class FeedbackViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView textFeed;

    public FeedbackViewHolder(@NonNull View itemView) {
        super(itemView);

        textFeed = itemView.findViewById(R.id.description);





    }

    @Override
    public void onClick(View v) {

    }
}
