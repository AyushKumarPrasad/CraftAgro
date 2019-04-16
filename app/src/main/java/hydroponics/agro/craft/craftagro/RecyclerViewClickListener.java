package hydroponics.agro.craft.craftagro;

import android.view.View;

/**
 * Created by ayushkumar on 05/05/18.
 */

public interface RecyclerViewClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}