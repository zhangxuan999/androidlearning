package javaproject;

public class TestEnum {
    public static void main(String[] args) {
        Season season = Season.AUTOMU;
        ;
        System.out.println("season.name() = " + season.name());//AUTOMU
        System.out.println("season.ordinal() = " + season.ordinal());//2
        //枚举本质是类，有两个默认属性name和ordinal。一个是String ，一个是int
        //定义的各个枚举相当于静态变量
        //有两个静态方法，values和valueof，valueof方法可根据name，string类型得到相应的枚举实例
        //values方法返回所有的枚举实例

        Season season1 = Season.valueOf("SPRING");  //传入SPRING 可以得到枚举实例
        System.out.println("season1.name() = " + season1.name());


        Size size = Size.fromDes("S");//传入S,可以得到枚举实例
        System.out.println("size.name() = " + size.name());
        System.out.println("size.toString() = " + size.toString());
    }
}

enum Size {
    /**
     *
     */
    SMALL("S", "小号"),
    MIDDLE("M", "中号"),
    LARGE("L", "大号");

    public String getDes() {
        return des;
    }

    public String getTitle() {
        return title;
    }

    private final String des;
    private final String title;

    Size(String des, String title) {
        this.des = des;
        this.title = title;
    }

    /**
     * 静态方法可以根据传入的des，得到相应的枚举实例
     *
     * @param des
     * @return
     */
    public static Size fromDes(String des) {
        for (Size size : Size.values()) {
            if (size.getDes().equals(des)) {
                return size;
            }
        }
        return null;
    }


}

enum Season {
    /**
     *
     */
    SPRING(3),
    SUMMER(6),
    AUTOMU(9),
    WINTER(12);

    private final int key;


    Season(int k) {
        this.key = k;
    }


    @Override
    public String toString() {
        return super.toString();
    }


}
