package hydroponics.agro.craft.craftagro;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.text.SimpleDateFormat;

import de.hdodenhof.circleimageview.CircleImageView;

public class GetOrder extends AppCompatActivity
{
    private RecyclerView recyclerView ;
    private TextView t1, t2 ;
    private CircleImageView imageView;
    private ImageView newboy;
    private DatabaseReference allDatabaseUsersreference;
    FirebaseDatabase firebaseDatabase ;
    private FirebaseAuth mAuth;
    private LinearLayoutManager layoutManager;
    private FirebaseRecyclerAdapter<Database, ShowDataViewHolderayush> FirebaseAdapter;
    private LinearLayout duniya;
    TextView  timedate;

    public GetOrder()
    {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_order);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        t1 = (TextView) findViewById(R.id.nameemail);
        t2 = (TextView) findViewById(R.id.nameayush);
        imageView = (CircleImageView) findViewById(R.id.photo);
        newboy = (ImageView) findViewById(R.id.imagenewboy);

        newboy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ayush = new Intent(GetOrder.this , Home.class);
                startActivity(ayush);
            }
        });

        mAuth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance() ;
        final String user_id = mAuth.getCurrentUser().getUid();
        allDatabaseUsersreference = firebaseDatabase.getInstance().getReference("ORDER").child(user_id);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        setDataToView(user);

        recyclerView = (RecyclerView) findViewById(R.id.all_users_list);
        duniya = (LinearLayout) findViewById(R.id.showshot);
        recyclerView.setLayoutManager(new LinearLayoutManager(GetOrder.this));
        layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        timedate = (TextView) findViewById(R.id.textdatetimeewget_order);
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        timedate.setText(dateString);
    }



    @SuppressLint("SetTextI18n")
    private void setDataToView(FirebaseUser user ) {
        t1.setText("" + user.getEmail());
        t2.setText(""  + user.getDisplayName());
        String img_url = user.getPhotoUrl().toString();
        Glide.with(this).load(img_url).into(imageView);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        FirebaseAdapter = new FirebaseRecyclerAdapter<Database, ShowDataViewHolderayush>
                (Database.class, R.layout.retrievelayout, ShowDataViewHolderayush.
                        class,allDatabaseUsersreference)
        {
            @Override
            public void populateViewHolder(final ShowDataViewHolderayush viewHolder, final Database model,
                                           final int position)
            {
                viewHolder.Suscription(model.getOrder_Subscription());

                viewHolder.Bak_Quan(model.getOrder_BakChoy_Quantity());
                viewHolder.Bak_Reps(model.order_BakChoy_Cost);

                viewHolder.Spi_Quan(model.order_Spinach_Quantity);
                viewHolder.Spi_Reps(model.order_Spinach_Cost);

                viewHolder.Let_Quan(model.order_Lettuce_Quantity);
                viewHolder.Let_Reps(model.order_Lettuce_Cost);

                viewHolder.Marvl_Quan(model.order_Marvel_Quantity);
                viewHolder.Marvl_Reps(model.order_Marvel_Cost);

                viewHolder.Kal_Quan(model.order_Kale_Quantity);
                viewHolder.Kal_Reps(model.order_Kale_Cost);

                viewHolder.Must_Quan(model.order_Mustard_Quantity);
                viewHolder.Must_Reps(model.order_Mustard_Cost);

                viewHolder.Beet_Quan(model.order_Beet_Quantity);
                viewHolder.Beet_Reps(model.order_Beet_Cost);

                viewHolder.Swiss_Quan(model.order_Swiss_Quantity);
                viewHolder.Swiss_Reps(model.order_Swiss_Cost);

                viewHolder.Cabg_Quan(model.order_Cabbage_Quantity);
                viewHolder.Cabg_Reps(model.order_Cabbage_Cost);

                allDatabaseUsersreference.keepSynced(true);
                viewHolder.cancel.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(GetOrder.this);
                        builder.setMessage("Cancel Order").setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog , int which)
                                    {
                          //
                                        final String time = timedate.getText().toString();
                                        final String name = t1.getText().toString();
                                        final String email = t2.getText().toString();

                                        allDatabaseUsersreference = FirebaseDatabase.getInstance().getReference().child("ORDER")
                                                .child("Cancel").child("Details");

                                        allDatabaseUsersreference.child("Cancel_Time").setValue(time);
                                        allDatabaseUsersreference.child("Person_Name").setValue(email);
                                        allDatabaseUsersreference.child("Person_Email").setValue(name);

                                        int selectedItems = position;
                                        FirebaseAdapter.getRef(selectedItems).removeValue();
                                        FirebaseAdapter.notifyItemRemoved(selectedItems);
                                        recyclerView.invalidate();

                                        takeScreenshot(ScreenshotType.FULL);


                                        Toast.makeText(GetOrder.this,"Order Cancelled",
                                                Toast.LENGTH_LONG).show();

                                        finish();
                                    }
                                }).setNegativeButton("No", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                dialog.cancel();
                            }
                        });
                        AlertDialog dialog =  builder.create();
                        dialog.setTitle("Confirm");
                        dialog.show();
                    }
                });
            }
        };
        recyclerView.setAdapter(FirebaseAdapter);
    }

    public static class ShowDataViewHolderayush extends RecyclerView.ViewHolder
    {
        private final TextView sub, cancel;
        private final TextView bak1, bak2 ;
        private final TextView spi1, spi2 ;
        private final TextView let1, let2 ;
        private final TextView mar1, mar2 ;
        private final TextView kal1, kal2 ;
        private final TextView mus1, mus2 ;
        private final TextView bet1, bet2 ;
        private final TextView swi1, swi2 ;
        private final TextView cab1, cab2 ;
        private final RelativeLayout relativeLayout ;

    //    private final TextView orderCancel ;

        public ShowDataViewHolderayush(final View itemView)
        {
            super(itemView);

            sub = (TextView) itemView.findViewById(R.id.subscription);
            cancel = (TextView) itemView.findViewById(R.id.cancelorder);

            bak1 = (TextView) itemView.findViewById(R.id.bak1);
            bak2 = (TextView) itemView.findViewById(R.id.bak2);

            spi1 = (TextView) itemView.findViewById(R.id.spi1);
            spi2 = (TextView) itemView.findViewById(R.id.spi2);

            let1 = (TextView) itemView.findViewById(R.id.let1);
            let2 = (TextView) itemView.findViewById(R.id.let2);

            mar1 = (TextView) itemView.findViewById(R.id.marvel1);
            mar2 = (TextView) itemView.findViewById(R.id.marvel2);

            kal1 = (TextView) itemView.findViewById(R.id.kale1);
            kal2 = (TextView) itemView.findViewById(R.id.kale2);

            mus1 = (TextView) itemView.findViewById(R.id.must1);
            mus2 = (TextView) itemView.findViewById(R.id.must2);

            bet1 = (TextView) itemView.findViewById(R.id.beet1);
            bet2 = (TextView) itemView.findViewById(R.id.beet2);

            swi1 = (TextView) itemView.findViewById(R.id.swiss1);
            swi2 = (TextView) itemView.findViewById(R.id.swiss2);

            cab1 = (TextView) itemView.findViewById(R.id.cabg1);
            cab2 = (TextView) itemView.findViewById(R.id.cabg2);

    //        orderCancel = (TextView) itemView.findViewById(R.id.showcancelorder);

            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relateshowshotcancel);
        }

        private void Suscription(String title)
        {
            sub.setText(title);
        }
        private void Bak_Quan(String title)
        {
            bak1.setText(title);
        }

        private void Bak_Reps(String title)
        {
            bak2.setText(title);
        }

        private void Spi_Quan(String title)
        {
            spi1.setText(title);
        }
        private void Spi_Reps(String title)
        {
            spi2.setText(title);
        }

        private void Let_Quan(String title)
        {
            let1.setText(title);
        }

        private void Let_Reps(String title)
        {
            let2.setText(title);
        }

        private void Marvl_Quan(String title)
        {
            mar1.setText(title);
        }

        private void Marvl_Reps (String title)
        {
            mar2.setText(title);
        }

        private void Kal_Quan(String title)
        {
            kal1.setText(title);
        }

        private void Kal_Reps(String title)
        {
            kal2.setText(title);
        }

        private void Must_Quan(String title)
        {
            mus1.setText(title);
        }

        private void Must_Reps(String title)
        {
            mus2.setText(title);
        }

        private void Beet_Quan(String title)
        {
            bet1.setText(title);
        }

        private void Beet_Reps(String title)
        {
            bet2.setText(title);
        }

        private void Swiss_Quan(String title)
        {
            swi1.setText(title);
        }

        private void Swiss_Reps(String title)
        {
            swi2.setText(title);
        }

        private void Cabg_Quan(String title)
        {
            cab1.setText(title);
        }

        private void Cabg_Reps(String title)
        {
            cab2.setText(title);
        }
    }

    private void takeScreenshot(ScreenshotType screenshotType) {
        Bitmap b = null;
        switch (screenshotType) {
            case FULL:

                b = ScreenshotUtils.getScreenShot(duniya);
                break;
        }

        if (b != null)
        {
            File saveFile = ScreenshotUtils.getMainDirectoryName(this);
            File file = ScreenshotUtils.store(b, "screenshot" + screenshotType + ".jpg", saveFile);
            shareScreenshot(file);
        }
        else
            Toast.makeText(this, "Ayush", Toast.LENGTH_SHORT).show();
    }

    private void shareScreenshot(File file)
    {
        String toNumber = "+91 97697 12777 "; // contains spaces.
        toNumber = toNumber.replace("+", "").replace(" ", "");
        String toshare = "Cancel Order by Whatsapp : " ;
        Uri uri = Uri.fromFile(file);//Convert file path into Uri for sharing
        Intent sendIntent = new Intent("android.intent.action.MAIN");
        sendIntent.putExtra("jid", toNumber + "@s.whatsapp.net");
        sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
        sendIntent.putExtra(Intent.EXTRA_TEXT, toshare);
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setType("image/*");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }
}