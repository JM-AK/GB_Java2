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

import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {
        String [] sampleWords = new String[]{"goal", "target", "main", "bull", "bull", "count", "key", "key", "key", "key"};
        countWords(sampleWords);
    }

    public static void countWords (String [] array){
        Map<String, Integer> words = new HashMap<>();
        for (String s : array){
            words.merge(s, 1, (a,b) -> b = a+1);
        }
        words.forEach((a,b) -> System.out.println(a + " - " + b));
    }

}
