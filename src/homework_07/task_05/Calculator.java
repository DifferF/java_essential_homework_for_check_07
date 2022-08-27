package homework_07.task_05;

/*
Задание 5+
Создайте проект, используя IntelliJ IDEA. Создайте класс Calculator.
В теле класса создайте четыре метода для арифметических действий: (add – сложение, sub – вычитание, mul – умножение, div – деление).

Метод деления должен делать проверку деления на ноль, если проверка не проходит, сгенерировать исключение.
Пользователь вводит значения, над которыми хочет произвести операцию и выбрать саму операцию.
При возникновении ошибок должны выбрасываться исключения.
 */

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int counter = 1;
    static double num1;
    static double num2;

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        num1 = getDouble();
        counter++;
        num2 = getDouble();
        String operator = getOperation();
        System.out.println(num1 + " " + operator + " " + num2 + " = " + calc(operator) );
    }

    public static double getDouble() {
        System.out.print("Напишите значение " + counter + " | ");
        double numIn = 0;
        try {
            numIn = scanner.nextDouble();
        } catch (InputMismatchException q) {
            System.out.println("________Ошибка. Только цифры________");
            scanner.next();
            numIn = getDouble();
        }
        return numIn;
    }

    public static String getOperation() {
        System.out.println("Выберите оператора  +  -  * / ");
        String operation = scanner.next();

        if (Objects.equals(operation, "+") || Objects.equals(operation, "-") || Objects.equals(operation, "*") || Objects.equals(operation, "/")) {
            return operation;
        } else {
            System.out.println("________Ошибка. Оператора________");
            getOperation();
        }

        return operation;
    }

    public static double calc(String operation) {
         double result = 0;

        switch (operation) {
            case "+": result = met1();
                 break;
            case "-": result = met2();
                break;
            case "*": result = met3();
                break;
            case "/": result = met4();
                break;
        }
        return result;
    }

    public static double met1() {
        return num1 + num2;
    }

    public static double met2() {
        return num1 - num2;
    }

    public static double met3() {
        return num1 * num2;
    }

    public static double met4() {
        double result = 0;

        try {
            result = num1 / num2;
            if (result == Double.POSITIVE_INFINITY ||
                    result == Double.NEGATIVE_INFINITY)
                throw new ArithmeticException();
        } catch (ArithmeticException q) {
            System.out.println("на ноль делить нельзя.");
            System.exit(0);
        }
        return result;
    }
}
