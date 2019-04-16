package hydroponics.agro.craft.craftagro;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlaceOrder extends AppCompatActivity
{
 //   FloatingActionButton fab_plus, fab_twitter, fab_fb, fab_location, fab_whatsapp;
 //   Animation FabOpen, FabClose, FabRClockwise, FabRanticlockwise;
 //   boolean isopen = false;
    private ImageView orderback;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference storeUserDefaultDataReference;
    CheckBox check1, check2, check3, check4, check5, check6, check7, check8, check9;
    Button button_Submit;
    EditText clientname, clientphone, clientaddress,
            quant1, quant2, quant3, quant4, quant5, quant6, quant7, quant8, quant9;
    TextView text_vegetable, text_price, text_quantity, text_payment, timedate;
    TextView cost1, cost2, cost3, cost4, cost5, cost6, cost7, cost8, cost9, total_price;
    TextView vegetable_price1, vegetable_price2, vegetable_price3, vegetable_price4, vegetable_price5, vegetable_price6,
            vegetable_price7, vegetable_price8, vegetable_price9;
    RelativeLayout relativeLayout;
    Spinner mySpinner;

    String[] Subscription = {"Select Subscription", "15     Days", "30     Days",
            "45     Days", "60     Days"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        mAuth = FirebaseAuth.getInstance();

//        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
//        fab_twitter = (FloatingActionButton) findViewById(R.id.fab_twitter);
//        fab_fb = (FloatingActionButton) findViewById(R.id.fab_fb);
//        fab_location = (FloatingActionButton) findViewById(R.id.fab_location);
//        fab_whatsapp = (FloatingActionButton) findViewById(R.id.fab_whatsapp);

        clientname = (EditText) findViewById(R.id.name);
        clientphone = (EditText) findViewById(R.id.phone);
        clientaddress = (EditText) findViewById(R.id.address);

        orderback = (ImageView) findViewById(R.id.back_button_place_order);
        orderback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent ayush = new Intent(PlaceOrder.this , Home.class);
                startActivity(ayush);
            }
        });

        quant1 = (EditText) findViewById(R.id.editText1);
        quant1.setFilters(new InputFilter[]{new InputFilterMinMax("1", "10")});
        quant1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String current = "";
                String input = quant1.getText().toString();
                if (!s.toString().equals(current)) {
                    int d = 100;
                    int e = Integer.parseInt(input);
                    int f = d * e;
                    cost1.setText(String.valueOf(f));
                } else {
                    cost1.setText(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        quant2 = (EditText) findViewById(R.id.editText2);
        quant2.setFilters(new InputFilter[]{new InputFilterMinMax("1", "10")});
        quant2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String current = "";
                String input = quant2.getText().toString();
                if (!s.toString().equals(current)) {
                    int d = 130;
                    int e = Integer.parseInt(input);
                    int f = d * e;
                    cost2.setText(String.valueOf(f));
                } else {
                    cost2.setText(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        quant3 = (EditText) findViewById(R.id.editText3);
        quant3.setFilters(new InputFilter[]{new InputFilterMinMax("1", "10")});
        quant3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String current = "";
                String input = quant3.getText().toString();
                if (!s.toString().equals(current)) {
                    int d = 120;
                    int e = Integer.parseInt(input);
                    int f = d * e;
                    cost3.setText(String.valueOf(f));
                } else {
                    cost3.setText(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

   //     int total_amount = c + f + i ;
   //     total.setText(String.valueOf(total_amount));

        quant4 = (EditText) findViewById(R.id.editText4);
        quant4.setFilters(new InputFilter[]{new InputFilterMinMax("1", "10")});
        quant4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String current = "";
                String input = quant4.getText().toString();
                if (!s.toString().equals(current)) {
                    int d = 120;
                    int e = Integer.parseInt(input);
                    int f = d * e;
                    cost4.setText(String.valueOf(f));
                } else {
                    cost4.setText(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        quant5 = (EditText) findViewById(R.id.editText5);
        quant5.setFilters(new InputFilter[]{new InputFilterMinMax("1", "10")});
        quant5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String current = "";
                String input = quant5.getText().toString();
                if (!s.toString().equals(current)) {
                    int d = 150;
                    int e = Integer.parseInt(input);
                    int f = d * e;
                    cost5.setText(String.valueOf(f));
                } else {
                    cost5.setText(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        quant6 = (EditText) findViewById(R.id.editText6);
        quant6.setFilters(new InputFilter[]{new InputFilterMinMax("1", "10")});
        quant6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String current = "";
                String input = quant6.getText().toString();
                if (!s.toString().equals(current)) {
                    int d = 160;
                    int e = Integer.parseInt(input);
                    int f = d * e;
                    cost6.setText(String.valueOf(f));
                } else {
                    cost6.setText(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        quant7 = (EditText) findViewById(R.id.editText7);
        quant7.setFilters(new InputFilter[]{new InputFilterMinMax("1", "10")});
        quant7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String current = "";
                String input = quant7.getText().toString();
                if (!s.toString().equals(current)) {
                    int d = 170;
                    int e = Integer.parseInt(input);
                    int f = d * e;
                    cost7.setText(String.valueOf(f));
                } else {
                    cost7.setText(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        quant8 = (EditText) findViewById(R.id.editText8);
        quant8.setFilters(new InputFilter[]{new InputFilterMinMax("1", "10")});
        quant8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String current = "";
                String input = quant8.getText().toString();
                if (!s.toString().equals(current)) {
                    int d = 180;
                    int e = Integer.parseInt(input);
                    int f = d * e;
                    cost8.setText(String.valueOf(f));
                } else {
                    cost8.setText(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        quant9 = (EditText) findViewById(R.id.editText9);
        quant9.setFilters(new InputFilter[]{new InputFilterMinMax("1", "10")});
        quant9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String current = "";
                String input = quant9.getText().toString();
                if (!s.toString().equals(current)) {
                    int d = 190;
                    int e = Integer.parseInt(input);
                    int f = d * e;
                    cost9.setText(String.valueOf(f));
                } else {
                    cost9.setText(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        cost1 = (TextView) findViewById(R.id.pricetext1);
        cost2 = (TextView) findViewById(R.id.pricetext2);
        cost3 = (TextView) findViewById(R.id.pricetext3);
        cost4 = (TextView) findViewById(R.id.pricetext4);
        cost5 = (TextView) findViewById(R.id.pricetext5);
        cost6 = (TextView) findViewById(R.id.pricetext6);
        cost7 = (TextView) findViewById(R.id.pricetext7);
        cost8 = (TextView) findViewById(R.id.pricetext8);
        cost9 = (TextView) findViewById(R.id.pricetext9);

        vegetable_price1 = (TextView) findViewById(R.id.price_bakchoy);
        vegetable_price2 = (TextView) findViewById(R.id.price_spinach);
        vegetable_price3 = (TextView) findViewById(R.id.price_lettucelollo);
        vegetable_price4 = (TextView) findViewById(R.id.price_lettucemarvel);
        vegetable_price5 = (TextView) findViewById(R.id.price_kale);
        vegetable_price6 = (TextView) findViewById(R.id.price_mustardgreens);
        vegetable_price7 = (TextView) findViewById(R.id.price_beetgreen);
        vegetable_price8 = (TextView) findViewById(R.id.price_swisschard);
        vegetable_price9 = (TextView) findViewById(R.id.price_chienesecabbage);

  /*    String one = cost1.getText().toString();
        String two = cost2.getText().toString();
        String three = cost3.getText().toString();
        String four = cost4.getText().toString();
        String five = cost5.getText().toString();
        String six = cost6.getText().toString();
        String seven = cost7.getText().toString();
        String eight = cost8.getText().toString();
        String nine = cost9.getText().toString();

        int bill1 = Integer.parseInt(one);
        int bill2 = Integer.parseInt(two);
        int bill3 = Integer.parseInt(three);
        int bill4 = Integer.parseInt(four);
        int bill5 = Integer.parseInt(five);
        int bill6 = Integer.parseInt(six);
        int bill7 = Integer.parseInt(seven);
        int bill8 = Integer.parseInt(eight);
        int bill9 = Integer.parseInt(nine);

        String total = one + two + three + four + five + six + seven + eight + nine ;
        total_price.setText(total);   */


        text_vegetable = (TextView) findViewById(R.id.textview_vegetable);
        text_price = (TextView) findViewById(R.id.textview_price);
        text_quantity = (TextView) findViewById(R.id.textview_quantity);
        text_payment = (TextView) findViewById(R.id.textview_payment);

        text_price.setVisibility(View.INVISIBLE);
        text_quantity.setVisibility(View.INVISIBLE);
        text_payment.setVisibility(View.INVISIBLE);

        quant1.setVisibility(View.INVISIBLE);
        cost1.setVisibility(View.INVISIBLE);
        vegetable_price1.setVisibility(View.INVISIBLE);

        quant2.setVisibility(View.INVISIBLE);
        cost2.setVisibility(View.INVISIBLE);
        vegetable_price2.setVisibility(View.INVISIBLE);

        quant3.setVisibility(View.INVISIBLE);
        cost3.setVisibility(View.INVISIBLE);
        vegetable_price3.setVisibility(View.INVISIBLE);

        quant4.setVisibility(View.INVISIBLE);
        cost4.setVisibility(View.INVISIBLE);
        vegetable_price4.setVisibility(View.INVISIBLE);

        quant5.setVisibility(View.INVISIBLE);
        cost5.setVisibility(View.INVISIBLE);
        vegetable_price5.setVisibility(View.INVISIBLE);

        quant6.setVisibility(View.INVISIBLE);
        cost6.setVisibility(View.INVISIBLE);
        vegetable_price6.setVisibility(View.INVISIBLE);

        quant7.setVisibility(View.INVISIBLE);
        cost7.setVisibility(View.INVISIBLE);
        vegetable_price7.setVisibility(View.INVISIBLE);

        quant8.setVisibility(View.INVISIBLE);
        cost8.setVisibility(View.INVISIBLE);
        vegetable_price8.setVisibility(View.INVISIBLE);

        quant9.setVisibility(View.INVISIBLE);
        cost9.setVisibility(View.INVISIBLE);
        vegetable_price9.setVisibility(View.INVISIBLE);

        timedate = (TextView) findViewById(R.id.textdatetimeew);
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        timedate.setText(dateString);

        button_Submit = (Button) findViewById(R.id.submit_order_button);

        orderback = (ImageView) findViewById(R.id.back_button_place_order);

        mySpinner = (Spinner) findViewById(R.id.spinner_vegetable_list);
        mySpinner.setAdapter(new MyCustomAdapter(PlaceOrder.this, R.layout.row, Subscription));

/*        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_antoclockwise);
        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isopen) {
                    fab_fb.startAnimation(FabClose);
                    fab_whatsapp.startAnimation(FabClose);
                    fab_twitter.startAnimation(FabClose);
                    fab_location.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRanticlockwise);
                    fab_twitter.setClickable(false);
                    fab_fb.setClickable(false);
                    isopen = false;
                } else {
                    fab_fb.startAnimation(FabOpen);
                    fab_twitter.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabOpen);
                    fab_location.startAnimation(FabOpen);
                    fab_whatsapp.startAnimation(FabOpen);
                    fab_location.setClickable(true);
                    fab_twitter.setClickable(true);
                    fab_fb.setClickable(true);
                    fab_whatsapp.setClickable(true);
                    isopen = true;
                }
            }
        });

        fab_whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlaceOrder.this, "Hello",Toast.LENGTH_SHORT).show();
            }
        });    */

        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout_placeorder);
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    startActivity(new Intent(PlaceOrder.this, Register.class));
                }
            }
        };

        check1 = (CheckBox) findViewById(R.id.check1);
        check1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (check1.isChecked())
                {
                    quant1.setVisibility(View.VISIBLE);
                    cost1.setVisibility(View.VISIBLE);
                    vegetable_price1.setVisibility(View.VISIBLE);

                    text_price.setVisibility(View.VISIBLE);
                    text_quantity.setVisibility(View.VISIBLE);
                    text_payment.setVisibility(View.VISIBLE);
                }
                else
                    {
                    quant1.setVisibility(View.INVISIBLE);
                    cost1.setVisibility(View.INVISIBLE);
                    vegetable_price1.setVisibility(View.INVISIBLE);
                    quant1.setText("");
                }
            }
        });
        check2 = (CheckBox) findViewById(R.id.check2);
        check2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (check2.isChecked())
                {
                    quant2.setVisibility(View.VISIBLE);
                    cost2.setVisibility(View.VISIBLE);
                    vegetable_price2.setVisibility(View.VISIBLE);

                    text_price.setVisibility(View.VISIBLE);
                    text_quantity.setVisibility(View.VISIBLE);
                    text_payment.setVisibility(View.VISIBLE);
                }
                else
                    {
                    quant2.setVisibility(View.INVISIBLE);
                    cost2.setVisibility(View.INVISIBLE);
                    vegetable_price2.setVisibility(View.INVISIBLE);
                    quant2.setText("");
                }
            }
        });
        check3 = (CheckBox) findViewById(R.id.check3);
        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check3.isChecked()) {
                    quant3.setVisibility(View.VISIBLE);
                    cost3.setVisibility(View.VISIBLE);
                    vegetable_price3.setVisibility(View.VISIBLE);

                    text_price.setVisibility(View.VISIBLE);
                    text_quantity.setVisibility(View.VISIBLE);
                    text_payment.setVisibility(View.VISIBLE);
                } else {
                    quant3.setVisibility(View.INVISIBLE);
                    cost3.setVisibility(View.INVISIBLE);
                    vegetable_price3.setVisibility(View.INVISIBLE);
                    quant3.setText("");
                }
            }
        });
        check4 = (CheckBox) findViewById(R.id.check4);
        check4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (check4.isChecked())
                {
                    quant4.setVisibility(View.VISIBLE);
                    cost4.setVisibility(View.VISIBLE);
                    vegetable_price4.setVisibility(View.VISIBLE);

                    text_price.setVisibility(View.VISIBLE);
                    text_quantity.setVisibility(View.VISIBLE);
                    text_payment.setVisibility(View.VISIBLE);
                }
                else
                    {
                    quant4.setVisibility(View.INVISIBLE);
                    cost4.setVisibility(View.INVISIBLE);
                    vegetable_price4.setVisibility(View.INVISIBLE);
                    quant4.setText("");
                }
            }
        });
        check5 = (CheckBox) findViewById(R.id.check5);
        check5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check5.isChecked()) {
                    quant5.setVisibility(View.VISIBLE);
                    cost5.setVisibility(View.VISIBLE);
                    vegetable_price5.setVisibility(View.VISIBLE);

                    text_price.setVisibility(View.VISIBLE);
                    text_quantity.setVisibility(View.VISIBLE);
                    text_payment.setVisibility(View.VISIBLE);
                } else {
                    quant5.setVisibility(View.INVISIBLE);
                    cost5.setVisibility(View.INVISIBLE);
                    vegetable_price5.setVisibility(View.INVISIBLE);
                    quant5.setText("");
                }
            }
        });
        check6 = (CheckBox) findViewById(R.id.check6);
        check6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check6.isChecked()) {
                    quant6.setVisibility(View.VISIBLE);
                    cost6.setVisibility(View.VISIBLE);
                    vegetable_price6.setVisibility(View.VISIBLE);

                    text_price.setVisibility(View.VISIBLE);
                    text_quantity.setVisibility(View.VISIBLE);
                    text_payment.setVisibility(View.VISIBLE);
                } else {
                    quant6.setVisibility(View.INVISIBLE);
                    cost6.setVisibility(View.INVISIBLE);
                    vegetable_price6.setVisibility(View.INVISIBLE);
                    quant6.setText("");
                }
            }
        });
        check7 = (CheckBox) findViewById(R.id.check7);
        check7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check7.isChecked()) {
                    quant7.setVisibility(View.VISIBLE);
                    cost7.setVisibility(View.VISIBLE);
                    vegetable_price7.setVisibility(View.VISIBLE);

                    text_price.setVisibility(View.VISIBLE);
                    text_quantity.setVisibility(View.VISIBLE);
                    text_payment.setVisibility(View.VISIBLE);
                } else {
                    quant7.setVisibility(View.INVISIBLE);
                    cost7.setVisibility(View.INVISIBLE);
                    vegetable_price7.setVisibility(View.INVISIBLE);
                    quant7.setText("");
                }
            }
        });
        check8 = (CheckBox) findViewById(R.id.check8);
        check8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check8.isChecked()) {
                    quant8.setVisibility(View.VISIBLE);
                    cost8.setVisibility(View.VISIBLE);
                    vegetable_price8.setVisibility(View.VISIBLE);

                    text_price.setVisibility(View.VISIBLE);
                    text_quantity.setVisibility(View.VISIBLE);
                    text_payment.setVisibility(View.VISIBLE);
                } else {
                    quant8.setVisibility(View.INVISIBLE);
                    cost8.setVisibility(View.INVISIBLE);
                    vegetable_price8.setVisibility(View.INVISIBLE);
                    quant8.setText("");
                }
            }
        });
        check9 = (CheckBox) findViewById(R.id.check9);
        check9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check9.isChecked()) {
                    quant9.setVisibility(View.VISIBLE);
                    cost9.setVisibility(View.VISIBLE);
                    vegetable_price9.setVisibility(View.VISIBLE);

                    text_price.setVisibility(View.VISIBLE);
                    text_quantity.setVisibility(View.VISIBLE);
                    text_payment.setVisibility(View.VISIBLE);
                } else {
                    quant9.setVisibility(View.INVISIBLE);
                    cost9.setVisibility(View.INVISIBLE);
                    vegetable_price9.setVisibility(View.INVISIBLE);
                    quant9.setText("");
                }
            }
        });

        button_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = clientname.getText().toString();
                final String phone = clientphone.getText().toString();
                final String address = clientaddress.getText().toString().toLowerCase();
                String pattern = "^[789]\\d{9}$";
                final String descrip = mySpinner.getSelectedItem().toString();
                final String bakchoy1 = quant1.getText().toString();
                final String bakchoy2 = cost1.getText().toString();
                final String spinach1 = quant2.getText().toString();
                final String spinach2 = cost2.getText().toString();
                final String lettuce_lollo_rosso1 = quant3.getText().toString();
                final String lettuce_lollo_rosso2 = cost3.getText().toString();
                final String lettuce_marvel_of_four_seasons1 = quant4.getText().toString();
                final String lettuce_marvel_of_four_seasons2 = cost4.getText().toString();
                final String kale1 = quant5.getText().toString();
                final String kale2 = cost5.getText().toString();
                final String mustard_green1 = quant6.getText().toString();
                final String mustard_green2 = cost6.getText().toString();
                final String beet_green1 = quant7.getText().toString();
                final String beet_green2 = cost7.getText().toString();
                final String swiss_Chard1 = quant8.getText().toString();
                final String swiss_Chard2 = cost8.getText().toString();
                final String chienese_cabbage1 = quant9.getText().toString();
                final String chienese_cabbage2 = cost9.getText().toString();

                final String time = timedate.getText().toString();

                SendData(name, phone, address, descrip, bakchoy1, bakchoy2, spinach1, spinach2, lettuce_lollo_rosso1
                        , lettuce_lollo_rosso2, lettuce_marvel_of_four_seasons1, lettuce_marvel_of_four_seasons2,
                        kale1, kale2, mustard_green1, mustard_green2, beet_green1, beet_green2, swiss_Chard1,
                        swiss_Chard2, chienese_cabbage1, chienese_cabbage2, time);

            }
        });


    }

    private void SendData(final String name, final String phone, final String address, final String descrip,
                          final String bakchoy1,
                          final String bakchoy2, final String spinach1, final String spinach2, final
                          String lettuce_lollo_rosso1,
                          final String lettuce_lollo_rosso2, final String lettuce_marvel_of_four_seasons1,
                          final String lettuce_marvel_of_four_seasons2,
                          final String kale1, final String kale2, final String mustard_green1,
                          final String mustard_green2, final String beet_green1,
                          final String beet_green2, final String swiss_Chard1, final String swiss_Chard2,
                          final String chienese_cabbage1,
                          final String chienese_cabbage2, final String time) {

        String pattern = "^[789]\\d{9}$";

        if (TextUtils.isEmpty(name))
        {
            Snackbar snackbar = Snackbar.make(relativeLayout,
                    "Enter name",
                    Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                            // "Correc", Snackbar.LENGTH_SHORT);
                            //     snackbar1.show();
                        }
                    }).setActionTextColor(Color.WHITE);
            snackbar.show();

            View snackView = snackbar.getView();
            TextView textView = snackView.findViewById(android.support.design.
                    R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);

            return;
        }

        if (TextUtils.isEmpty(phone))
        {

            Snackbar snackbar = Snackbar.make(relativeLayout,
                    "Enter Phone Number",
                    Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                            // "Correc", Snackbar.LENGTH_SHORT);
                            //     snackbar1.show();
                        }
                    }).setActionTextColor(Color.WHITE);
            snackbar.show();

            View snackView = snackbar.getView();
            TextView textView = snackView.findViewById(android.support.design.
                    R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);

            return;


        } else {
            if (phone.matches(pattern)) {

            } else {
                Snackbar snackbar = Snackbar.make(relativeLayout,
                        "Enter Valid Number",
                        Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                // "Correc", Snackbar.LENGTH_SHORT);
                                //     snackbar1.show();
                            }
                        }).setActionTextColor(Color.WHITE);
                snackbar.show();

                View snackView = snackbar.getView();
                TextView textView = snackView.findViewById(android.support.design.
                        R.id.snackbar_text);
                textView.setTextColor(Color.WHITE);

                return;
            }
        }

        if (TextUtils.isEmpty(address))
        {
            Snackbar snackbar = Snackbar.make(relativeLayout,
                    "Select Address",
                    Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                            // "Correc", Snackbar.LENGTH_SHORT);
                            //     snackbar1.show();
                        }
                    }).setActionTextColor(Color.WHITE);
            snackbar.show();

            View snackView = snackbar.getView();
            TextView textView = snackView.findViewById(android.support.design.
                    R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);

            return;


        }
        else
            {
            if (address.contains("kharghar"))
            {
                //Show it is inside box 1
            }
            else
                {
                    Snackbar snackbar = Snackbar.make(relativeLayout,
                            "Only Kharghar Navi Mumbai Residents 410210",
                            Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                            new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                    // "Correc", Snackbar.LENGTH_SHORT);
                                    //     snackbar1.show();
                                }
                            }).setActionTextColor(Color.WHITE);
                    snackbar.show();

                    View snackView = snackbar.getView();
                    TextView textView = snackView.findViewById(android.support.design.
                            R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);
                return;
            }
        }

        int pos = mySpinner.getSelectedItemPosition();
        if (pos != 0) {

        } else
            {
                Snackbar snackbar = Snackbar.make(relativeLayout,
                        "Select Subscription",
                        Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                // "Correc", Snackbar.LENGTH_SHORT);
                                //     snackbar1.show();
                            }
                        }).setActionTextColor(Color.WHITE);
                snackbar.show();

                View snackView = snackbar.getView();
                TextView textView = snackView.findViewById(android.support.design.
                        R.id.snackbar_text);
                textView.setTextColor(Color.WHITE);

                return;


        }
        if (!descrip.equals("Select Subscription")) {

        } else {
            Snackbar snackbar = Snackbar.make(relativeLayout,
                    "Select Subscription",
                    Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                            // "Correc", Snackbar.LENGTH_SHORT);
                            //     snackbar1.show();
                        }
                    }).setActionTextColor(Color.WHITE);
            snackbar.show();

            View snackView = snackbar.getView();
            TextView textView = snackView.findViewById(android.support.design.
                    R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);

            return;
        }

        if (check1.isChecked() || check2.isChecked() || check3.isChecked() || check4.isChecked()
                || check5.isChecked()
                || check6.isChecked() || check7.isChecked() || check8.isChecked() || check9.isChecked()) {
            if (check1.isChecked())
            {
                if (TextUtils.isEmpty(bakchoy1))
                {
                    Snackbar snackbar = Snackbar.make(relativeLayout,
                            "Enter Quantity for BAK CHOY",
                            Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                            new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                    // "Correc", Snackbar.LENGTH_SHORT);
                                    //     snackbar1.show();
                                }
                            }).setActionTextColor(Color.WHITE);
                    snackbar.show();

                    View snackView = snackbar.getView();
                    TextView textView = snackView.findViewById(android.support.design.
                            R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);

                    return;


                }
                else
                    {
                }

            }

            if (check2.isChecked())
            {

                if (TextUtils.isEmpty(spinach1))
                {
                    Snackbar snackbar = Snackbar.make(relativeLayout,
                            "Enter Quantity for SPINACH",
                            Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                            new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                    // "Correc", Snackbar.LENGTH_SHORT);
                                    //     snackbar1.show();
                                }
                            }).setActionTextColor(Color.WHITE);
                    snackbar.show();

                    View snackView = snackbar.getView();
                    TextView textView = snackView.findViewById(android.support.design.
                            R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);

                    return;


                } else {

                }

            }
            if (check3.isChecked()) {



                if (TextUtils.isEmpty(lettuce_lollo_rosso1))
                {
                    Snackbar snackbar = Snackbar.make(relativeLayout,
                            "Enter Quantity for LETTUCE LOLLO ROSSO",
                            Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                            new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                    // "Correc", Snackbar.LENGTH_SHORT);
                                    //     snackbar1.show();
                                }
                            }).setActionTextColor(Color.WHITE);
                    snackbar.show();

                    View snackView = snackbar.getView();
                    TextView textView = snackView.findViewById(android.support.design.
                            R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);


                    return;
                } else {

                }

            }

            if (check4.isChecked()) {



                if (TextUtils.isEmpty(lettuce_marvel_of_four_seasons1)) {

                    Snackbar snackbar = Snackbar.make(relativeLayout,
                            "Enter Quantity for LETTUCE MARVEL OF FOUR SEASONS",
                            Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                            new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                    // "Correc", Snackbar.LENGTH_SHORT);
                                    //     snackbar1.show();
                                }
                            }).setActionTextColor(Color.WHITE);
                    snackbar.show();

                    View snackView = snackbar.getView();
                    TextView textView = snackView.findViewById(android.support.design.
                            R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);


                    return;
                } else {

                }

            }

            if (check5.isChecked()) {



                if (TextUtils.isEmpty(kale1)) {
                    Snackbar snackbar = Snackbar.make(relativeLayout,
                            "Enter Quantity for KALE",
                            Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                            new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                    // "Correc", Snackbar.LENGTH_SHORT);
                                    //     snackbar1.show();
                                }
                            }).setActionTextColor(Color.WHITE);
                    snackbar.show();

                    View snackView = snackbar.getView();
                    TextView textView = snackView.findViewById(android.support.design.
                            R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);


                    return;
                } else {

                }

            }

            if (check6.isChecked()) {



                if (TextUtils.isEmpty(mustard_green1)) {
                    Snackbar snackbar = Snackbar.make(relativeLayout,
                            "Enter Quantity for MUSTARD GREEN",
                            Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                            new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                    // "Correc", Snackbar.LENGTH_SHORT);
                                    //     snackbar1.show();
                                }
                            }).setActionTextColor(Color.WHITE);
                    snackbar.show();

                    View snackView = snackbar.getView();
                    TextView textView = snackView.findViewById(android.support.design.
                            R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);


                    return;
                } else {

                }

            }

            if (check7.isChecked()) {



                if (TextUtils.isEmpty(beet_green1)) {
                    Snackbar snackbar = Snackbar.make(relativeLayout,
                            "Enter Quantity for BEET GREEN",
                            Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                            new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                    // "Correc", Snackbar.LENGTH_SHORT);
                                    //     snackbar1.show();
                                }
                            }).setActionTextColor(Color.WHITE);
                    snackbar.show();

                    View snackView = snackbar.getView();
                    TextView textView = snackView.findViewById(android.support.design.
                            R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);


                    return;
                } else {

                }

            }

            if (check8.isChecked()) {



                if (TextUtils.isEmpty(swiss_Chard1)) {
                    Snackbar snackbar = Snackbar.make(relativeLayout,
                            "Enter Quantity for SWISS CHARD",
                            Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                            new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                    // "Correc", Snackbar.LENGTH_SHORT);
                                    //     snackbar1.show();
                                }
                            }).setActionTextColor(Color.WHITE);
                    snackbar.show();

                    View snackView = snackbar.getView();
                    TextView textView = snackView.findViewById(android.support.design.
                            R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);


                    return;
                } else {

                }

            }

            if (check9.isChecked()) {


                if (TextUtils.isEmpty(chienese_cabbage1)) {
                    Snackbar snackbar = Snackbar.make(relativeLayout,
                            "Enter Quantity for CHIENESE CABBAGE",
                            Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                            new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View v)
                                {
                                    //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                    // "Correc", Snackbar.LENGTH_SHORT);
                                    //     snackbar1.show();
                                }
                            }).setActionTextColor(Color.WHITE);
                    snackbar.show();

                    View snackView = snackbar.getView();
                    TextView textView = snackView.findViewById(android.support.design.
                            R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);


                    return;
                } else {

                }

            }
        } else
            {

                Snackbar snackbar = Snackbar.make(relativeLayout,
                        "Select Vegetables Before Order",
                        Snackbar.LENGTH_INDEFINITE).setAction("Ok",
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                //     Snackbar snackbar1 = Snackbar.make(relativeLayout,
                                // "Correc", Snackbar.LENGTH_SHORT);
                                //     snackbar1.show();
                            }
                        }).setActionTextColor(Color.WHITE);
                snackbar.show();

                View snackView = snackbar.getView();
                TextView textView = snackView.findViewById(android.support.design.
                        R.id.snackbar_text);
                textView.setTextColor(Color.WHITE);

                return;
        }


        AlertDialog.Builder a_builder = new AlertDialog.Builder(PlaceOrder.this);
        a_builder.setMessage("Confirm Order")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String current_user_Id = mAuth.getCurrentUser().getUid();
                        storeUserDefaultDataReference = FirebaseDatabase.getInstance().getReference().child("ORDER")
                                .child(current_user_Id).push();
                        storeUserDefaultDataReference.child("order_Name").setValue(name);
                        storeUserDefaultDataReference.child("order_Phone").setValue(phone);
                        storeUserDefaultDataReference.child("order_Address").setValue(address);
                        storeUserDefaultDataReference.child("order_Subscription").setValue(descrip);
                        storeUserDefaultDataReference.child("order_BakChoy_Quantity").setValue(bakchoy1);
                        storeUserDefaultDataReference.child("order_BakChoy_Cost").setValue(bakchoy2);
                        storeUserDefaultDataReference.child("order_Spinach_Quantity").setValue(spinach1);
                        storeUserDefaultDataReference.child("order_Spinach_Cost").setValue(spinach2);
                        storeUserDefaultDataReference.child("order_Lettuce_Quantity")
                                .setValue(lettuce_lollo_rosso1);
                        storeUserDefaultDataReference.child("order_Lettuce_Cost")
                                .setValue(lettuce_lollo_rosso2);
                        storeUserDefaultDataReference.child("order_Marvel_Quantity")
                                .setValue(lettuce_marvel_of_four_seasons1);
                        storeUserDefaultDataReference.child("order_Marvel_Cost")
                                .setValue(lettuce_marvel_of_four_seasons2);
                        storeUserDefaultDataReference.child("order_Kale_Quantity").setValue(kale1);
                        storeUserDefaultDataReference.child("order_Kale_Cost").setValue(kale2);
                        storeUserDefaultDataReference.child("order_Mustard_Quantity")
                                .setValue(mustard_green1);
                        storeUserDefaultDataReference.child("order_Mustard_Cost").setValue(mustard_green2);
                        storeUserDefaultDataReference.child("order_Beet_Quantity").setValue(beet_green1);
                        storeUserDefaultDataReference.child("order_Beet_Cost").setValue(beet_green2);
                        storeUserDefaultDataReference.child("order_Swiss_Quantity").setValue(swiss_Chard1);
                        storeUserDefaultDataReference.child("order_Swiss_Cost").setValue(swiss_Chard2);
                        storeUserDefaultDataReference.child("order_Cabbage_Quantity")
                                .setValue(chienese_cabbage1);
                        storeUserDefaultDataReference.child("order_Cabbage_Cost").setValue(chienese_cabbage2);

                        storeUserDefaultDataReference.child("order_Time").setValue(time)
                                .addOnCompleteListener(new OnCompleteListener<Void>()
                                {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task)
                                    {
                                        if (task.isSuccessful())
                                        {
                                            try
                                            {
                                                Intent intent = new Intent(PlaceOrder.this,
                                                        PlaceOrder.class);
                                                startActivity(intent);

                                                String toNumber = "+91 97697 12777 ";
                                                toNumber = toNumber.replace("+", "")
                                                        .replace(" ", "");
                                                String toshare = "Send Order by Whatsapp :-" + "Name:" + name + "__"
                                                        + "" +
                                                        " Phone:"
                                                        + phone + "__" + "Address:" + "__" + address + "__" +
                                                        "Subscription:" +
                                                        descrip + "__" + "BAKCHOY :" + bakchoy1 + "__" + bakchoy2 +
                                                        "SPINACH :"
                                                        + spinach1 + "__" + spinach2 + "__" + "LETTUCE LOLLO ROSSO" +
                                                        lettuce_lollo_rosso1 + "__" + lettuce_lollo_rosso2 + "__"
                                                        + "LETTUCE MARVEL :" + lettuce_marvel_of_four_seasons1 + "__"
                                                        + lettuce_marvel_of_four_seasons2 + "__" + "KALE :" + kale1
                                                        + "__" + kale2 + "__" + "MUSTARD GREEN :" + mustard_green1
                                                        + "__" + mustard_green2 + "__" + "BEET GREEN :" + beet_green1
                                                        + "__" + beet_green2 + "__" + "SWISS CHARD" + swiss_Chard1
                                                        + "__" + swiss_Chard2 + "__" + "CHIENESE CABBAGE" +
                                                        "__" + chienese_cabbage1 + "__" + chienese_cabbage2;

                                                Intent sendIntent = new Intent("android.intent.action.MAIN");
                                                sendIntent.putExtra("jid", toNumber + "@s.whatsapp.net");
                                                sendIntent.putExtra(Intent.EXTRA_TEXT, toshare);
                                                sendIntent.setAction(Intent.ACTION_SEND);
                                                sendIntent.setPackage("com.whatsapp");
                                                sendIntent.setType("text/plain");
                                                startActivity(sendIntent);
                                            }
                                            catch (Exception e)
                                            {
                                                e.printStackTrace();
                                            }
                                        }
                                        else
                                            {
                                            Toast.makeText(PlaceOrder.this, "Error Occured Try Again..",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        dialog.cancel();
                        Intent intent = new Intent(PlaceOrder.this, PlaceOrder.class);
                        startActivity(intent);
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.setTitle("Alert !!!");
        alert.show();

        clientname.setText("");
        clientphone.setText("");
        clientaddress.setText("");
        mySpinner.setAdapter(null);
        quant1.setText("");
        quant2.setText("");
        quant3.setText("");
        quant4.setText("");
        quant5.setText("");
        quant6.setText("");
        quant7.setText("");
        quant8.setText("");
        quant9.setText("");

        check1.clearFocus();
        check2.clearFocus();
        check3.clearFocus();
        check4.clearFocus();
        check5.clearFocus();
        check6.clearFocus();
        check7.clearFocus();
        check8.clearFocus();
        check9.clearFocus();
    }
    public class MyCustomAdapter extends ArrayAdapter<String>
    {

        public MyCustomAdapter(Context context, int textViewResourceId,
                               String[] objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.row, parent, false);
            TextView label = (TextView) row.findViewById(R.id.weekofday);
            label.setText(Subscription[position]);

            if (position == 0) {
                label.setTextColor(Color.WHITE);
            }
            return row;
        }
    }
}

