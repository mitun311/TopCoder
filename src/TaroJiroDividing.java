import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaroJiroDividing{
  
  public static int getNumber(int A,int B){
  
  Set<Integer> hmNum = new HashSet<Integer>();
  int num = 0;
  int num2 = 0;
  if(A > B) {  num = A ; num2 = B; }
  else { num = B ;  num2 = A;      }
    
  hmNum.add(num);
  while(num > 0){
       if(num % 2 == 1) { hmNum.add(num); break; }
       num = num / 2 ;
       hmNum.add(num);
  }
  int count = 0;
  while(num2 > 0){
       if(num2 % 2 == 1) { 
          if(hmNum.contains(num2)){ count++;}
       }
       num2 = num2 / 2;
       if(hmNum.contains(num2)){ count++;}
  }  
  
  return count ; 

}
  
  public static char flip(char ch){
	  
	  if(ch =='A') return 'B';
	  else return  'A';
	  
  }
  
  public static int checkVals(String S){
	  
	 // int dp[][] = new int[50][2];
	  char[] a = new char[S.length()];
	  int sIndex = -1;
	  
	  for(int i = 0;i< S.length();i++)
		   if(S.charAt(i)!='?') { sIndex = i ; break ; } //obtained the first non ? from then on process
	
	  for(int i = sIndex ;i<S.length();i++){
		  if(S.charAt(i)!='?') a[i]=S.charAt(i);
		  else if(S.charAt(i)=='?') a[i] = flip(a[i-1]);
	  }
	  if(sIndex != 1){
		  a[sIndex -1 ] = flip(a[sIndex]);
		  for(int i = sIndex -1 ; i>=0;i--)
			  a[i] = flip(a[i+1]);
	  }
	  
	  int count = 0;
	  for(int i =0;i<S.length()-1;i++)
		  if(a[i] == a[i+1]) count++;
	  return count;
  }
  
  
  public static int recursiveVals(){
	
	  return 0;
  }
  
  
  public static void main(String[] args){
	  
	 // System.out.println(getNumber(1,1000000000));"?BB?BAAB???BAB?B?AAAA?ABBA????A?AAB?BBA?A?"
	  //checkVals("A??B???AAB?A???A");
	  System.out.println(checkVals("?BB?BAAB???BAB?B?AAAA?ABBA????A?AAB?BBA?A?"));
	  //ABBABAABABABABABAAAAABABBABABAABAABABBABAB
  }
}