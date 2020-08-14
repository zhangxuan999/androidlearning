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
//    ���� annotation type element
//    ()���治���в�����()ֻ��������﷨
    int age();

    char hsh();

    String shssh();

    String[] stringArray();
//    String[][] sshshhss();wrong

//    �������������ͣ�����person����Ԫ�ص�����ֻ���ǻ����������͡�String��Class
//    ��ö�����͡�ע�����ͣ�������ע���Ƕ��Ч�����Լ��������͵�һά����
//    Person person();wrong

}
