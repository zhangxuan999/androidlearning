package gaojie;

//Class类	代表类的实体，在运行的Java应用程序中表示类和接口
//        Field类	代表类的成员变量（成员变量也称为类的属性）
//        Method类	代表类的方法
//        Constructor类	代表类的构造方法
//在阅读Class类文档时发现一个特点，以通过反射获得Method对象为例，一般会提供四种方法，
//        getMethod(parameterTypes)、getMethods()、getDeclaredMethod(parameterTypes)和getDeclaredMethods()。
//        getMethod(parameterTypes)用来获取某个公有的方法的对象，
//        getMethods()获得该类所有公有的方法，
//        getDeclaredMethod(parameterTypes)获得该类某个方法，
//        getDeclaredMethods()获得该类所有方法。
//        带有Declared修饰的方法可以反射到私有的方法，没有Declared修饰的只能用来反射公有的方法。

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
            AAA aaa = aaaClass.newInstance();//调用无参的构造方法
            System.out.println("---------getMethods---------");
            for (Method method : aaaClass.getMethods()) {
               System.out.println(method.toString());
            }
            ;
            System.out.println("---------getDeclaredFields---------");
            for (Field field : aaaClass.getDeclaredFields()) {
                System.out.println(field.toString());
            }
            ;
            System.out.println("---------setField---------");
            Field a = aaaClass.getDeclaredField("a");
            //私有属性
            a.setAccessible(true);
            Object o = a.get(aaa);
            System.out.println((Integer) o);

            System.out.println("---------getDeclaredMethod---------");
            Method getA = aaaClass.getDeclaredMethod("getA");
            MyAnnotation myAnnotation = getA.getAnnotation(MyAnnotation.class);//得到getA方法使用到的注解
            if (myAnnotation != null) {
                Class<?>[] parameterTypes = getA.getParameterTypes();//得到getA方法的参数
                System.out.println("---------getDeclaredMethod parameterTypes.length---------"+ parameterTypes.length);
                System.out.println("---------getDeclaredMethod myAnnotation.age()---------"+ myAnnotation.age());
                System.out.println("---------getDeclaredMethod myAnnotation.hsh()---------"+ myAnnotation.hsh());
                System.out.println("---------getDeclaredMethod myAnnotation.shssh()---------"+ myAnnotation.shssh());
            }
            //方法调用
            System.out.println(getA.invoke(aaa));//aaa调用getA方法
//            newInstance()底层就是调用无参构造方法的newInstance()
            aaaClass.getDeclaredAnnotations();//AAA这个类上的注解
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

@Deprecated
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


    @MyAnnotation(age = 1, hsh ='a' , shssh ="",stringArray = {"111","222"})
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
