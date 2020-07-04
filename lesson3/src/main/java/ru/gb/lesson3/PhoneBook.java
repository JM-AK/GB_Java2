package ru.gb.lesson3;
/*
2. Написать простой класс PhoneBook(внутри использовать HashMap):
В качестве ключа использовать фамилию
В каждой записи всего два поля: phone, e-mail
Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
* и отдельный метод для поиска e-mail по фамилии.
* Следует учесть, что под одной фамилией может быть несколько записей.
* Итого должно получиться 3 класса Main, PhoneBook, Person.
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, String> phoneMap = new HashMap<>();
    Map<String, String> emailMap = new HashMap<>();

    public void add (String lastName, String phone, String email) {
        phoneMap.putIfAbsent(phone, lastName);
        emailMap.putIfAbsent(email, lastName);
    }

    public void add (Person person) {
        phoneMap.putIfAbsent(person.getPhone(), person.getLastName());
        emailMap.putIfAbsent(person.getEmail(), person.getLastName());
    }

    public ArrayList<String> getPhone (String lastName){
        ArrayList<String> phoneList = new ArrayList<>();
        for(Map.Entry<String,String> entry : phoneMap.entrySet()){
            if(lastName.equals(entry.getValue())) phoneList.add(entry.getKey());
        }
        return phoneList;
    }
    public ArrayList<String> getEmail (String lastName){
        ArrayList<String> emailList = new ArrayList<>();
        for(Map.Entry<String,String> entry : emailMap.entrySet()){
            if(lastName.equals(entry.getValue())) emailList.add(entry.getKey());
        }
        return emailList;
    }

}
