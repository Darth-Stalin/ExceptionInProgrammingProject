package home.work.exception;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static home.work.exception.ParseText.transform;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные разделенные пробелом в порядке:" +
                " Фамилия Имя Отчество дата-рождения номертелефона пол");
        String user = scanner.nextLine();

        try {
            String[] data = user.split(" ");
            if (data.length  < 5 ) {
                throw new IllegalArgumentException("Пожалуйста прочитайте условие внимательно!");
            }
            String lastName = transform(data[0]);
            String firstName = transform(data[1]);
            String middleName = transform(data[2]);
            String birthday = ParseDate.formatDate(ParseDate.parsebdate(data[3]));
            String phoneNumber = ParseNumber.check(String.valueOf(Long.parseLong(data[4])));
            char gender = ParseGender.genderParse(data[5].charAt(0));

            try (FileWriter fileWriter = new FileWriter("exception.txt")) {
                fileWriter.write(user);
            } catch (RuntimeException | IOException e) {
                System.out.println("catch exception: " + e.getClass().getSimpleName());
            }

            System.out.println("lastName: " + lastName + "\n" + "firstName: " + firstName + "\n"
                    + "middleName: " + middleName + "\n" + "birthday: "+
                    birthday + "\n" + "phoneNumber: " + phoneNumber + "\n" + "gender: " + gender);


        } catch (NumberFormatException e) {
            System.out.println("Invalid phone number");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Insufficient data");
        } catch (InputMismatchException e){
            System.out.println("Invalid symbol");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date");
        }
    }
}
