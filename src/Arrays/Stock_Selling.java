package Arrays;

public class Stock_Selling {
    public static void main(String[] args) {
//        int[] price = {7,10,1,3,6,9,2};
//        int n =  price.length;
//        int max  = 0;
//        for(int i =  0 ; i < n ; i++){
//            for(int j = i+1 ; j < n ; j++){
//                if(price[i] <= price[j]){
//                    max = max >  price[j] - price[i] ? max : price[j] - price[i];
//                }
//            }
//        }
//        System.out.println(max);
        int[] price = {7, 10, 1, 3, 6, 9, 2};
        int n = price.length;

        int minPrice = price[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            // update profit if selling today gives better profit
            int profit = price[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            // update minPrice if today's price is lower
            if (price[i] < minPrice) {
                minPrice = price[i];
            }
        }

        System.out.println(maxProfit);
    }
}
