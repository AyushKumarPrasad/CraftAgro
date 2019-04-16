package hydroponics.agro.craft.craftagro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutUs extends AppCompatActivity
{
    private ImageView newboy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        newboy = (ImageView) findViewById(R.id.imagenewboyaboutus);

        newboy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ayush = new Intent(AboutUs.this , Home.class);
                startActivity(ayush);
            }
        });
    }
}
