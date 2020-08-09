package designmode;


/**
 * 1.buildģʽһ���޲ι��죬������ΪһЩ��������Ĭ��ֵ
 * 2.build��build������һ���new һ��product����builder�Ĳ���������
 *
 * ���Ա���product�ഴ��������캯���������ʣ��ҵ�product��һ���޲ι��죬Ȼ��ÿ������һ��set�������ͺ��ˣ�����ʹ���߲�֪����Щ�����Ǳش��ġ�new product����Ϊ���󴴽������
 * product �Ĺ��캯����˽�еģ�builder�Ǿ�̬�ڲ���
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

    //�޲ι���
    private Product(){
        this(new ProductBuilder());
    }

//    ��builderΪ�����Ĺ���
    private Product(ProductBuilder productBuilder) {
        this.id = productBuilder.id;
        this.name = productBuilder.name;
        this.Data = productBuilder.Data;
    }

    //����һ��productbuilder���Ե�ǰ����Ĳ���
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

        //Ĭ�ϲ���
        public ProductBuilder(){
            this.id = 0;
            this.Data = "default";
            this.name = "default";
        }

        //����һ������prodtct�Ĺ���
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

