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

    	if(!result.exists()) // 결과를 출력하는 텍스트 파일이 위치할 폴더가 없다면 생성
        result.mkdirs();

        // 파싱한 데이터를 printStream을 이용하여 텍스트파일에 직접 출력
        printStream = new PrintStream(new FileOutputStream(new File(result+"\\"+search+".txt")));
    }
        public PrintStream fileout() { // SearchSite에서 PrintStream을 이용하기 위해 만듬.
            return printStream;
        }
}

