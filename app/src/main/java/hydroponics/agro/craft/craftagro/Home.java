package hydroponics.agro.craft.craftagro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;


import java.util.Timer;
import java.util.TimerTask;

import br.com.bloder.magic.view.MagicButton;
import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    FloatingActionButton fab_plus, fab_twitter, fab_fb, fab_location, fab_whatsapp;
    Animation FabOpen, FabClose, FabRClockwise, FabRanticlockwise;
    boolean isopen = false;
    private ImageView facebook, instagram, facebook1 ;
    private Button mLogOutBtn, show ;
    private TextView t1, t2, timedate ;
    private CircleImageView circleImageView;
    private FirebaseAuth mAuth ;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference storeUserDefaultDataReference ;
    private ViewPager viewPager;
    private HomeImagesAdapter myadapter1;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private MagicButton magicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        TextView textView = (TextView) findViewById(R.id.marqueText);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);
        textView.setSingleLine();

        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_twitter = (FloatingActionButton) findViewById(R.id.fab_twitter);
        fab_fb = (FloatingActionButton) findViewById(R.id.fab_fb);
        fab_location = (FloatingActionButton) findViewById(R.id.fab_location);
        fab_whatsapp = (FloatingActionButton) findViewById(R.id.fab_whatsapp);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        magicButton = (MagicButton) findViewById(R.id.magicbuttonorder);
        magicButton.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (v == v)
                {
                    Intent ayush_kumar_developer_tripper = new Intent(Home.this,PlaceOrder.class);
                    startActivity(ayush_kumar_developer_tripper);
                }
                else

                {

                }

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView =  navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);
        t1 = (TextView) hView.findViewById(R.id.userkanaam);
        t2 = (TextView) hView.findViewById(R.id.userkaemail);

        //       imageView1 = (ImageView) hView.findViewById(R.id.userkaphoto);
        circleImageView = (CircleImageView) hView.findViewById(R.id.userkaphoto);

        t1.setText("" + user.getEmail());
        t2.setText(""  + user.getDisplayName());
        String img_url = user.getPhotoUrl().toString();
        Glide.with(this).load(img_url).into(circleImageView);

        mAuthListener = new FirebaseAuth.AuthStateListener()
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                if (firebaseAuth.getCurrentUser() == null)
                {
                    startActivity(new Intent(Home.this, Register.class));
                }
            }
        };

        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
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
                Toast.makeText(Home.this, "Hello",Toast.LENGTH_SHORT).show();
            }
        });

        Menu menu=navigationView.getMenu();
        MenuItem item = menu.findItem(R.id.switch_item);
        facebook = (ImageView) item.getActionView().findViewById(R.id.facebook_button);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, GetOrder.class);
                startActivity(intent);
            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewpager1);
        myadapter1 = new HomeImagesAdapter(this);
        viewPager.setAdapter(myadapter1);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 3500);
    }

    public class MyTimerTask extends TimerTask
    {
        @Override
        public void run()
        {
            Home.this.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    if (viewPager.getCurrentItem() == 0)
                    {
                        viewPager.setCurrentItem(1);
                    }
                    else if (viewPager.getCurrentItem() == 1)
                    {
                        viewPager.setCurrentItem(2);
                    }
                    else if (viewPager.getCurrentItem() == 2)
                    {
                        viewPager.setCurrentItem(3);
                    }
                    else if (viewPager.getCurrentItem() == 3)
                    {
                        viewPager.setCurrentItem(4);
                    }
                    else if (viewPager.getCurrentItem() == 4)
                    {
                        viewPager.setCurrentItem(5);
                    }
                    else if (viewPager.getCurrentItem() == 5)
                    {
                        viewPager.setCurrentItem(6);
                    }
                    else if (viewPager.getCurrentItem() == 6)
                    {
                        viewPager.setCurrentItem(7);
                    }
                    else if (viewPager.getCurrentItem() == 7)
                    {
                        viewPager.setCurrentItem(8);
                    }
                }
            });
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.about_us) {
            Intent intent = new Intent(Home.this,AboutUs.class);
            startActivity(intent);
        }
        else if (id == R.id.our_products)
        {
            Intent intent = new Intent(Home.this,OurProducts.class);
            startActivity(intent);
        }
        else if (id == R.id.hydroponics) {
            Intent intent = new Intent(Home.this,Hydroponics.class);
            startActivity(intent);
        }
        else if (id == R.id.our_website) {
            String url = "https://craftagro.com/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
        else if (id == R.id.previous_order)
        {
            Intent intent = new Intent(Home.this, GetOrder.class);
            startActivity(intent);
        }
        else if (id == R.id.intro)
        {
            Intent intent = new Intent(Home.this, ColorButton.class);
            startActivity(intent);

        }
        else if (id == R.id.shareapp) {
            String url = "https://play.google.com/store/apps/details?id=hydroponics.agro.craft.craftagro&rdid=hydroponics.agro.craft.craftagro";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }
        else if (id == R.id.credits) {

        }
        else if (id == R.id.logout) {
            mAuth.signOut();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

                                                /*

                                                {
                                                  "rules": {
                                                    ".read": "auth != null",
                                                    ".write": "auth != null"
                                                  }
                                                }

 */