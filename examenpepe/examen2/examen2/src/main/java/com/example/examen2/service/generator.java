package com.example.examen2.service
import java.util.ArrayList;
import java.util.Random;

    public class generator {

         public static ArrayList<Integer> generator(){
             ArrayList<Integer> list = new ArrayList<>();

             for(int i=0;i<5;i++){
                 Random random = new Random();
                 list.add(random.netInt(10) + 1);
             }
             return list;

         }

}