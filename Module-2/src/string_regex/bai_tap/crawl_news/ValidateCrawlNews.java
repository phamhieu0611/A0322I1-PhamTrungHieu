package string_regex.bai_tap.crawl_news;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCrawlNews {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://dantri.com.vn/the-gioi.htm ");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n","");
            Pattern p = Pattern.compile("a href = >(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()){
                String string = m.group(1);
                int index = string.indexOf("\">");
                if (index!=-1 && string.length()>5){
                    String s = string.substring(index+2);
                    if ((s.charAt(0)=='1' || s.charAt(0)=='2')&&s.charAt(1)=='.'){
                        System.out.println(s);
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
