package fuzzy_Logic;

import java.util.ArrayList;
import java.util.Stack;

public class chks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String y = "[If project_funding is medium ^ team_experience_level is intermediate] V [team_experience_level is beginner ^ project_funding is very low.]";
		String y1 = "[If project_funding is medium ^ team_experience_level is intermediate] V [team_experience_level is beginner]";
		String y2="If project_funding is high ^ team_experience_level is expert.";
		String y3 = "If project_funding is very low";
		String y4="If project_funding is low ^ team_experience_level is beginner";
		System.out.println(kk(y));
		System.out.println(kk(y1));
		System.out.println(kk(y2));
		System.out.println(kk(y3));
		System.out.println(kk(y4));
		String then1="[If project_funding is medium ^ team_experience_level is intermediate] V [team_experience_level is beginner] then risk is low";
		String then2="If project_funding is high ^ team_experience_level is expert then risk is normal";
		String then3="If project_funding is very low then risk is high.";
	}
	public static float kk(String r) 
	{
		float result = -1;
		if(r.charAt(0) =='[') 
		{
			int index = test(r,0);
			int length = r.length();
			String x1= r.substring(1,index);
			String x2= r.substring(index+5,length-1);
			if(x2.contains("]")&& (x2.contains("V") || x2.contains("^"))) 
			{
				char ch1='[';
				char ch2=']';
				x2=ch1+x2+ch2;
			}
			else 
			{
				x2=x2.substring(0,x2.length()-1);
			}
			String x3 = r.substring(index+1,index+3);
			if(x3.contains("V")) 
			{
				//System.out.print("max:	");
				//kk(x1);
				//kk(x2);
				result=Math.max(kk(x1),kk(x2));
			}
			else if(x3.contains("^")) 
			{
				//System.out.print("min:	");
				//kk(x1);
				//kk(x2);
				result=Math.min(kk(x1),kk(x2));
			}
		}
		else if(r.contains("V")) 
		{
			int index=r.indexOf("V");
			//System.out.print("max:	");
			//System.out.print(r.substring(0, index)+"	");			
			//System.out.print(r.substring(index+2,r.length())+"	");
			//System.out.println();
			//int index=r.indexOf("V");
			String r1=r.substring(0, index);
			String r2=r.substring(index+2,r.length());
			ArrayList <String> s = new ArrayList <String>();
			s.add(r1);
			s.add(r2);
			ArrayList <Integer> i = new ArrayList <Integer>();
			int num1=-1;
			for(int i1 =0;i1<s.size();i1++) 
			{
				if(s.get(i1).contains("project_funding")) 
				{
					if(s.get(i1).contains("very low")) 
					{
						num1=50;
					}
					else if(s.get(i1).contains("low")) 
					{
						num1=5;
					}
					else if(s.get(i1).contains("medium")) 
					{
						num1=5;
					}
					else if(s.get(i1).contains("high")) 
					{
						num1=0;
						//System.out.println("d5lt");
					}
					i.add(num1);
				}
				else if(s.get(i1).contains("team_experience_level"))
				{
					if(s.get(i1).contains("beginner")) 
					{
						num1=60;
					}
					else if(s.get(i1).contains("intermediate")) 
					{
						num1 =10;
					}
					else if(s.get(i1).contains("expert")) 
					{
						num1=50;
					//	System.out.println("d5lt2");
					}
				}
				i.add(num1);
			}
			//System.out.println(i);
			result = Math.max(i.get(0), i.get(2));
		}
		else if(r.contains("^")) 
		{
			/*int index=r.indexOf("^");
			System.out.print("min:	");
			System.out.print(r.substring(0, index)+"	");			
			System.out.print(r.substring(index+2,r.length())+"	");
			System.out.println();*/
			int index=r.indexOf("^");
			String r1=r.substring(0, index);
			String r2=r.substring(index+2,r.length());
			ArrayList <String> s = new ArrayList <String>();
			s.add(r1);
			s.add(r2);
			ArrayList <Integer> i = new ArrayList <Integer>();
			int num1=-1;
			for(int i1 =0;i1<s.size();i1++) 
			{
				if(s.get(i1).contains("project_funding")) 
				{
					if(s.get(i1).contains("very low")) 
					{
						num1=50;
					}
					else if(s.get(i1).contains("low")) 
					{
						num1=5;
					}
					else if(s.get(i1).contains("medium")) 
					{
						num1=5;
					}
					else if(s.get(i1).contains("high")) 
					{
						num1=5;
					}
					i.add(num1);
				}
				else if(s.get(i1).contains("team_experience_level"))
				{
					if(s.get(i1).contains("beginner")) 
					{
						num1=60;
					}
					else if(s.get(i1).contains("intermediate")) 
					{
						num1 =10;
					}
					else if(s.get(i1).contains("expert")) 
					{
						num1=50;
					}
				}
				i.add(num1);
			}
			result = Math.min(i.get(0), i.get(2));
		}
		else 
		{
			int num1=-1;
			if(r.contains("project_funding")) 
			{
				if(r.contains("very low")) 
				{
					num1=50;
				}
				else if(r.contains("low")) 
				{
					num1=5;
				}
				else if(r.contains("medium")) 
				{
					num1=5;
				}
				else if(r.contains("high")) 
				{
					num1=5;
				}
			}
			else if(r.contains("team_experience_level"))
			{
				if(r.contains("beginner")) 
				{
					num1=60;
				}
				else if(r.contains("intermediate")) 
				{
					num1 =10;
				}
				else if(r.contains("expert")) 
				{
					num1=50;
				}
			}
			result =num1;
		}
		return result;
	}
	static int test(String expression, int index) {
        int i=-1;
  
        // If index given is invalid and is 
        // not an opening bracket. 
        if (expression.charAt(index) != '[') {
            //System.out.print(expression + ", "
              //      + index + ": -1\n");
            return i;
        }
  
        // Stack to store opening brackets. 
        Stack<Integer> st = new Stack<>();
  
        // Traverse through string starting from 
        // given index. 
        for (i = index; i < expression.length(); i++) {
  
            // If current character is an 
            // opening bracket push it in stack. 
            if (expression.charAt(i) == '[') {
                st.push((int) expression.charAt(i));
            } // If current character is a closing 
            // bracket, pop from stack. If stack 
            // is empty, then this closing 
            // bracket is required bracket. 
            else if (expression.charAt(i) == ']') {
                st.pop();
                if (st.empty()) {
                    //System.out.print(expression + ", "
                      //      + index + ": " + i + "\n");
                    return i;
                }
            }
        }
  
        // If no matching closing bracket 
        // is found. 
        //System.out.print(expression + ", "
          //      + index + ": -1\n");
        return i;
    }
}//String x ="[[Youssef ^ Eyad] V [Ahmed ^ Mona] V [chks ^ chksos]] V [kotb ^ body]";
/*String[] h1 = h.split("then");
System.out.println(h1[0]);
h1[1]=h1[1].substring(1);
System.out.println(h1[1]);
//String x1 ="Youssef ^ Eyad";
//System.out.println(test(x,0));
/*int index = test(x,0);
int length = x.length();
String x1= x.substring(1,index);
String x2= x.substring(index+5,length-1);
String x3 = x.substring(index+1,index+3);
System.out.print(x1+"	");
System.out.print(x3+"	");
System.out.print(x2+"	");
System.out.println();
int index2 = test(x1,0);
int length2 = x1.length();
String x_1= x1.substring(1,index2);
String x_2= x1.substring(index2+4,length2);
String x_3 = x1.substring(index2+1,index2+3);
System.out.print(x_1+"	");
System.out.print(x_3+"	");
System.out.print(x_2+"	");
String h = "Hamoda then chks";*/
