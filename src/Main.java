import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String valueFirst, valueIn;

        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        valueFirst = in.nextLine();

        Date date, date1, date2, date3, dateNew, date4, date5;
        SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
        try {
            date = ft.parse(valueFirst);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        date1 = new Date(date.getTime() + 1000*60*60*24*45L);
        valueIn = ft.format(date1);
        System.out.println("Сдвинутая на 45 дней: " + valueIn);

        date2 = new Date(date.getYear(), 0,1);
        valueIn = ft.format(date2);
        System.out.println("Сдвинутая на начало года: " + valueIn );

        date3 = new Date(date.getTime());
        int ind = 0;

        while (ind<10) {
            date3.setTime(date3.getTime() + 1000*60*60*24);
            if ((date3.getDay() != 5) && (date3.getDay() != 6)) ind++;
        }

        valueIn = ft.format(date3);
        System.out.println("Сдвинутая на 10 рабочих дней: " + valueIn);


        System.out.println("Введите вторую дату в формате 'дд.мм.гггг'");
        valueFirst = in.nextLine();

        try {
            dateNew = ft.parse(valueFirst);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if (date.getTime() < dateNew.getTime()) {
            date4 = new Date(date.getTime());
            date5 = new Date(dateNew.getTime());
        }
        else {
            date4 = new Date(dateNew.getTime());
            date5 = new Date(date.getTime());
        }

        int indNew = 0;

        while (date4.before(date5)) {
            date4.setTime(date4.getTime() + 1000*60*60*24);
            if ((date4.getDay() != 5) && (date4.getDay() != 6)) indNew++;
        }

        System.out.println("Количество рабочих дней между введенными датами: " + indNew);


    }
}