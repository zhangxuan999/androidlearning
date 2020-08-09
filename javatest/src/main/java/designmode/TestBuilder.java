package designmode;


/**
 * 1.build模式一般无参构造，，可以为一些参数设置默认值
 * 2.build的build方法，一般会new 一个product，以builder的参数来构造
 *
 * 可以避免product类创建多个构造函数，有疑问，我的product用一个无参构造，然后每个属性一个set方法不就好了？这样使用者不知道哪些属性是必传的。new product就以为对象创建完毕了
 * product 的构造函数是私有的，builder是静态内部类
 */

public class TestBuilder {
    public static void main(String[] args) {

        Product jocy = new Product.ProductBuilder().setData("1990-06-08").setId(1).setName("jocy").build();

        System.out.println(jocy.toString());

        Product build = new Product.ProductBuilder(jocy).build();
        System.out.println(build.toString());

        Product build1 = jocy.newBuilder().build();
        System.out.println(build1.toString());

    }
}

class Product{
    int id;
    String name;
    String Data;

    //无参构造
    private Product(){
        this(new ProductBuilder());
    }

//    以builder为参数的构造
    private Product(ProductBuilder productBuilder) {
        this.id = productBuilder.id;
        this.name = productBuilder.name;
        this.Data = productBuilder.Data;
    }

    //返回一个productbuilder，以当前对象的参数
    public ProductBuilder newBuilder(){
        return new ProductBuilder(this);
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }


    public String getData() {
        return Data;
    }

    @Override
    public String toString() {
        return "name:" + name + "data:" + Data +"id:"+id
                ;
    }

    static class ProductBuilder{

        //默认参数
        public ProductBuilder(){
            this.id = 0;
            this.Data = "default";
            this.name = "default";
        }

        //返回一个根据prodtct的构造
        public ProductBuilder(Product product){
            this.id = product.id;
            this.name = product.name;
            this.Data = product.Data;
        }

        public  ProductBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setData(String data) {
            Data = data;
            return this;
        }

        int id;
        String name;
        String Data;
        public Product build(){
            return new Product(this);
        }
    }
}

