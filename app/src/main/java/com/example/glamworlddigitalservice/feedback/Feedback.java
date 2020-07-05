package com.example.glamworlddigitalservice.feedback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.glamworlddigitalservice.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Feedback extends AppCompatActivity {

   //upload data

    EditText comment;
    Button send;

    String userComment;

    //retrive data

    RecyclerView recyclerView;
    FirebaseRecyclerAdapter<FeedbackModel, FeedbackViewHolder> recyclerAdapter;


    FirebaseDatabase database;
    DatabaseReference myRef;
    RecyclerView.LayoutManager layoutManager;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Customer Feedback");


        //Firebase init
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Customer Feedback");

        recyclerView = (RecyclerView)findViewById(R.id.listOfFeedback);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


       // upload data

        comment = findViewById(R.id.feed);
        send = findViewById(R.id.send);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

                loadData();


            }
        });

        loadData();





    }

    private void saveData() {

        userComment = comment.getText().toString();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(userComment.isEmpty())
                {
                    comment.setError("Please firstly give your feedback");
                    comment.requestFocus();

                }
                else
                {
                    FeedbackModel feedbackModel = new FeedbackModel(userComment);
                    myRef.child(FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber().toString()).setValue(feedbackModel);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }

    private void loadData(){

        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<FeedbackModel>()
                        .setQuery(myRef,FeedbackModel.class)
                        .build();

        recyclerAdapter = new FirebaseRecyclerAdapter<FeedbackModel, FeedbackViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FeedbackViewHolder holder, int position, @NonNull FeedbackModel model) {

                holder.textFeed.setText(model.getFeedback());


            }

            @NonNull
            @Override
            public FeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.feedback_item_view,viewGroup,false);
                return new FeedbackViewHolder(view);
            }
        };
        recyclerAdapter.notifyDataSetChanged();
        recyclerAdapter.startListening();
        recyclerView.setAdapter(recyclerAdapter);






    }

}