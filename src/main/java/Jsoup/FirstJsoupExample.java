//package Jsoup;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//
//public class FirstJsoupExample {
//    public static void main(String[] args) throws IOException {
//        Document doc = Jsoup.connect("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/index.html").get();
////        String title = doc.title();
////        System.out.println(title);
//        Elements links = doc.select("a[href]");
//        for (Element link : links) {
//            System.out.println("\nlink : " + link.attr("href"));
//            System.out.println("text : " + link.text());
//        }
//    }
//}
