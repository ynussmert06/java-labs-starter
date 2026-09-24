package edu.course.lab01;

/**
 * Небольшие методы для первой лабораторной работы.
 */
public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }

    /**
     * Возвращает true, если число четное.
     */
    public static boolean isEven(int number) {
        
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for(int i = 2; i * i <=  number; i++) {
           if (number % i == 0) {
               return false;
           }
        }

        return true;
    }

    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Ошибка: текст не можеть быть пустым"); //выбрасываем ошибку при пустом тексте
        }

        int leftindex = 0;
        int rithindex = text.length() - 1;
        while (leftindex < rithindex) {
            if (text.charAt(leftindex) != text.charAt(rithindex)) {
                return false;
            }
            leftindex++;
            rithindex--;
        }
        return true;
    }

    public static double average(int[] values) {
        if  (values == null || values.length == 0) {
            throw new IllegalArgumentException("Ошибка: массив не может быть пустым");
        }
        double dlina = values.length;
        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            int n = values[i];
            sum += n;
            // тело
        }
        return sum / dlina;
    }
}