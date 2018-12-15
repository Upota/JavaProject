package pls;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupParser { // Prototype
 
    /*
     *  Document Ŭ���� : �����ؼ� ���� HTML ��ü ����
     *  Element Ŭ����  : Documnet�� HTML ���
     *  Elements Ŭ���� : Element�� ���� �ڷ���
     */
     
    public static void main(String[] args) {
        // Jsoup �̿� ���̹� ������ ũ�Ѹ�
        String url = "https://sports.news.naver.com/wfootball/index.nhn";
        Document doc = null;
         
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        // ���� �±׸� ã�´�.
        Elements element = doc.select("div.home_news");
         
        // 1. ��� �κ��� ����
        String title = element.select("h2").text().substring(0, 4);
 
        System.out.println("============================================================");
        System.out.println(title);
        System.out.println("============================================================");
         
        for(Element el : element.select("li")) {  // 2. ���� ���� ������ ����
            System.out.println(el.text());
        }
         
        System.out.println("============================================================");
    }
}