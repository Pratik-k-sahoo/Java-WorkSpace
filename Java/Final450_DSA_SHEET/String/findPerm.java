//Print all the permutations of the given string

package Java.Final450_DSA_SHEET.String;


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(5);
        arr.add(1);
        // arr.sort();
        System.out.close();
	}
}

class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        
        List<String> list1=new ArrayList<>();
        
        char tempArray[]=S.toCharArray();
        Arrays.sort(tempArray);

        StringBuilder sb=new StringBuilder(tempArray.length);
        for(char c:tempArray){
            sb.append(c);
        }

        S=sb.toString();
        System.out.println("Arranged : " + S);

        list1=perm(S, "", 0);
        System.out.println(list);
        return list1;
    }
    List<String> list=new ArrayList<>();
    
    public List<String> perm(String S, String perm, int idx){
        
        
        
        if(S.length()==0){
            System.out.println(perm);
            System.out.println(list);
            boolean flag=list.add(perm);
            System.out.println(flag);
            return list;
        }
        
        for(int i=0; i<S.length(); i++){
            char currChar=S.charAt(i);
            String newS=S.substring(0, i) + S.substring(i+1);
            perm(newS, perm+currChar, idx+1);
        }
        
        return list;
    }
}