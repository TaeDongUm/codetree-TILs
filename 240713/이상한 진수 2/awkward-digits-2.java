import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String a = sc.next();
        String newStr="";
        boolean flag=false;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='0'){
                flag = true;
            }
        }
        if(flag){
            for(int i=0;i<a.length();i++){            
                if(a.charAt(i) == '0'){
                    StringBuilder sb = new StringBuilder(a);
                    sb.setCharAt(i, '1');
                    newStr = sb.toString();
                    break;

                }
            }
        }else{
            for(int i=a.length()-1;i>0;i--){            
                if(a.charAt(i) == '1'){
                    StringBuilder sb = new StringBuilder(a);
                    sb.setCharAt(i, '0');
                    newStr = sb.toString();
                    break;

                }
            }
        }
        int sum=0;
        for(int i=0;i<newStr.length();i++){
            if(newStr.charAt(i)=='1'){
                int exp = newStr.length()-1-i;
                sum += (int)Math.pow(2,exp);
                
            }
        }
        System.out.println(sum);
        
    }
}