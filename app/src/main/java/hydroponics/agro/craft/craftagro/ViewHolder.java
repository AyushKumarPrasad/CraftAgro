package hydroponics.agro.craft.craftagro;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder
{
    View mView;

    public ViewHolder(View itemView)
    {
        super(itemView);

        mView = itemView ;
    }

    public void setDetails(Context ctx, String title, String description, String image)
    {
        TextView mTitleTv = mView.findViewById(R.id.rTitleTv);
        TextView mDetailTv = mView.findViewById(R.id.rDescriptionTv);
        ImageView mImageIv = mView.findViewById(R.id.rImageView);

        mTitleTv.setText(title);
        mDetailTv.setText(description);
        Picasso.get().load(image).into(mImageIv);
    }
}
