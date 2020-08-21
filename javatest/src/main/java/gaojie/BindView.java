package gaojie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface BindView {
    int value() default -1;
}


//ANDROID APT 注解处理工具
//https://www.jianshu.com/p/92e4a6159a1a，里面讲解了类似butterknife是怎么工作的
//1.定义一个注解 例如BindView
//2.定义一个注解处理器  继承AbstractProcessor，并实现process方法
//private HashMap<String, BinderClassCreator> mCreatorMap = new HashMap<>();
//在这个方法里面遍历mCreatorMap这个hashmap，并且生成一个java文件。XXX_ViewBinding.java
//3.BinderClassCreator 这个类是用来生成java代码的
//4.使用
//代码使用这个注解
//编译期间通过注解处理器生成XXX_ViewBinding.java
//运行期间new这个XXX_ViewBinding对象，并且通过反射调用它的方法

//public class BinderViewTools {
//    public static void init(Activity activity) {
//        Class clazz = activity.getClass();
//        try {
//            Class<?> bindClass = Class.forName(clazz.getName() + "_ViewBinding");
//            Method bind = bindClass.getMethod("bindView", clazz);
//            bind.invoke(bindClass.newInstance(),activity);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}