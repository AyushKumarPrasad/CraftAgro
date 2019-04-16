package hydroponics.agro.craft.craftagro;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeImagesAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.mipmap.c,
            R.mipmap.f,
            R.mipmap.e,
            R.mipmap.b,
            R.mipmap.a,
            R.mipmap.g,
            R.mipmap.d ,
            R.mipmap.h
    };

    public HomeImagesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.home_images_slide,null);

        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout1);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg1);
        imgslide.setImageResource(lst_images[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        ViewPager vp = (ViewPager) container ;
        View view = (View) object;
        vp.removeView(view);

    }
}