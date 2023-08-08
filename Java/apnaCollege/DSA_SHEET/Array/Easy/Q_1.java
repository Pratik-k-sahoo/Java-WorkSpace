package Java.apnaCollege.DSA_SHEET.Array.Easy;

//Maximum and minimum of an array using minimum number of comparisons

import java.util.Arrays;

public class Q_1 {

    public static void maxMinBySort(int arr[]){

        Arrays.sort(arr);

        System.out.println("Maximum element is : " + arr[0]);
        System.out.println("Minimum element is : " + arr[arr.length-1]);

    }

    static class MinMaxPair{
        int min, max;
    }

    public static MinMaxPair maxMinByLinearSearch(int arr[]){
        MinMaxPair mm=new MinMaxPair();
        int i;

        if(arr.length==1){
            mm.min=arr[0];
            mm.max=arr[0];

            return mm;
        }

        if(arr[0]>arr[1]){
            mm.min=arr[1];
            mm.max=arr[0];
        }
        else{
            mm.max=arr[1];
            mm.min=arr[0];
        }

        for(i=2; i<arr.length; i++){
            if(arr[i]>mm.max){
                mm.max=arr[i];
            }
            if(arr[i]<mm.min){
                mm.min=arr[i];
            }
        }

        return mm;
    }

    public static MinMaxPair maxMinByTournament(int arr[], int low, int high){
        MinMaxPair mm=new MinMaxPair();
        MinMaxPair mmLeft=new MinMaxPair();
        MinMaxPair mmRight=new MinMaxPair();
        if(low==high){
            mm.min=arr[low];
            mm.max=arr[low];

            return mm;
        }

        if(high==low+1){
            if(arr[low]>arr[high]){
                mm.max=arr[low];
                mm.min=arr[high];
            }
            else{
                mm.max=arr[high];
                mm.min=arr[low];
            }

            return mm;
        }

        int mid=(low+high)/2;
        mmLeft=maxMinByTournament(arr, low, mid);
        mmRight=maxMinByTournament(arr, mid+1, high);

        if(mmLeft.min<mmRight.min){
            mm.min=mmLeft.min;
        }
        else{
            mm.min=mmRight.min;
        }

        if(mmLeft.max<mmRight.max){
            mm.max=mmRight.max;
        }
        else{
            mm.max=mmLeft.max;
        }

        return mm;
    } 

    public static MinMaxPair maxMinByComparision(int arr[]){
        MinMaxPair mm=new MinMaxPair();
        int i;

        //if arr size is even then then initialize first two element as min and max and i=2
        if(arr.length%2==0){
            if(arr[0]<arr[1]){
                mm.min=arr[0];
                mm.max=arr[1];
            }else{
                mm.min=arr[1];
                mm.max=arr[0];
            }
            i=2;
        }
        //if arr size is odd then first element as min and max both and i=1;
        else{
            mm.min=arr[0];
            mm.max=arr[0];
            i=1;
        }

        while(i<arr.length-1){
            if(arr[i]>arr[i+1]){
                if (arr[i] > mm.max) {
                    mm.max = arr[i];
                }
                if (arr[i + 1] < mm.min) {
                    mm.min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > mm.max) {
                    mm.max = arr[i + 1];
                }
                if (arr[i] < mm.min) {
                    mm.min = arr[i];
                }
            }
            i += 2;
            
        }
        return mm;
    }
    public static void main(String[] args) {
        int arr[]={1, 8, 6, -2, 10, 5};

        maxMinBySort(arr);
        System.out.println("Maximum element is : " + maxMinByLinearSearch(arr).max);
        System.out.println("Minimum element is : " + maxMinByLinearSearch(arr).min);
        
        System.out.println("Minimum element is : " + maxMinByTournament(arr, 0, arr.length-1).min);
        System.out.println("Maximum element is : " + maxMinByTournament(arr, 0, arr.length-1).max);
        
        System.out.println("Maximum element is : " + maxMinByComparision(arr).max);
        System.out.println("Minimum element is : " + maxMinByComparision(arr).min);
    }
}
