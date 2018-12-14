package pls;

import java.io.IOException;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchSite {
    String SiteURL;
    String url_1;
    String search;
    String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36";
    Document doc;
}

class Riss extends SearchSite {
    Riss(String search) {
        this.SiteURL = "http://www.riss.kr/index.do";
        HashMap<String,String> searchOpt = new HashMap();
        searchOpt.put("Dissertation","&cate=bib_t");
        searchOpt.put("Domestic Journal Paper","&cate=re_a_kor");
        searchOpt.put("Foreign Journal","&cate=re_a_over");
        String []Opt = {"Dissertation","Domestic Journal Paper","Foreign Journal"};

        for(int i=0; i<3; i++) {
            this.url_1 = "http://www.riss.kr/search/Search.do?detailSearch=false&searchGubun=true&oldQuery=&query="
                    + search
                    + "&x=0&y=0"
                    + searchOpt.get(Opt[i]);
           
            try {
                doc = Jsoup.connect(url_1).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Site Name: RISS");
            System.out.println("URL: " + SiteURL);
            System.out.println("-------------------------------------------");
            
            Elements list = doc.select(".degree");
            int count = 1;
            for (Element el : list.select("li")) {
                System.out.println("Number " + count++);
                System.out.println("Category: " + Opt[i]);
                System.out.println("Title: "+ el.select(".txt > a").text());
                String rink = new String();
                System.out.println("Author: "+ el.select(".etc").text());
                System.out.println("Rink: " + el.select("[href]").attr("abs:href").toString());
                System.out.println("-------------------------------------------");
                System.out.println();
            }
        }
    }
}

class Google extends SearchSite {
    Google(String search) {
        this.SiteURL = "https://scholar.google.co.kr/";
        this.url_1 = "https://scholar.google.co.kr/scholar?hl=ko&as_sdt=0%2C5&q=" + search + "oq=";
    }
}

class Kiss extends SearchSite {
    Kiss(String search) {
        this.SiteURL = "http://search.koreanstudies.net/";
    }
}

class Ntis extends SearchSite {
    Ntis(String search) {
        this.SiteURL = "https://www.ntis.go.kr/ThMain.do";
        this.url_1 = "https://www.ntis.go.kr/ThSearchTotalList.do?sort=RANK%2FDESC%2CSS01%2FDESC&ntisYn=&searchWord="
                + search;
    }
}