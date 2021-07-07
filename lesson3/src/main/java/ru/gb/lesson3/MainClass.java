package ru.gb.lesson3;

/*
*1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
Найти список слов, из которых состоит текст (дубликаты не считать);
Посчитать сколько раз встречается каждое слово (использовать HashMap);
2. Написать простой класс PhoneBook(внутри использовать HashMap):
В качестве ключа использовать фамилию
В каждой записи всего два поля: phone, e-mail
Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
* и отдельный метод для поиска e-mail по фамилии.
* Следует учесть, что под одной фамилией может быть несколько записей.
* Итого должно получиться 3 класса Main, PhoneBook, Person.
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {
        String [] sampleWords = new String[]{"goal", "target", "main", "bull", "bull", "count", "key", "key", "key", "key"};
        countWords(sampleWords);
        System.out.println();

        Person p1 = new Person("White", "89293332211", "white@person.com");
        Person p2 = new Person("Black", "79103332211", "Black@person.com");
        Person p3 = new Person("Black", "89293333311", "BLUE@person.com");
        Person p4 = new Person("Orange", "8929332200", "o@person.com");
        Person p5 = new Person("Red", "892332210", "red@person.com");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(p1);
        phoneBook.add(p2);
        phoneBook.add(p3);
        phoneBook.add(p4);
        phoneBook.add(p5);

        System.out.println(phoneBook.getEmail("Black").toString());
        System.out.println(phoneBook.getPhone("Black").toString());
    }

    public static void countWords (String [] array){
        Map<String, Integer> words = new HashMap<>();
        for (String s : array){
            words.merge(s, 1, (a,b) -> b = a+1);
        }
        words.forEach((a,b) -> System.out.println(a + " - " + b));
    }

}
