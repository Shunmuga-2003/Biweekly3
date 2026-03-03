package ZohoTharuvai.Biweekly3;

public class SellStock {
    public static void main(String[] args) {
        int[] prices={7,6,4,3,1};
        System.out.println(bestTimeToBuyAndSell(prices));
    }
    public static int bestTimeToBuyAndSell(int[] prices){
        int minIndex=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            int difference=(prices[i]-minIndex);
            max=Math.max(max,difference);
            minIndex=Math.min(prices[i],minIndex);
        }
        return max;
    }
}
