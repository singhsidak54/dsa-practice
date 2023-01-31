package companies.Bloomberg;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebCrawler {
    interface HtmlParser {
        public List<String> getUrls(String url);
    }

    String hostName;
    Set<String> visited;

    public void dfs(String url, HtmlParser htmlParser) {
        visited.add(url);

        for(String neighbour : htmlParser.getUrls(url)) {
            if(neighbour.length() < (7 + hostName.length())) continue;
            String neighbourHost = neighbour.substring(7, 7 + hostName.length());
            if(hostName.equals(neighbourHost) && !visited.contains(neighbour)) {
                dfs(neighbour, htmlParser);
            }
        }
    }
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        visited = new HashSet<>();
        int i = 7;
        StringBuilder host = new StringBuilder();
        while (i < startUrl.length() && startUrl.charAt(i) != '/') {
            host.append(startUrl.charAt(i++));
        }

        hostName = host.toString();

        dfs(startUrl, htmlParser);
        return visited.stream().toList();
    }
}
