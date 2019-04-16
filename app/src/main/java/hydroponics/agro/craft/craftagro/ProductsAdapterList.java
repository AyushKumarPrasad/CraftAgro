package hydroponics.agro.craft.craftagro;

public class ProductsAdapterList
{
    private int id;
    private String productsname ;
    private String productsdescription;
    private int productsimage ;

    public ProductsAdapterList(int id, String productsname, String productsdescription, int productsimage) {
        this.id = id;
        this.productsname = productsname;
        this.productsdescription = productsdescription;
        this.productsimage = productsimage;
    }

    public int getId() {
        return id;
    }

    public String getProductsname() {
        return productsname;
    }

    public String getProductsdescription() {
        return productsdescription;
    }

    public int getProductsimage() {
        return productsimage;
    }

}
