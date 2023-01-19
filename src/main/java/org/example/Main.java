package org.example;

public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();


        System.out.println("Person has age? " + mom.hasAge());
        System.out.println("Person has city? " + mom.hasAddress());

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .setAge(2)
                .build();
        System.out.println("У " + mom + "  есть сын " + son);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setName("Анна").setSurname("Вольф").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}