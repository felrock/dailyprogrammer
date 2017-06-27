package dailyprogrammer10;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WikiLinkPath {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = "/wiki/" + scan.nextLine();
        HashSet<String> visited = new HashSet<String>();
        boolean run = true;
        while(run){
            try {
                Document doc = Jsoup.connect("https://en.wikipedia.org" + input).get();
                Elements contentDiv = doc.select("div#bodyContent");
                Elements paragraphs = contentDiv.select("p");
                Elements links = paragraphs.select("a");
                for(Element link :links){
                    String linkName = link.attr("href");
                    if(!visited.contains(linkName)){
                        visited.add(linkName);
                        input = linkName;
                        System.out.println(linkName);
                        break;
                    }else if(linkName.equals("/wiki/Philosophy")){
                        run = false;
                    }else{
                        run = false;
                    }
                }
            } catch (IOException e) {
                break;
            }
        }
        scan.close();
    }
}
