package gaojie;

//Class��	�������ʵ�壬�����е�JavaӦ�ó����б�ʾ��ͽӿ�
//        Field��	������ĳ�Ա��������Ա����Ҳ��Ϊ������ԣ�
//        Method��	������ķ���
//        Constructor��	������Ĺ��췽��
//���Ķ�Class���ĵ�ʱ����һ���ص㣬��ͨ��������Method����Ϊ����һ����ṩ���ַ�����
//        getMethod(parameterTypes)��getMethods()��getDeclaredMethod(parameterTypes)��getDeclaredMethods()��
//        getMethod(parameterTypes)������ȡĳ�����еķ����Ķ���
//        getMethods()��ø������й��еķ�����
//        getDeclaredMethod(parameterTypes)��ø���ĳ��������
//        getDeclaredMethods()��ø������з�����
//        ����Declared���εķ������Է��䵽˽�еķ�����û��Declared���ε�ֻ���������乫�еķ�����

//https://www.jianshu.com/p/9be58ee20dee
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {
    public static void main(String[] args) {
        Class<AAA> aaaClass = AAA.class;
        try {
            AAA aaa = aaaClass.newInstance();
            for (Method method : aaaClass.getMethods()) {
               System.out.println(method.toString());
            }
            ;
            System.out.println("---------zxzx---------");
            for (Field field : aaaClass.getDeclaredFields()) {
                System.out.println(field.toString());
            }
            ;
            Field a = aaaClass.getDeclaredField("a");
            //˽������
            a.setAccessible(true);
            Object o = a.get(aaa);
            System.out.println((Integer) o);

            Method getA = aaaClass.getDeclaredMethod("getA");
            //��������
            System.out.println(getA.invoke(aaa));
//            newInstance()�ײ���ǵ����޲ι��췽����newInstance()

            for (Annotation annotation : aaaClass.getDeclaredAnnotations()) {
                System.out.println(annotation.toString());
            }
            ;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}


class AAA{
    int a = 5;
    int b;
    int c;

     AAA(){

    }
    AAA(int a,int b){
        this.a = a;
        this.b = b;
    }

    AAA(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = a;
    }


    @MyAnnotation(age = 1, hsh ='a' , shssh ="" )
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(value = {ElementType.METHOD})
    @interface shhsh{
         String value();
    }
}
