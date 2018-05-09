package leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

    public static void main(String[] args) {
        String[] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        
        System.out.println(new SubdomainVisitCount().subdomainVisits(input));
    }
    public List<String> subdomainVisits(String[] cpdomains) {

        if (cpdomains.length==0) {
            return Collections.emptyList();
        }

        HashMap<String, Integer> result = new HashMap<>();

        for (String domaincount: cpdomains) {

            int count = Integer.parseInt(domaincount.substring(0, domaincount.indexOf(" ")));
            String domain = domaincount.substring(domaincount.indexOf(" ")+1);

            populateResult(count, domain, result);
        }

        List<String> rl = new ArrayList<>();
        for(Map.Entry e:result.entrySet()) {
            rl.add(e.getValue() + " " + e.getKey());
        }

        return rl;
    }

    private void populateResult(int count, String domain, HashMap<String, Integer> result) {

        while(domain.contains(".")) {

            Integer currentcount = result.get(domain);
            if (currentcount==null) {
                result.put(domain, count);
            } else {
                result.put(domain, currentcount+count);
            }

            domain = domain.substring(domain.indexOf(".")+1);
        }

        Integer currentcount = result.get(domain);
        if (currentcount==null) {
            result.put(domain, count);
        } else {
            result.put(domain, currentcount+count);
        }
    }

}
