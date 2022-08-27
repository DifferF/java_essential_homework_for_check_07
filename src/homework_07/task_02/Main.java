package homework_07.task_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static boolean isThisDateValid (String dateToValidate, String dateFormat){
        if(dateFormat == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        try {
            Date date = sdf.parse(dateToValidate);
        } catch (ParseException e){
            e.printStackTrace();
            System.out.println("Этот рабочий будет добавлен в список с нулевым годом");
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Worker [] worker = new Worker[2];
        BufferedReader workerBR = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i< worker.length; i++){
            System.out.print("Напишите ФИО рабочего " + " | ");
            String fioWorker = workerBR.readLine();
            System.out.print("Укажите должность рабочего " + fioWorker + " | ");
            String postWorker = workerBR.readLine();
            System.out.print("Год поступления на работу  | ");
            String yearWorker = workerBR.readLine();

            if (!isThisDateValid(yearWorker, "yyyy")) {
                yearWorker = "0000";
            }
            worker[i] = new Worker(fioWorker,postWorker,yearWorker);

//            if(isThisDateValid(yearWorker, "yyyy")) {
//                worker[i] = new Worker(fioWorker,postWorker,yearWorker);
//            } else {
//                yearWorker = "0000";
//                worker[i] = new Worker(fioWorker,postWorker,yearWorker);
//            }
        }

        Arrays.sort(worker);
        for (Worker item : worker) {
            System.out.println(item.toString());
        }


        System.out.print("Укажите стаж рабочего | ");
        
        int value = Integer.parseInt(workerBR.readLine());
        int yearNow = Calendar.getInstance().get(Calendar.YEAR);

        for(int i = 0; i < worker.length; i++){

            String yearWorker = worker[i].yearWorker;
            int experienceWorker = yearNow - Integer.parseInt(yearWorker);

            if(experienceWorker > value){
                System.out.println(worker[i].toString());
                System.out.println("Стаж рабочего :" + experienceWorker);
            }
        }
    }
}
