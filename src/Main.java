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

        Date date, date1;
        SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
        try {
            date = ft.parse(valueFirst);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        date1 = new Date(date.getTime() + 1000*60*60*24);
        valueIn = ft.format(date1);
        System.out.println(valueIn);
    }
}