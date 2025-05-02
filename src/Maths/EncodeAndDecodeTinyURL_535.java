//535. Encode and Decode TinyURL
//Solved
//Medium
//Topics
//Companies
//Note: This is a companion problem to the System Design problem: Design TinyURL.
//TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
//
//There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
//
//Implement the Solution class:
//
//Solution() Initializes the object of the system.
//String encode(String longUrl) Returns a tiny URL for the given longUrl.
//String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
// 
//
//Example 1:
//
//Input: url = "https://leetcode.com/problems/design-tinyurl"
//Output: "https://leetcode.com/problems/design-tinyurl"
//
//Explanation:
//Solution obj = new Solution();
//string tiny = obj.encode(url); // returns the encoded tiny url.
//string ans = obj.decode(tiny); // returns the original url after decoding it.
// 
//
//Constraints:
//
//1 <= url.length <= 104
//url is guranteed to be a valid URL.

package Maths;
import java.util.*;
public class EncodeAndDecodeTinyURL_535 {
	    static HashMap<String,String> map= new HashMap();
	    // Encodes a URL to a shortened URL.
	    public static String encode(String longUrl) {
	        String id=UUID.randomUUID().toString();
	        String baseurl= "http://tinyurl.com/";
	        String shortUrl=baseurl+id;
	        map.put(id,longUrl);
	        return shortUrl;
	    }

	    // Decodes a shortened URL to its original URL.
	    public static String decode(String shortUrl) {
	        String [] url= shortUrl.split("/");
	        return map.get(url[url.length-1]);
	    }
	    public static void main(String[] args) {
	    	
	    	//Example 1:

	    	String  url1 = "https://leetcode.com/problems/design-tinyurl";
	    	String shortURl=encode(url1);
	    	if(url1.equals(shortURl)) {
	    		System.out.println("Incorrect Output");
	    	}
	    	String originalUrl=decode(shortURl);
	    	if(url1.equals(originalUrl)) {
	    		System.out.println("Correct Output");
	    	}else {
	    		System.out.println("Inorrect Output");	    		
	    	}
	    	//Output: "https://leetcode.com/problems/design-tinyurl"

	    	
			
		}

}
