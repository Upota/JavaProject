package pls;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileOutputStream;

public class FileManage {
    String search;
    PrintStream printStream;
    FileManage(String search) throws IOException {
        this.search = search;
        File result = new File("C:\\Users\\yujih\\Desktop\\SearchResult");

    	if(!result.exists())
        result.mkdirs();
        
        printStream = new PrintStream(new FileOutputStream(new File(result+"\\"+search+".txt")));
    }
        public PrintStream fileout() {
            return printStream;
        }
}

