package fuzzy_Logic;

import java.util.ArrayList;

public class Zarat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String keys []= {"or","and"};
		String chks = "If project_funding is high or team_experience_level is expert then risk is low.";
		String str = "If project_funding is medium AND team_experience_level is intermediate OR team_experience_level is beginner then risk is normal.";
		String findStr = "OR";
		String findStr2 = "AND";
		int count = chks(str);
		if(count==1) 
		{
			if(str.contains(findStr)) 
			{
				String[] x = str.split(findStr);
				System.out.println(x[0]);
				x[1]=x[1].substring(1);
				System.out.println(x[1]);
			}
			else 
			{
				String[] x = str.split(findStr2);
				System.out.println(x[0]);
				x[1]=x[1].substring(1);
				System.out.println(x[1]);
			}
		}
		else if(count == 2) 
		{
			int split= chks2(str);
			System.out.println(str.substring(0, split));
			if(str.substring(split).contains(findStr)) 
			{
				System.out.println(str.substring(split+3));
			}
			else
				System.out.println(str.substring(split+4));
			
		}*/
		/*String str2 = "If project_funding is medium and team_experience_level is intermediate or team_experience_level is beginner then risk is normal.";
		String findStr2 = "and";
		int lastIndex2 = 0;

		while (lastIndex2 != -1) {

		    lastIndex2 = str.indexOf(findStr2, lastIndex2);

		    if (lastIndex2 != -1) {
		        count++;
		        lastIndex2 += findStr.length();
		    }
		}*/
		//System.out.println(count);
		/*String x = "2012/5/6";
		int end = x.indexOf("/");
		System.out.println(x.substring(x.lastIndexOf("/") + 1));//6
		System.out.println(x.substring(end+1,x.lastIndexOf("/")));//5
		System.out.println(x.substring(0,end));//2012*/
		
		
		/*String s = "12.34";
		String [] input =new String[10];
		input = s.split(".");
		for(int i =0;i<input.length;i++) 
		{
			System.out.println(input[i]);
		}*/
		/*String str5 = "If project_funding is medium and team_experience_level is intermediate or team_experience_level is beginner then risk is normal.";
        String[] arrOfStr = str5.split("or");
        System.out.println(arrOfStr[0]);
        System.out.println(arrOfStr[1]);*/
        //for (String a : arrOfStr)
          //  System.out.println(a);
		//System.out.println(input[0]);
		//System.out.println(input[1]);
        /*int secondDotPosition = findSecondDotPosition(s,2);
        if (secondDotPosition > 0) {
            System.out.println(s.substring(0, secondDotPosition));
            System.out.println(s.substring(secondDotPosition+1));
        } else {
            System.out.printf("ERROR: there is not a 2nd dot in '%s'%n", s);
        }*/
		String str = "If project_funding is medium ^ team_experience_level is intermediate V team_experience_level is beginner ^ project_funding is very low.";
		System.out.println(chksos(str,calc(str)));
		//chksos(str,3);
		/*int k = 0;
		for (int i = 0; i < str.length(); i++)
		{
		  if (str.charAt(i) == 'V'|| str.charAt(i) == '^')
		  {
			 k++;
		  }
		  
		}
		//System.out.println(k);
		if(k==1) 
		{
			if(str.contains("V")) 
			{
				String [] x = str.split("V");
				x[1]=x[1].substring(1);
				System.out.println(x[0]);
				System.out.println(x[1]);
			}
			else 
			{
				String [] x = str.split("^");
				x[1]=x[1].substring(1);
				System.out.println(x[0]);
				System.out.println(x[1]);
			}
		}
		else if(k==2) 
		{
			int k1=0;
			String x1="";
			String x2="";
			for (int i = 0; i < str.length(); i++)
			{
			  if (str.charAt(i) == 'V'|| str.charAt(i) == '^')
			  {
			      
				 k1++;
			      if (k == 2)
			      {
			    	  if (str.charAt(i) == 'V') 
			    	  {
			    		  x1=str.substring(0,i);
			    		  x2=str.substring(i+2);
			    	  }
			    	  else 
			    	  {
			    		  x1=str.substring(0,i);
			    		  x2=str.substring(i+2);
			    	  }
			      }
			  }
			  
			}
			System.out.println(x1);
			System.out.println(x2);
		}*/
		
	}
	public static int calc(String str) 
	{
		int k = 0;
		for (int i = 0; i < str.length(); i++)
		{
		  if (str.charAt(i) == 'V'|| str.charAt(i) == '^')
		  {
			 k++;
		  }
		  
		}
		return k;
	}
	public static int chksos(String str, int k) 
	{
		int result=-1;
		if(k==0) 
		{
			int num1=-1;
			if(str.contains("project_funding")) 
			{
				if(str.contains("very low")) 
				{
					num1=50;
				}
				else if(str.contains("low")) 
				{
					num1=50;
				}
				else if(str.contains("medium")) 
				{
					num1=5;
				}
				else if(str.contains("high")) 
				{
					num1=50;
				}
			}
			else if(str.contains("team_experience_level"))
			{
				if(str.contains("beginner")) 
				{
					num1=30;
				}
				else if(str.contains("intermediate")) 
				{
					num1 =10;
				}
				else if(str.contains("expert")) 
				{
					num1=50;
				}
			}
			result=num1;
		}
		else if(k==1) 
		{
			if(str.contains("V")) 
			{
				ArrayList <Integer> s = new ArrayList <Integer>();
				int num1=-1;
				String[] x = new String[2];
				int index = str.lastIndexOf("^");
				x[0]=str.substring(0, index);
				x[1]=str.substring(index);
				x[1]=x[1].substring(2);
				for(int i=0;i<2;i++) 
				{
					if(x[i].contains("project_funding")) 
					{
						if(x[i].contains("very low")) 
						{
							num1=50;
						}
						else if(x[i].contains("low")) 
						{
							num1=50;
						}
						else if(x[i].contains("medium")) 
						{
							num1=5;
						}
						else if(x[i].contains("high")) 
						{
							num1=50;
						}
					}
					else if(x[i].contains("team_experience_level"))
					{
						if(x[i].contains("beginner")) 
						{
							num1=30;
						}
						else if(x[i].contains("intermediate")) 
						{
							num1 =10;
						}
						else if(x[i].contains("expert")) 
						{
							num1=50;
						}
					}
					s.add(num1);
				}
				result= Math.max(s.get(0), s.get(1));
			}
			else if(str.contains("^")) 
			{
				String[] x = new String[2];
				int index = str.lastIndexOf("^");
				x[0]=str.substring(0, index);
				x[1]=str.substring(index);
				//System.out.println(index);
				x[1]=x[1].substring(2);
				//System.out.println(x[0]);
				//System.out.println(x[1]);
				ArrayList <Integer> s = new ArrayList <Integer>();
				int num1=-1;
				for(int i=0;i<2;i++) 
				{
					if(x[i].contains("project_funding")) 
					{
						if(x[i].contains("very low")) 
						{
							num1=50;
						}
						else if(x[i].contains("low")) 
						{
							num1=5;
						}
						else if(x[i].contains("medium")) 
						{
							num1=5;
						}
						else if(x[i].contains("high")) 
						{
							num1=5;
						}
					}
					else
					{
						if(x[i].contains("beginner")) 
						{
							num1=30;
						}
						else if(x[i].contains("intermediate")) 
						{
							num1 =10;
						}
						else if(x[i].contains("expert")) 
						{
							num1=5;
						}
					}
					s.add(num1);
				}
				result= Math.min(s.get(0), s.get(1));
			}
		}
		else if(k==2) 
		{
			int k1=0;
			String x1="";
			String x2="";
			for (int i = 0; i < str.length(); i++)
			{
			  if (str.charAt(i) == 'V'|| str.charAt(i) == '^')
			  {
			      
				 k1++;
			      if (k1 == 2)
			      {
			    	  if (str.charAt(i) == 'V') 
			    	  {
			    		  x1=str.substring(0,i);
			    		  x2=str.substring(i+2);
			    		  //System.out.println(x1);
			    		  //System.out.println(x2);
			    		  //System.out.println(calc(x1));
			    		  //System.out.println(calc(x2));
			    		  result=Math.max(chksos(x1,calc(x1)),chksos(x2,calc(x2)));
			    	  }
			    	  else if (str.charAt(i) == '^') 
			    	  {
			    		  x1=str.substring(0,i);
			    		  x2=str.substring(i+2);
			    		  result=Math.min(chksos(x1,calc(x1)),chksos(x2,calc(x2)));
			    	  }
			      }
			  }
			  
			}
		}
		else if(k>2) 
		{
			float k3=(float) Math.ceil(1.5);
			//System.out.println(k3+"		"+k);
			int k1=0;
			String x1="";
			String x2="";
			for (int i = 0; i < str.length(); i++)
			{
			  if (str.charAt(i) == 'V'|| str.charAt(i) == '^')
			  {
			      
				 k1++;
			      if (k1 == k3)
			      {
			    	  if (str.charAt(i) == 'V') 
			    	  {
			    		  x1=str.substring(0,i);
			    		  x2=str.substring(i+2);
			    		  //System.out.println(x1);
			    		  //System.out.println(x2);
			    		  //System.out.println(calc(x1));
			    		  //System.out.println(calc(x2));
			    		  result=Math.max(chksos(x1,calc(x1)),chksos(x2,calc(x2)));
			    	  }
			    	  else if (str.charAt(i) == '^') 
			    	  {
			    		  x1=str.substring(0,i);
			    		  x2=str.substring(i+2);
			    		  result=Math.min(chksos(x1,calc(x1)),chksos(x2,calc(x2)));
			    	  }
			      }
			  }
			  
			}
		}
		return result;
	}
	
	public static  double roundAvoid(int value, int places) {
	    double scale = Math.pow(10, places);
	    return Math.round(value * scale) / scale;
	}
	public static int chks(String str) 
	{
		String findStr = "OR";
		String findStr2 = "AND";
		int lastIndex = 0;
		int lastIndex1 = 0;
		int lastIndex2 = 0;
		int count = 0;

		while (lastIndex1 != -1 && lastIndex2 !=-1) {

		    lastIndex1 = str.indexOf(findStr, lastIndex1);//2wel or
		    //System.out.println("1: "+lastIndex1);
		    lastIndex2 = str.indexOf(findStr2, lastIndex2);//2wel and
		    //System.out.println("2: "+lastIndex2);
		    if(lastIndex1 !=-1) 
		    {

			    if(lastIndex1<lastIndex2 || lastIndex1 !=-1 || lastIndex2 !=-1) 
			    {
			    	lastIndex=lastIndex1;
			    }
			    else
			    	lastIndex=lastIndex2;
		    }
		    else
		    	lastIndex=lastIndex2;
		    //System.out.println(lastIndex);
		    if (lastIndex != -1) {
		        count++;
		        if(lastIndex == lastIndex1) 
		        {
		        	lastIndex1 += findStr.length();
		        }
		        else
		        	lastIndex2 += findStr2.length();
		        
		    }
		}
		return count;
	}
	public static int chks2(String str) 
	{
		String findStr = "OR";
		String findStr2 = "AND";
		int lastIndex = 0;
		int lastIndex1 = 0;
		int lastIndex2 = 0;
		int count = 0;
		int result=-1;

		while (lastIndex1 != -1 && lastIndex2 !=-1) {

		    lastIndex1 = str.indexOf(findStr, lastIndex1);//2wel or
		    //System.out.println("1: "+lastIndex1);
		    lastIndex2 = str.indexOf(findStr2, lastIndex2);//2wel and
		    //System.out.println("2: "+lastIndex2);
		    if(lastIndex1 !=-1) 
		    {

			    if(lastIndex1<lastIndex2 || lastIndex1 !=-1 || lastIndex2 !=-1) 
			    {
			    	lastIndex=lastIndex1;
			    }
			    else
			    	lastIndex=lastIndex2;
		    }
		    else
		    	lastIndex=lastIndex2;
		    //System.out.println(lastIndex);
		    if (lastIndex != -1) {
		        count++;
		        if(count==1) 
		        {
		        	result=lastIndex;
		        }
		        if(lastIndex == lastIndex1) 
		        {
		        	lastIndex1 += findStr.length();
		        }
		        else
		        	lastIndex2 += findStr2.length();
		        
		    }
		}
		return result;
	}

}
