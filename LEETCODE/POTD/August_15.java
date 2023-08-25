package LEETCODE.POTD;

import java.util.HashSet;
// import java.util.function.IntFunction;

public class August_14 {
    public static void main(String[] args) {
        
    }
}

public ListNode partition(ListNode head, int x) {
        int n = size(head);
        int arr[] = new int[n];
        ListNode curr=head;
        int idx=0;
        while(curr!=null){
            arr[idx++]=curr.val;
            curr=curr.next;
        }

        rearrangeList(arr, x);
        curr=head;
        idx=0;
        while(curr!=null){
            curr.val=arr[idx++];
            curr=curr.next;
        }

        return head;
    }

    public int size(ListNode head){
        int count=0;
        ListNode curr = head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }

        return count;
    }

    public void rearrangeList(int[] head, int x){
        halfQuickSort(head, x, 0, head.length-1);
    }

    public void halfQuickSort(int[] head, int x, int start, int end){
        if(start>=end){
            return;
        }

        int cutIdx = getPivot(head, x, start, end);
        halfQuickSort(head, x, start, cutIdx-1);
        halfQuickSort(head, x, cutIdx+1, end);
    }

    public int getPivot(int[] head, int x, int start, int end){
        int pivot = head[end];
        int i = start-1;
        for(int j=start; j<=end - 1; j++){
            if(head[j]<=x){
                i++;
                swap(head, i, j);
            }
        }
        swap(head, i+1, end);

        return i+1;
    }

    public void swap(int[] head, int i, int j){
        int temp = head[i];
        head[i] = head[j];
        head[j] = temp;
    }
}