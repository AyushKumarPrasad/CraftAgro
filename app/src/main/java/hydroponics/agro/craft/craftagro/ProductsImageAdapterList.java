package hydroponics.agro.craft.craftagro;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductsImageAdapterList extends RecyclerView.Adapter<ProductsImageAdapterList.BookViewHolder>
{
    private List<ProductsAdapterList> bookList;
    private Context mCtx;

    public ProductsImageAdapterList(Context mCtx, List<ProductsAdapterList> bookList) {
        this.mCtx = mCtx;
        this.bookList = bookList;

    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.products_layout_recycler_view, null);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position)
    {
        ProductsAdapterList product = bookList.get(position);

        holder.title.setText(bookList.get(position).getProductsname());
        holder.author.setText(bookList.get(position).getProductsdescription());

        holder.image.setImageDrawable(mCtx.getResources().getDrawable(product.getProductsimage()));
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView author;
        public ImageView image;

        public BookViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.products_name_list);
            author = (TextView) view.findViewById(R.id.product_description_list);
            image =(ImageView) view.findViewById(R.id.imageofproducts);
        }
    }
}
