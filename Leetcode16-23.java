package test;
import java.lang.reflect.Array;
import java.util.*;

public class test {
	 public int threeSumClosest(int[] nums, int target) {
		 int min = Integer.MAX_VALUE;
			int result = 0;
		 
			Arrays.sort(nums);
		 
			for (int i = 0; i < nums.length; i++) {
				int j = i + 1;
				int k = nums.length - 1;
				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k];
					int diff = Math.abs(sum - target);
		 
					if(diff == 0) return sum;
		 
					if (diff < min) {
						min = diff;
						result = sum;
					}
					if (sum <= target) {
						j++;
					} else {
						k--;
					}
				}
			}
		 
			return result;
	        
	    }
	 public static List<String> letterCombinations(String digits) {
	    	HashMap<String, String> m=new HashMap<String,String>();
	    	m.put("2","abc");m.put("3", "def");m.put("4", "ghi");m.put("5", "jkl");m.put("6", "mno");m.put("7", "pqrs");
	    	m.put("8", "tuv");m.put("9", "wxyz");
	    	List<String> a=new ArrayList<String>();
	    	if(digits.length()>1){
	    		String h=digits.substring(1, digits.length());
	    		String t=""+digits.charAt(0);
	    		String cre=m.get(t);  
	    		for(int i=0;i<cre.length();i++){	
	    			List<String> x=letterCombinations(h);
	    			for(int j=0;j<x.size();j++){
	    				String s=""+cre.charAt(i);
	    				s+=x.get(j);
	    				a.add(s);
	    			}
	    		}
	    		return a;
	    	}
	    	else if(digits.length()==1){
	    		if(!m.containsKey(digits)) return a;
	    		String t=""+digits.charAt(0);
	    		String cre=m.get(t); 
	    		String s="";
	    		for(int i=0;i<cre.length();i++){
	    			s+=cre.charAt(i);
	    			a.add(s);
	    			s="";
	    		}
	    		return a;
	    	}
	    	else return a;
	    	
	  }
	 public List<List<Integer>> fourSum(int[] nums, int target) {
	     List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(nums==null|| nums.length<4)
	        return result;
	    Arrays.sort(nums);
	    for(int i=0; i<nums.length-3; i++){
	        if(i!=0 && nums[i]==nums[i-1])
	            continue;
	        for(int j=i+1; j<nums.length-2; j++){
	            if(j!=i+1 && nums[j]==nums[j-1])
	                continue;
	            int k=j+1;
	            int l=nums.length-1;
	            while(k<l){
	                if(nums[i]+nums[j]+nums[k]+nums[l]<target){
	                    k++;
	                }else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
	                    l--;
	                }else{
	                    List<Integer> t = new ArrayList<Integer>();
	                    t.add(nums[i]);
	                    t.add(nums[j]);
	                    t.add(nums[k]);
	                    t.add(nums[l]);
	                    result.add(t);
	 
	                    k++;
	                    l--;
	 
	                    while(k<l &&nums[l]==nums[l+1] ){
	                        l--;
	                    }
	 
	                    while(k<l &&nums[k]==nums[k-1]){
	                        k++;
	                    }
	                }
	 
	 
	            }
	        }
	    }
	 
	    return result;
	        
	    }
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		 ListNode x=head;int i=0;
		 while(x!=null){
			 x=x.next;
			 i++;
		 }
		 x=head.next;ListNode y=head;ListNode t=head;
		 int j=2;
		 if(i-n+1==1){
			 t=t.next;
			 return t;
		 }
		 while(x!=null){
			 if(j==(i-n+1)){
				 x=x.next;
				 y.next=x;
				 break;
			 }
			 else{
			 x=x.next;
			 y=y.next;
			 j++;
			 }
		 }
		 return t;
		 
	       
	   }
	public static boolean isValid(String s) {
		Stack<String> a=new Stack<String>();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') a.push(s.substring(i, i+1));
			else{
				if(a.empty()) return false;
				String m=a.pop();
				if(s.charAt(i)==')'){
					if(!m.equals("(")) return false;
				}
				if(s.charAt(i)==']'){
					if(!m.equals("[")) return false;
				}
				if(s.charAt(i)=='}'){
					if(!m.equals("{")) return false;
				}
			}
		}
		if(!a.empty()) return false;
		return true;   
    }
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null&&l2==null) return null;
		else if(l1==null) return l2;
		else if(l2==null) return l1;
		int x=l1.val<l2.val?l1.val:l2.val;
		ListNode n=new ListNode(x);
		ListNode head=n;
		if(x==l1.val) l1=l1.next;
		else l2=l2.next;
		while(l1!=null||l2!=null){
			if(l1==null) {n.next=l2;break;}
			else if(l2==null) {n.next=l1;break;}
			else{
				if(l1.val<l2.val){
					int y=l1.val;
					n.next=new ListNode(y);
					l1=l1.next;
				}
				else{
					int y=l2.val;
					n.next=new ListNode(y);
					l2=l2.next;
				}
				n=n.next;
			}
		}
		return head;     
	}
public static List<String> generateParenthesis(int n) {
	List<String> a=new ArrayList<String>();
	if(n==0) return a;
	if(n==1){
		a.add("()");
		return a;
	}
	HashSet<String> x=new HashSet<String>();
	List<String> b=generateParenthesis(n-1);
	
	for(int i=0;i<b.size();i++){
		String fi="()"+b.get(i);
		String la=b.get(i)+"()";
		String in="("+b.get(i)+")";
		x.add(fi);x.add(la);x.add(in);
	}
	for(int i=2;i<=n/2;i++){
		List<String> c=generateParenthesis(i);
		List<String> d=generateParenthesis(n-i);
		for(int j=0;j<c.size();j++){
			for(int k=0;k<d.size();k++){
				String s=c.get(j)+d.get(k);
				String t=d.get(k)+c.get(j);
				x.add(s);x.add(t);
			}
			
		}
	}
	a=new ArrayList(x);
	return a;
        
}
	public ListNode mergeKLists(ListNode[] lists) {
		int n=lists.length;
		if(n>2){
			ListNode[] list1=new ListNode[n/2];
			ListNode[] list2=new ListNode[n-n/2];
			for(int i=0;i<n;i++){
				if(i<n/2) list1[i]=lists[i];
				else list2[i-n/2]=lists[i];
			}
			ListNode n1=mergeKLists(list1);
			ListNode n2=mergeKLists(list2);
			return mergeTwoLists(n1,n2);
		}
		else if(n==2){
			ListNode n1=lists[0];
			ListNode n2=lists[1];
			return mergeTwoLists(n1,n2);
		}
		else if(n==1){ return lists[0];}
		else return null;      
		    }
	
	public static void main(String args[]){


	}
}
