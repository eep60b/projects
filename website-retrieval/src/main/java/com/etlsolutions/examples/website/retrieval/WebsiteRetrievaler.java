package com.etlsolutions.examples.website.retrieval;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

/**
 *
 * @author zc
 */
public final class WebsiteRetrievaler {

    private static final int MAX_DEPTH = 2;
    private final HashSet<String> links = new HashSet<>();

    private static int fileIndex = 1;
    
    public void getPageLinks(String URL, int depth) {
        
        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
            System.out.println(">> Depth: " + depth + " [" + URL + "]");
            try {
                links.add(URL);

                Document document = Jsoup.connect(URL).get();
                List<TextNode> textMpdes = document.textNodes();
                
                for(TextNode node : textMpdes){
                    FileUtils.writeStringToFile(new File ("/Temp/craeler/" + (100000 + fileIndex++) + ".txt"), node.text(), "UTF-8");
                }
                
                Elements linksOnPage = document.select("a[href]");

                depth++;
                for (Element page : linksOnPage) {
                    getPageLinks(page.attr("abs:href"), depth);
                }
            } catch (Throwable e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        new WebsiteRetrievaler().getPageLinks("http://gushiwen.org/", 0);
    }
}
