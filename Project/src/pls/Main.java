package pls;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //Scanner scan = new Scanner(System.in);
        String search = "search"; //scan.nextLine();
        new FileManage(search);
        new Riss(search);
        new GoogleScholar(search);

    }
}