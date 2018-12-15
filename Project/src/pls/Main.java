package pls;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("This is a dissertation search program.");
        System.out.println("Exit Program : '-q'");
        String search;
        Scanner scan;

        while (true) {
            System.out.print("Enter Keywords To Search: ");
            scan = new Scanner(System.in, "EUC_KR");
            search = scan.nextLine();
            if(search.equals("-q"))
                break;
            FileManage fm = new FileManage(search);
            new Riss(search,fm.fileout());
            new GoogleScholar(search, fm.fileout());
            System.out.println("Search Done!");
        }
        scan.close();
    }
}