package GFG.POTD;

//Fraction pairs with sum 1


public class August_08{

    public static int countFractions(int n, int[] numerator, int[] denominator) {
        // code here
        
        int count=0;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                System.out.println(numerator[i] + " " + denominator[i] + " " + numerator[j] + " " + denominator[j]);
                double sum = ((double)numerator[i]/denominator[i]) + ((double)numerator[j]/denominator[j]);
                System.out.println(sum);
                if(sum == 1.0){
                    count++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int N = 4;
        int[] numerator = {1, 2, 2, 8};
        int[] denominator = {2, 4, 6, 12};
        System.out.println(numerator[0]/denominator[0]);

        System.out.println(countFractions(N, numerator, denominator));
    }
}