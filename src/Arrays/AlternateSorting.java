package Arrays;

import java.util.Arrays;

public class AlternateSorting {
    public static void main(String[] args) {
        int[] arr = {7,8,3,4,5,1,2,5,4};
        int n = arr.length;
        alternateSorting(arr,n);
    }
    private static void alternateSorting(int[] arr, int n){
        int[] even = new int[n];
        int[] odd = new int[n];
        int ecount = 0 ;
        int ocount = 0 ;


        for(int i = 0 ; i < n ;i++){
            if(arr[i] % 2 == 0){
                even[ecount++] = arr[i];
            }else if( arr[i] % 2 == 1){
                odd[ocount++] = arr[i];
            }
        }

        even = Arrays.copyOf(even,ecount);
        odd = Arrays.copyOf(odd,ocount);
    
        Arrays.sort(odd);
        Arrays.sort(even);
        reverse(even);

        int i = 0 , j = 0 , k = 0;
        while( i < ocount && j < ecount){
            if(arr[0] % 2 == 1){
                arr[k++] = odd[i++];
                arr[k++] = even[j++];
            }else if( arr[0] % 2 == 0) {
                arr[k++] = even[j++];
                arr[k++] = odd[i++];
            }
        }

        while( i < ocount){
            arr[k++] = odd[i++];
        }

        while(j < ecount){
            arr[k++] = even[j++];
        }

        for(int x : arr)
            System.out.print(x + " ");
    }

    private static void reverse(int[] even) {
        int left = 0 , right = even.length-1;
        while(left < right){
            int temp = even[left];
            even[left ] = even[right];
            even[right] = temp ;
            left++;
            right--;
        }
    }
}
