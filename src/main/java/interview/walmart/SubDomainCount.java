package interview.walmart;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author sandesh.mendan on 11/11/20
 * @project algorithms-and-datastructures
 */
//Problem: Given the list of domains; count the sub domain count; ignore "www." part; for given input, below is result
//com : 4
//google.com : 2
//stores.walmart.com : 1
//walmart.com : 2
//in : 1     .... etc
public class SubDomainCount {
    public static void main(String[] a){
        List<String> domains = new ArrayList<>();
        domains.add("www.google.com");
        domains.add("www.mail.google.com");
        domains.add("www.walmart.com");
        domains.add("www.stores.walmart.com");
        domains.add("www.irctc.in");
        domains.add("www.india.gov");
        Map<String, Integer> result = countSubDomains(domains);
        for(String key : result.keySet())
            System.out.println(key + " : " + result.get(key));
    }

    private static Map<String, Integer> countSubDomains(List<String> domains) {
        Map<String, Integer> result = new HashMap<>();
        for(String str : domains){
            String withoutWww = str.substring(4);
            List<String> subDomains = Arrays.asList(withoutWww.split("\\."));
            String prev = "";
            for(int i = subDomains.size()-1; i >= 0; i--){
                String subDomain = subDomains.get(i) + "." + prev;
                if(prev.length() == 0)
                    subDomain = subDomains.get(i);
                if(result.containsKey(subDomain)){
                    result.put(subDomain, result.get(subDomain) + 1);
                }else {
                    result.put(subDomain, 1);
                }
                prev = subDomain;
            }
        }
        return result;
    }
}
