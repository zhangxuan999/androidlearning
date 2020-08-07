package com.chujian.ups.mvvmtest;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        System.out.println("haha"+String.class.getCanonicalName());
        Object[] array = new Object[1];
        array[0] = "sss";
//         System.out.println("haha"+array.getClass().getCanonicalName());
//         System.out.println("haha"+GGGGS.class.getCanonicalName());
//         System.out.println("haha"+ssss.class.getCanonicalName());
//         System.out.println("haha"+new Object(){}.getClass().getCanonicalName());

        HashMap<GGGGS,String> hashMap = new HashMap<>();
        GGGGS key1 = new GGGGS();
        GGGGS key2 = new GGGGS();
        GGGGS key3 = new GGGGS();
        GGGGS key4 = new GGGGS();
        hashMap.put(key1,"11111");
        hashMap.put(key2,"2222");
        hashMap.put(key3,"3333");
        hashMap.put(key4,"44444");
        ;
        System.out.println("haha"+hashMap.get(new GGGGS()));
        System.out.println("haha"+hashMap.get(key2));
        System.out.println("hashMap.size()"+hashMap.size());


        HashMap<String,Object> hashMap1 = new HashMap<>();
        hashMap1.put(new String("111"),new Object());
        hashMap1.put(new String("111"),new Object());
        hashMap1.put(new String("111"),new Object());
        hashMap1.put(new String("111"),new Object());
        System.out.println("hashMap1.size()"+hashMap1.size());

    }

    static class GGGGS{
        int i;

        public GGGGS() {
            super();
        }

        @Override
        public int hashCode() {
            return 11111;
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            return super.equals(obj);
        }
    }

    class ssss{
        int j;
    }
}
