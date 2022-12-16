package companies.Intuit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    HashMap<String, Integer> domainMap;

    public void processDomain(String domain, int count) {
        if(domain.length() == 0) return;

        domainMap.put(domain, domainMap.getOrDefault(domain, 0) + count);
        int j = 0;
        while (j < domain.length() && domain.charAt(j) != '.') {
            j++;
        }

        if(j != domain.length()) {
            processDomain(domain.substring(j + 1), count);
        }
    }
    public List<String> subdomainVisits(String[] cpDomains) {
        domainMap = new HashMap<>();
        for(String cpDomain : cpDomains) {

            // split cpDomain into count and domain
            int j = 0;
            while (cpDomain.charAt(j) != ' ') {
                j++;
            }

            int count = Integer.parseInt(cpDomain.substring(0, j));
            String domain = cpDomain.substring(j + 1);

            processDomain(domain, count);
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> map : domainMap.entrySet()) {
            result.add(map.getValue() + " " + map.getKey());
        }

        return result;
    }
}
