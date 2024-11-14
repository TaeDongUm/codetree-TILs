import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());        
        int[] num = new int[n];
        
        st = new StringTokenizer(br.readLine());
        int count=num.length-1;

        int cnt=0;
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        radixSort(num);
 

        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }        

    }
    public static void radixSort(int[] arr) {
        // 자리수를 지정할 Radix변수와 , 최대자릿수를 가리킬 최대값을 구합니다.
        final int MaxNumber = getMaxNum(arr);
        int radix = 1, ArraySize = arr.length;

        // bucket 초기화
        List<Queue<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucket.add(new LinkedList<>());
        }

        // 자릿수별로 순차적으로 정렬 - (LSD : 최하위 자리수 정렬)
        while (radix <= MaxNumber) {
            // bucket에 담기
            for (int idx = 0; idx < ArraySize; idx++) {
                bucket.get((arr[idx] / radix) % 10).add(arr[idx]);
            }

            // bucket에서 꺼내기
            for (int arr_idx = 0, bucket_idx = 0; bucket_idx < 10; bucket_idx++) {
                // 해당 bucket Index Queue안에 데이터가 들어있는 경우이기에 꺼냅니다.
                while (!bucket.get(bucket_idx).isEmpty()) {
                    arr[arr_idx++] = bucket.get(bucket_idx).poll();
                }
            }

            // 한 번의 자릿수를 기준으로 정렬했으면 다음 자릿수로 넘어가기
            radix *= 10;
        }
    }
    
    // 최대자릿수를 알아낼 수 있게, 배열에서 가장 큰 수 구하기
    public static int getMaxNum(int[] array){
    	int maxNumber = array[0];
        for (int indexNumber : array){
        	if (indexNumber > maxNumber)
            	maxNumber = indexNumber;
        }
        return maxNumber;
    }
}