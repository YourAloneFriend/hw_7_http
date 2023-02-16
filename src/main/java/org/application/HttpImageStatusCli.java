package org.application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {

    private static final HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
    private static final Scanner scanner = new Scanner(System.in);

    public void askStatus(){
        while (true){
            System.out.print("Enter HTTP status code: ");
            try {
                String data = scanner.next();
                if(data.equals("q"))
                    return;
                int code = Integer.parseInt(data);
                httpStatusImageDownloader.downloadStatusImage(code);
                System.out.println("Image is downloaded!");
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Try again.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            //scanner.nextLine();
        }
    }
}
