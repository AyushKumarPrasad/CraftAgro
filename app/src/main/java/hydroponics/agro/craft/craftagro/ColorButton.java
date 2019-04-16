package hydroponics.agro.craft.craftagro;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ColorButton extends AppCompatActivity
{
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_button);

        mAuth = FirebaseAuth.getInstance();



        mRecyclerView = findViewById(R.id.recyclerviewdatabase);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("UPDATES").child("CRAFT");

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,R.layout.firebase_image_layout,ViewHolder.class,mRef
                ) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Model model, int position)
            {
                viewHolder.setDetails(getApplicationContext(),model.getTitle(), model.getDescription(),
                        model.getImage()  );
            }
        };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
