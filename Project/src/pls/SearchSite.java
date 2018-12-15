package pls;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.io.FileNotFoundException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchSite {
    String SiteURL;
    String url_1;
    String search;
    Document doc;
}

class Riss extends SearchSite {
    Riss(String search, PrintStream fo) throws FileNotFoundException {
        this.search = search;
        this.SiteURL = "http://www.riss.kr/index.do";

        HashMap<String,String> searchOpt = new HashMap();
        String []Opt = {"Dissertation","Domestic Journal Paper","Foreign Journal"};
        searchOpt.put(Opt[0],"&cate=bib_t");
        searchOpt.put(Opt[1],"&cate=re_a_kor");
        searchOpt.put(Opt[2],"&cate=re_a_over");

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
         
            fo.println("Site Name: RISS");
            fo.println("URL: " + SiteURL);
            fo.println("SearchRink: " + url_1);
            fo.println("-------------------------------------------");
            
            Elements list = doc.select(".degree");
            int count = 1;
            for (Element el : list.select("li")) {
                fo.println("Number " + count++);
                fo.println("Category: " + Opt[i]);
                fo.println("Title: "+ el.select(".txt > a").text());
                fo.println("Author: "+ el.select(".etc").text());
                fo.println("Rink: " + el.select("[href]").attr("abs:href").toString());
                fo.println("-------------------------------------------");
                fo.println();
            }
        }
    }
}

class GoogleScholar extends SearchSite {
    GoogleScholar(String search,PrintStream fo) throws FileNotFoundException {
        this.SiteURL = "https://scholar.google.co.kr/";
        this.url_1 = "https://scholar.google.co.kr/scholar?hl=ko&as_sdt=0%2C5&q=" + search + "&btnG=";
    
        try {
            doc = Jsoup.connect(url_1).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fo.println("Site Name: Google Scholar");
        fo.println("URL: " + SiteURL);
        fo.println("SearchRink: " + url_1);
        fo.println("-------------------------------------------");

        Elements list = doc.select("#gs_res_ccl");
        int count = 1;
        for(Element el : list.select(".gs_ri")) {
            fo.println("Number " + count++);
            fo.println("Title: "+ el.select("h3 > a").text());
            fo.println("Author: "+ el.select(".gs_a").text());
            fo.println("Rink: " + el.select("[href]").attr("abs:href").toString());
            fo.println("-------------------------------------------");
            fo.println(); 
        }
    }
}

//http://eds.b.ebscohost.com/eds/search/basic?vid=0&sid=76522b17-8618-4cb0-b900-c507d2537117%40pdc-v-sessmgr02