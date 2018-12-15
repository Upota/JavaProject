package pls;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupParser { // Prototype
 
    /*
     *  Document 클래스 : 연결해서 얻어온 HTML 전체 문서
     *  Element 클래스  : Documnet의 HTML 요소
     *  Elements 클래스 : Element가 모인 자료형
     */
     
    public static void main(String[] args) {
        // Jsoup 이용 네이버 스포츠 크롤링
        String url = "https://sports.news.naver.com/wfootball/index.nhn";
        Document doc = null;
         
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        // 뉴스 태그를 찾는다.
        Elements element = doc.select("div.home_news");
         
        // 1. 헤더 부분의 제목
        String title = element.select("h2").text().substring(0, 4);
 
        System.out.println("============================================================");
        System.out.println(title);
        System.out.println("============================================================");
         
        for(Element el : element.select("li")) {  // 2. 하위 뉴스 기사들의 제목
            System.out.println(el.text());
        }
         
        System.out.println("============================================================");
    }
}