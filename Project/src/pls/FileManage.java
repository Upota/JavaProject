package pls;

import java.io.File;

public class FileManage {
    FileManage(String search) {

    File desktop = new File("C:\\Users\\yujih\\Desktop\\SearchResult");

	if(!desktop.exists())
        desktop.mkdirs(); 
        
    }
}