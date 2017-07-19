package test;
import java.lang.reflect.Array;
import java.util.*;

public class test {
	public static String convert(String s, int numRows) {
		String out="";int pace=2*numRows-2;
		if(pace==0){
			for(int i=0;i<s.length();i++){
				out+=s.toCharArray()[i];
				
			}	return out;
		}
		for(int i=0;i<s.length();i+=pace){
			out+=s.toCharArray()[i];
		}
		int pace_row=pace-2;
		for(int i=1;i<numRows-1;i++,pace_row-=2){
			for(int j=i;j<s.length();j+=pace){
				out+=s.toCharArray()[j];
				if(j+pace_row<s.length()) 
					out+=s.toCharArray()[j+pace_row];
			}
		}
		for(int i=numRows-1;i<s.length();i+=pace){
			out+=s.toCharArray()[i];
		}
		return out;
    }
	
	public static int reverse(int x) {
		boolean positive=true;
		if(x<0) {positive =false;x*=-1;}
		String m=Integer.toString(x);
		String n="";int j=0;
		for(int i=m.length()-1;i>=0;i--){
			n+=m.toCharArray()[i];
		}
		if(n.length()>10||(n.length()==10&&n.compareTo("2147483647")>0)) return 0;
		int t=Integer.parseInt(n);
		if(positive==false) t*=-1;
		return t;
        
    }
	
	public static int myAtoi(String str) {
	str=str.trim();
	if(str==null||str.length()==0) return 0;int i=0;
	String sns="";boolean positive=true;String num="0123456789";
	if(str.charAt(0)!='-'&&str.charAt(0)!='+'&&num.indexOf(str.charAt(0))==-1) return 0;
	else if(str.charAt(0)=='-') {positive=false;i++;}
	else if(str.charAt(0)=='+') i++;
	for(;i<str.length();i++){
		if(num.indexOf(str.charAt(i))!=-1) sns+=str.charAt(i);
		else break;
	}
	if(sns.length()==0) return 0;
	if(sns.length()>10||(sns.length()==10&&sns.compareTo("2147483647")>0)) return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
	else return positive?Integer.parseInt(sns):-1*Integer.parseInt(sns);
    }
	
	public boolean isPalindrome(int x) {
		if(x<0) return false;
		else if(x==0) return true;
		else{
			int tmp=x;
			int y=0;
			while(x!=0){
				y=y*10+x%10;
				x/=10;
			}
			return y==tmp?true:false;
		}
		
        
    }
	
    public boolean isMatch(String s, String p) {
    	if(s.length() == 0 && p.length() == 0)
            return true;
        boolean dp[][]=new boolean [s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int j = 0; j < p.length(); ++j)    
            dp[0][j + 1] = (p.charAt(j) == '*' && dp[0][j - 1]);
        for(int i = 0; i < s.length(); ++i)
        {
            for(int j = 0; j < p.length(); ++j)
            {
                if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))
                {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                else if(p.charAt(j) == '*')
                {
                    if(dp[i + 1][j - 1])                  
                    {
                        dp[i + 1][j + 1] = true;
                        continue;
                    }
                    if(p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.')   
                    {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
	
    public static int maxArea(int[] height) {
    	int max=0;int i=0;int j=height.length-1;
    	if(j<=0) return 0;
    	while(i<j){
    		if(height[i]<height[j]) {max=Math.abs(j-i)*height[i]>max?Math.abs(j-i)*height[i]:max;i++;}
    		else{ max=Math.abs(j-i)*height[j]>max?Math.abs(j-i)*height[j]:max;j--;}
    	}
    	return max;
    	
    	
    	
    }
	public static String intToRoman(int num) {
		//Map<Integer,String> l=new HashMap<Integer,String>();
		//l.put(900, "CM");l.put(1000,"M" );l.put(400, "CD");l.put(500,"D");l.put(100, "C");
		String s="";
		if(num/1000!=0){
			for(int i=0;i<num/1000;i++) s+="M";
			num=num%1000;
		}
		if(num/100==9) s+="CM";
		else if(num/100==4) s+="CD";
		else if(num/100>=5){s+="D";for(int i=0;i<(num-500)/100;i++) s+="C";}
		else {
			for(int i=0;i<num/100;i++) s+="C";			
		}
		num=num%100;
		if(num/10==9) s+="XC";
		else if(num/10==4) s+="XL";
		else if(num/10>=5){s+="L";for(int i=0;i<(num-50)/10;i++) s+="X";}
		else {
			for(int i=0;i<num/10;i++) s+="X";			
		}
		num=num%10;
		if(num==9) s+="IX";
		else if(num==4) s+="IV";
		else if(num>=5){s+="V";for(int i=0;i<(num-5);i++) s+="I";}
		else {
			for(int i=0;i<num;i++) s+="I";			
		}
		return s;
    }
    
	public static int romanToInt(String s) {
		int num=0;
		for(int i=0;i<s.length();i++){
			if(i==s.length()-1){
				if(s.charAt(i)=='M') num+=1000;
				else if(s.charAt(i)=='D') num+=500; 
				else if(s.charAt(i)=='C') num+=100;
				else if(s.charAt(i)=='L') num+=50;
				else if(s.charAt(i)=='X') num+=10;
				else if(s.charAt(i)=='V') num+=5;
				else if(s.charAt(i)=='I') num+=1;
			}
			else if(s.charAt(i)=='C'&&s.charAt(i+1)=='M'){ num+=900;i++;}
			else if(s.charAt(i)=='C'&&s.charAt(i+1)=='D') {num+=400;i++;}
			else if(s.charAt(i)=='X'&&s.charAt(i+1)=='C') {num+=90;i++;}
			else if(s.charAt(i)=='X'&&s.charAt(i+1)=='L') {num+=40;i++;}
			else if(s.charAt(i)=='I'&&s.charAt(i+1)=='X') {num+=9;i++;}
			else if(s.charAt(i)=='I'&&s.charAt(i+1)=='V') {num+=4;i++;}
			else if(s.charAt(i)=='M') num+=1000;
			else if(s.charAt(i)=='D') num+=500; 
			else if(s.charAt(i)=='C') num+=100;
			else if(s.charAt(i)=='L') num+=50;
			else if(s.charAt(i)=='X') num+=10;
			else if(s.charAt(i)=='V') num+=5;
			else if(s.charAt(i)=='I') num+=1;
		}
		return num;
        
    }
	public String longestCommonPrefix(String[] strs) {
		String s="";
		if(strs.length==0) return "";
		Arrays.sort(strs);
		for(int i=0;i<(strs[0].length()>strs[strs.length-1].length()?strs[strs.length-1].length():strs[0].length());i++){
			if(strs[0].charAt(i)==strs[strs.length-1].charAt(i)) s+=strs[0].charAt(i);
			else break;
		}
		return s;
    }
	 public static List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> res = new ArrayList<List<Integer>>();
	        Arrays.sort(nums);
	        int N = nums.length;
	        for (int i = 0; i < N-2 && nums[i] <= 0; ++i)
	        {
	            if (i > 0 && nums[i] == nums[i-1])
	                continue; // avoid duplicates
	            int twosum = 0 - nums[i];
	            int l = i + 1, r = N - 1;
	            while (l < r)
	            {
	                int sum = nums[l] + nums[r];
	                if (sum < twosum) ++l;
	                else if (sum > twosum) --r;
	                else {
	                    ArrayList<Integer> tmp = new ArrayList<Integer>();
	                    tmp.add(nums[i]); tmp.add(nums[l]); tmp.add(nums[r]);
	                    res.add(tmp);
	                    ++l; --r;
	                    while (l < r && nums[l] == nums[l-1]) ++l;  // avoid duplicates
	                    while (l < r && nums[r] == nums[r+1]) --r;  // avoid duplicates
	                }
	            }
	        }
	        return res;
	    }
	    
	public static void main(String args[]){
	}
}
