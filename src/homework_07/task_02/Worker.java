package homework_07.task_02;

/*
адание 2+
Создайте проект, используя IntelliJ IDEA. Требуется: Описать класс с именем Worker, содержащую следующие поля:
  фамилия и инициалы работника;
  название занимаемой должности;
  год поступления на работу.
Написать программу, выполняющую следующие действия:
  ввод с клавиатуры данных в массив, состоящий из пяти элементов типа Worker (записи должны быть упорядочены по алфавиту);
  если значение года введено не в соответствующем формате выдает исключение.
  вывод на экран фамилии работника, стаж работы которого превышает введенное значение.
 */

public class Worker implements Comparable <Worker> {
    String fioWorker;
    String postWorker;
    String yearWorker;

    public Worker(String fioWorker, String postWorker, String yearWorker) {
        this.fioWorker = fioWorker;
        this.postWorker = postWorker;
        this.yearWorker = yearWorker;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "fio='" + fioWorker + '\'' +
                ", post='" + postWorker + '\'' +
                ", year='" + yearWorker + '\'' +
                '}';
    }

    @Override
    public int compareTo(Worker o) {
        return this.fioWorker.compareTo(o.fioWorker);
    }
}
