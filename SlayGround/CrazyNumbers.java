package SlayGround;

import java.util.ArrayList;

public class CrazyNumbers{
    public static void main(String[] args) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n=2;

        ArrayList<Integer> ans = new ArrayList<>();
        // ans.ensureCapacity(3);
        // for(int i=0; i<n; i++){
        //     ans.add(0);
        // }
        // System.out.println(ans.size());
        int count=1;

        for(int i=0; i<n; i++){
            // if(count>9)count =1;
            for(int j=0; j<n-i-1; j++){
                ans.add(null);
            }
            for(int j=n-i-1; j<n; j++){
                if(count>9)count =1;
                ans.add(j, count);
                count++;
            }
            System.out.println(ans);
            list.add(new ArrayList<>(ans));
            ans.clear();
        }
        System.out.println(list);
    }
}