package gaojie;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javaproject.Person;

/**
 * @author zhangxuan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface MyAnnotation {
//    定义 annotation type element
//    ()里面不能有参数，()只是特殊的语法
    int age();

    char hsh();

    String shssh();

    String[] stringArray();
//    String[][] sshshhss();wrong

//    不能是其他类型，例如person，该元素的类型只能是基本数据类型、String、Class
//    、枚举类型、注解类型（体现了注解的嵌套效果）以及上述类型的一维数组
//    Person person();wrong

}
