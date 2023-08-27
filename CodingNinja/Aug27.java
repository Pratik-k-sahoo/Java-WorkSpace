package CodingNinja;

import java.util.HashMap;
import java.util.Map;

public class Aug27 {

    public static String amazingStrings(String first, String second,String third) {

        if(first.length() + second.length() != third.length()){
            return "NO";
        }
		// Write your code here.

		HashMap<Character, Integer> map = new HashMap<>();
		HashMap<Character, Integer> ans = new HashMap<>();

		for(int i=0; i<first.length(); i++){
			char c = first.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for(int i=0; i<second.length(); i++){
			char c = second.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for(int i=0; i<third.length(); i++){
			char c = third.charAt(i);
			ans.put(c, ans.getOrDefault(c, 0) + 1);
		}

		for(Map.Entry<Character, Integer> e : map.entrySet()){
            // System.out.println(e);
            // System.out.println(ans.get(e.getKey()) + " " + e.getValue());
			if(!(ans.get(e.getKey()).equals(e.getValue())) && ans!=e){
				// System.out.println("NO");
                return "NO";
			}
		}

		return "YES";
	}

    public static void main(String[] args) {
        String first = "QO";
        String second = "TCDBACPQI";
        String third = "ZZQTEFTZVMLOLZXIHWVKDZOTMIYXSLS";

        System.out.println(amazingStrings(first, second, third));
        // int max = Math.max
        /*
         
QO TCDBACPQI ZZQTEFTZVMLOLZXIHWVKDZOTMIYXSLS
KOXBNRBXZULMKHWQYNARUJKJKWYLDGBBLK RFRIWPIKCEOIGVHXJSHPUQHA DQHVFLPJEGWIZGPSKXNMOUNQRLAIBKCABKKWXKUYROHIXBWUBJKRYJHHLR
KTNGEOYZNOSBALIXBFHYSDEZRGTQNRFU MZYUB OQUSOLTXIADZFENBTBGFBKZZYUERYMGRHNYNS

         */
    }
}