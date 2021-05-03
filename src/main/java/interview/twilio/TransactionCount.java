package interview.twilio;

// Problem: the function 'getUsernames' should return array of strings denoting the usernames of the users whose
//          submission count is greater than the given threshold. Username in the array must be in the order they
//          appear in the API response

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TransactionCount{
    public static void main(String[] args){
        try {
            List<Integer> result = ResultNew.getTxns("01-2019", "debit", "4");
            System.out.println(result);
            /*for(int id : result){
                System.out.println(id);
            }*/
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
class ResultNew {
    private static final String url = "https://jsonmock.hackerrank.com/api/transactions/search?userId=";
    public static List<Integer> getTxns(String monthYear, String txnType, String uid) throws Exception{
        List<Integer> txnList = new ArrayList<>();
        int pageCount = 1;
        int totalPages = 0;
        String json = "";
        Double amount = 0.0;

        List<Transaction> transctions = new ArrayList<>();
        do {
            try {
                json = readUrl(url + uid + "&page=" + pageCount);
            } catch (Exception e) {
                // TODO: handle exception
            }
            Gson gson = new Gson();
            Page response = gson.fromJson(json, Page.class);

            if (response != null && !response.data.isEmpty()) {

                for (Transaction transaction : response.data) {

                    Date date = new Date(transaction.timestamp);
                    SimpleDateFormat sdf = new SimpleDateFormat("MM-YYYY");
                    String dateString = sdf.format(date);

                    if (transaction.txnType.equals(txnType) && dateString.equals(monthYear)) {
                        transctions.add(transaction);

                        String amt = transaction.amount.substring(1);
                        amt = amt.replaceAll(",", "");
                        amount += Double.parseDouble(amt);
                    }
                }
            }

            pageCount++;
            totalPages = response.total_pages;

        } while (pageCount <= totalPages);


        Double avg = amount / transctions.size();
        System.out.println(avg);

        for (Transaction txn : transctions) {
            String amt = txn.amount.substring(1);
            amt = amt.replaceAll(",", "");

            Double a = Double.parseDouble(amt);

            if (a > avg) {
                /*System.out.println(a);
                System.out.println(txn.id);*/
                txnList.add(txn.id);
            }
        }

        return txnList;
    }

    public static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try{
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        } finally {
            if(reader != null)
                reader.close();
        }
    }

    class Page {
        String page;
        int per_page;
        int total;
        int total_pages;
        List<Transaction> data;
    }

    class Transaction {
        int id;
        int userId;
        String userName;
        long timestamp;
        String txnType;
        String amount;
        Location location;
    }
    class Location{
        int id;
        String address;
        String city;
        int zipCode;
    }
}