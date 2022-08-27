package homework_07.task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задание 3+
Создайте проект, используя IntelliJ IDEA. Требуется: Описать класс с именем Price, содержащую следующие поля:
  название товара;
  название магазина, в котором продается товар;
  стоимость товара в гривнах.

 Написать программу, выполняющую следующие действия:
  ввод с клавиатуры данных в массив, состоящий из двух элементов типа Price (записи должны быть упорядочены в алфавитном порядке по названиям магазинов);
  вывод на экран информации о товарах, продающихся в магазине, название которого введено с клавиатуры (если такого магазина нет, вывести исключение).
 */

public class Price implements Comparable<Price> {

    String shopName;
    String productName;
    double priceProduct;


    public Price(String shopName, String productName, double priceProduct) {
        this.shopName = shopName;
        this.productName = productName;
        this.priceProduct = priceProduct;
    }


    @Override
    public String toString() {
        return "Price{" +
                "shopName = '" + shopName + '\'' +
                ", productName = '" + productName + '\'' +
                ", priceProduct = " + priceProduct + " грн " +
                '}';
    }

    public String getShopName() {
        return shopName;
    }

    public String getProductName() {
        return productName;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    @Override
    public int compareTo(Price o) {
        return this.shopName.compareTo(o.getShopName());

    }
}


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader readerBR = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Укажите количество магазинов | ");
        int shopCount = Integer.parseInt(readerBR.readLine());

        Price[] pricesArr = new Price[shopCount];

        int counterShop = 1;
        for (int i = 0; i < pricesArr.length; i++) {
            System.out.print("Напишите название магазина " + counterShop + " | ");
            String shopName = readerBR.readLine();
            System.out.print("Напишите название товара в магазине " + shopName + " | ");
            String productName = readerBR.readLine();
            System.out.print("Напишите цену " + productName + " | ");
            double priceProduct = Double.parseDouble(readerBR.readLine());

            try {
                if (priceProduct < 1)
                    throw new Exception("Напишите цену больше 0");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.print("Напишите цену " + productName + " | ");
                priceProduct = Double.parseDouble(readerBR.readLine());
            }
            pricesArr[i] = new Price(shopName, productName, priceProduct);
            counterShop++;
        }

        Arrays.sort(pricesArr);

        for (int i = 0; i < pricesArr.length; i++) {
            System.out.println(pricesArr[i].toString());
        }

        System.out.print("Введите название магазина   | ");
        String shop_name = readerBR.readLine();
        int counterArr = 0;

        for (int i = 0; i < pricesArr.length; i++) {
            String name = pricesArr[i].shopName;

            if (shop_name.equals(name)) {
                System.out.println(pricesArr[i].toString());
                counterArr++;
            }
            try {
                if (counterArr == 0 & i == pricesArr.length - 1)
                    throw new Exception("Такого магазина нет");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
