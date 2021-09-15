package javaproject;

public class TestEnum {
    public static void main(String[] args) {
        Season season = Season.AUTOMU;
        ;
        System.out.println("season.name() = " + season.name());//AUTOMU
        System.out.println("season.ordinal() = " + season.ordinal());//2
        //ö�ٱ������࣬������Ĭ������name��ordinal��һ����String ��һ����int
        //����ĸ���ö���൱�ھ�̬����
        //��������̬������values��valueof��valueof�����ɸ���name��string���͵õ���Ӧ��ö��ʵ��
        //values�����������е�ö��ʵ��

        Season season1 = Season.valueOf("SPRING");  //����SPRING ���Եõ�ö��ʵ��
        System.out.println("season1.name() = " + season1.name());


        Size size = Size.fromDes("S");//����S,���Եõ�ö��ʵ��
        System.out.println("size.name() = " + size.name());
        System.out.println("size.toString() = " + size.toString());
    }
}

enum Size {
    /**
     *
     */
    SMALL("S", "С��"),
    MIDDLE("M", "�к�"),
    LARGE("L", "���");

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
     * ��̬�������Ը��ݴ����des���õ���Ӧ��ö��ʵ��
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
