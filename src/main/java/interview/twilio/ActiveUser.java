package interview.twilio;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sandesh.mendan on 27/10/20
 * @project algorithms-and-datastructures
 */
// Problem: the function 'getUsernames' should return array of strings denoting the usernames of the users whose
//          submission count is greater than the given threshold. Username in the array must be in the order they
//          appear in the API response

public class ActiveUser{
    public static void main(String[] args){
        try {
            List<String> result = Result.getUsernames(10);
            for(String user : result){
                System.out.println(user);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
class Result {
    public static List<String> getUsernames(int threshold) throws Exception{
        List<String> result = new LinkedList<>();
        String json = readUrl("https://jsonmock.hackerrank.com/api/article_users?page=" + 1); //any number would do as total_pages is same in all pages
        Gson gson = new Gson();
        Page page = gson.fromJson(json, Page.class);

        for(int i = 1; i <= page.total_pages; i++){
            String json1 = readUrl("https://jsonmock.hackerrank.com/api/article_users?page=" + i);
            Page page1 = gson.fromJson(json1, Page.class);
            for(User user : page1.data){
                if(user.submission_count > threshold)
                    result.add(user.username);
            }
        }
        return result;
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
        List<User> data;
    }

    class User {
        int id;
        String username;
        String about;
        int submitted;
        String updated_at;
        int submission_count;
        int comment_count;
        double created_at;
    }
}

