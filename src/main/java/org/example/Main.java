//Thread.currentThread() - имя текущего потока;
//Добавить новый поток - создаешь отдельный класс, наследуешься от класса Thread, переопределяешь метод run();
//Вариант №2 - наследовать интерфейс от Runnable, там можно переопределить только метод run();
//thread.start(); - запустить поток;
//thread.join(); - блокировка остальных процессов до завершения работы потока;
//Практическое задание
//Необходимо написать два метода, которые делают следующее:
//1) Создают одномерный длинный массив
//2) Заполняют этот массив единицами.
//3) Засекают время выполнения: long a = System.currentTimeMillis().
//4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
//Math.cos(0.4f + i / 2));
//5) Проверяется время окончания метода System.currentTimeMillis().
//6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).


package org.example;

public class Main {
    public static void main(String[] args) {
firstThread();
secondThread();

    }
    public static void firstThread() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Скорость первого потока: " + (System.currentTimeMillis() - startTime) + " сек.");
    }

    public static void secondThread() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Скорость второго потока: " + (System.currentTimeMillis() - startTime) + " сек.");
    }
}