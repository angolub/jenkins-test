package ru.yandex.practicum;


public class Praktikum  {
    public static void main(String[] args) {
        String name = "Alina Golub";
        Account account = new Account(name);
        System.out.println("Результат проверки имени" + account.checkNameToEmboss());
    }
}