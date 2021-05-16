package com.AtGuiGu.Json;

import com.AtGuiGu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/14-17:05
 */

public class JsonTest {

    //1javaBean和json的互转
    @Test
    public void test1(){
        Person person = new Person(1, "ccq");
        //创建Gson对象实例
        Gson gson = new Gson();
        //toJson方法可以吧Java对象转化称为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        //fromJson 把json字符串转化回java对象
        //第一个参数是java字符串
        //第二个参数是转换回去的java对象类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);

    }
    //list 和 json 的互转
    @Test
    public void test2(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person(1,"name1"));
        personList.add(new Person(2,"name2"));

        Gson gson = new Gson();
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);
        // 把 List 转换为 json 字符串
        List<Person> list = gson.fromJson(personListJsonString, new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);
    }

    //map 和 json 的互转
    @Test
    public void test3(){
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "cc1"));
        personMap.put(2, new Person(2, "cc2"));

        Gson gson = new Gson();
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);

//        Map<Integer, Person> personMap1 = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        Map<Integer, Person> personMap1 = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer, Person>>(){}.getType());
        System.out.println(personMap1);
        Person p = personMap1.get(1);
        System.out.println(p);

    }

}
