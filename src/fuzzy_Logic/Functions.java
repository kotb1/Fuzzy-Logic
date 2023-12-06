package fuzzy_Logic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Stack;

public class Functions {
	public ArrayList<Sets> project_funding = new ArrayList<Sets>();
	public ArrayList<Sets> team_experience_level = new ArrayList<Sets>();
	public ArrayList<Sets> risk = new ArrayList<Sets>();
	
	public void Fuzzification(int projectfunding,int teamexperiencelevel) 
	{
		for(int i =0;i<project_funding.size();i++) 
		{
			for(int j=0;j<project_funding.get(i).set.size();j++) 
			{
				if(project_funding.get(i).set.get(j)== projectfunding) 
				{
					if(j==0 || j==3) 
					{
						project_funding.get(i).u=0;
					}
					else if(j==1 || j==2) 
					{
						project_funding.get(i).u=1;
					}
				}
			}
			if(project_funding.get(i).u == -1 && projectfunding<project_funding.get(i).set.get(3) && projectfunding>project_funding.get(i).set.get(0)) 
			{
				int x1 =-1;
				int x2=-1;
				int y1=-1;
				int y2=-1;
				for(int o =0;o<project_funding.get(i).set.size()-1;o++) 
				{
					if(project_funding.get(i).set.get(o)<projectfunding && project_funding.get(i).set.get(o+1)>projectfunding) 
					{
						x1 = project_funding.get(i).set.get(o);
						if(o==0) 
						{
							y1=0;
						}
						else if(o==1 || o==2) 
						{
							y1=1;
						}
						int e=o+1;
						x2= project_funding.get(i).set.get(o+1);
						if(e==3) 
						{
							y2=0;
						}
						else if(e==1 || e==2) 
						{
							y2=1;
						}
					}
				}
				//System.out.println("("+x1+","+y1+")"+"	"+"("+x2+","+y2+")");
				float delta_y=y2-y1;
				float delta_x=x2-x1;
				float slope = delta_y/delta_x;
				//System.out.println(slope);
				float constant = y1-(slope*x1);
				//System.out.println(constant);
				project_funding.get(i).u=(slope*projectfunding)+constant;
			}
		}
		for(int i =0;i<team_experience_level.size();i++) 
		{
			for(int j=0;j<team_experience_level.get(i).set.size();j++) 
			{
				if(team_experience_level.get(i).set.get(j)== teamexperiencelevel) 
				{
					if(j==0 || j==2) 
					{
						team_experience_level.get(i).u=0;
					}
					else if(j==1) 
					{
						team_experience_level.get(i).u=1;
					}
				}
			}
			if(team_experience_level.get(i).u == -1 && teamexperiencelevel<team_experience_level.get(i).set.get(2) && teamexperiencelevel>team_experience_level.get(i).set.get(0)) 
			{
				int x1 =-1;
				int x2=-1;
				int y1=-1;
				int y2=-1;
				for(int o =0;o<team_experience_level.get(i).set.size()-1;o++) 
				{
					if(team_experience_level.get(i).set.get(o)<teamexperiencelevel && team_experience_level.get(i).set.get(o+1)>teamexperiencelevel) 
					{
						x1 = team_experience_level.get(i).set.get(o);
						if(o==0) 
						{
							y1=0;
						}
						else if(o==1) 
						{
							y1=1;
						}
						int e=o+1;
						x2= team_experience_level.get(i).set.get(o+1);
						if(e==2) 
						{
							y2=0;
						}
						else if(e==1) 
						{
							y2=1;
						}
					}
				}
				//System.out.println("("+x1+","+y1+")"+"	"+"("+x2+","+y2+")");
				float delta_y=y2-y1;
				float delta_x=x2-x1;
				float slope = delta_y/delta_x;
				//System.out.println(slope);
				float constant = y1-(slope*x1);
				//System.out.println(constant);
				team_experience_level.get(i).u=(slope*teamexperiencelevel)+constant;
			}
		}
	}
	public void Inference()
	{
		risk.get(0).u=Math.max(project_funding.get(3).u, team_experience_level.get(2).u);
		risk.get(1).u=Math.max(Math.min(project_funding.get(2).u,team_experience_level.get(1).u),team_experience_level.get(0).u);
		risk.get(2).u=Math.max(project_funding.get(0).u, Math.min(project_funding.get(1).u,team_experience_level.get(0).u));
		for(int i =0;i<risk.size();i++) 
		{
			if(risk.get(i).u == -1) 
			{
				risk.get(i).u =0;
			}
		}
		/*risk.get(0).u=(float) 0.33333337;
		risk.get(1).u=(float) 0.33333325;
		risk.get(2).u= -1;
		risk.get(3).u=-1;*/
	}
	public float Defuzzification() 
	{
		risk.get(0).u=(float) 0.33333337;
		System.out.println(risk.get(0).u);
		System.out.println(risk.get(1).u);
		System.out.println(risk.get(2).u);
		float result;
		ArrayList <Float> factors = new ArrayList <Float>();
		for(int i =0;i<risk.size();i++) 
		{
			float avg = 0;
			for(int j =0;j<risk.get(i).set.size();j++) 
			{
				avg += risk.get(i).set.get(j); 
			}
			avg=avg/3;
			factors.add(avg);
		}
		float sum_numerator=0;
		float sum_denominator =0;
		for(int y=0;y<risk.size();y++) 
		{
			sum_numerator+=risk.get(y).u * factors.get(y);
			sum_denominator+=risk.get(y).u;
		}
		result=sum_numerator/sum_denominator;
		result=(float) roundAvoid(result,1);
		ArrayList <Sets> best = new ArrayList <Sets>(); 
		for(int i =0;i<risk.size();i++) 
		{
			for(int j=0;j<risk.get(i).set.size()-1;j++) 
			{
				if(risk.get(i).set.get(j)<result && risk.get(i).set.get(j+1)>result) 
				{
					best.add(risk.get(i));
				}
			}
		}
		float max=-1;
		int index=-1;
		for(int i =best.size()-1;i>-1;i--) 
		{
			int x1 =-1;
			int x2=-1;
			int y1=-1;
			int y2=-1;
			for(int j =0;j<best.get(i).set.size();j++) 
			{
				if(best.get(i).set.get(j)<result && best.get(i).set.get(j+1)>result) 
				{
					x1 = best.get(i).set.get(j);
					if(j==0) 
					{
						y1=0;
					}
					else if(j==1) 
					{
						y1=1;
					}
					int e=j+1;
					x2= best.get(i).set.get(j+1);
					if(e==2) 
					{
						y2=0;
					}
					else if(e==1) 
					{
						y2=1;
					}
				}
			}
		//System.out.println("("+x1+","+y1+")"+"	"+"("+x2+","+y2+")");
		float delta_y=y2-y1;
		float delta_x=x2-x1;
		float slope = delta_y/delta_x;
		//System.out.println(slope);
		float constant = y1-(slope*x1);
		//System.out.println(constant);
		float y =(slope*result)+constant;
		//System.out.println(y);
		if(max<y) 
		{
			max=y;
			index =i;
		}
		}
		//System.out.println(best.get(index).name);
		return result;
	}
	
	public  double roundAvoid(double value, int places) {
	    double scale = Math.pow(10, places);
	    return Math.round(value * scale) / scale;
	}
	public void Inference2(ArrayList <String> s) 
	{
		ArrayList <String>s1 = new ArrayList <String>();
		ArrayList <String>s2 = new ArrayList <String>();
		for(int i=0;i<s.size();i++) 
		{
			String[] h1 = s.get(i).split("then");
			h1[1]=h1[1].substring(1);
			s1.add(h1[0]);
			s2.add(h1[1]);
		}
		for(int i =0;i<s1.size();i++) 
		{
			System.out.println(s1.get(i));
		}
		for(int i =0;i<s2.size();i++) 
		{
			System.out.println(s2.get(i));
		}
		for(int i =0;i<s1.size();i++) 
		{
			float result=kk(s1.get(i));
			System.out.println(result);
			if(s2.get(i).contains("low")) 
			{
				risk.get(0).u=result;
			}
			else if(s2.get(i).contains("normal")) 
			{
				risk.get(1).u=result;	
			}
			else if(s2.get(i).contains("high")) 
			{
				risk.get(2).u=result;
			}
		}
		for(int i =0;i<risk.size();i++) 
		{
			if(risk.get(i).u == -1) 
			{
				risk.get(i).u =0;
			}
		}
	}
	
	public float kk(String r) 
	{
		float result = -1;
		if(r.charAt(0) =='[') 
		{
			int index = test(r,0);
			int length = r.length();
			String x1= r.substring(1,index);
			String x2= r.substring(index+5,length-1);
			if(x2.contains("]") && (x2.contains("V") || x2.contains("^"))) 
			{
				char ch1='[';
				char ch2=']';
				x2=ch1+x2+ch2;
				System.out.println(x2);
			}
			else 
			{
				x2=x2.substring(0,x2.length()-1);
				System.out.println(x2);
			}
			String x3 = r.substring(index+1,index+3);
			if(x3.contains("V")) 
			{
				result=Math.max(kk(x1),kk(x2));
			}
			else if(x3.contains("^")) 
			{
				result=Math.min(kk(x1),kk(x2));
			}
		}
		else if(r.contains("V")) 
		{
			int index=r.indexOf("V");
			String r1=r.substring(0, index);
			String r2=r.substring(index+2,r.length());
			ArrayList <String> s = new ArrayList <String>();
			s.add(r1);
			s.add(r2);
			ArrayList <Float> i = new ArrayList <Float>();
			float num1=-1;
			for(int i1 =0;i1<s.size();i1++) 
			{
				if(s.get(i1).contains("project_funding")) 
				{
					if(s.get(i1).contains("very low")) 
					{
						num1=project_funding.get(0).u;
					}
					else if(s.get(i1).contains("low")) 
					{
						num1=project_funding.get(1).u;
					}
					else if(s.get(i1).contains("medium")) 
					{
						num1=project_funding.get(2).u;
					}
					else if(s.get(i1).contains("high")) 
					{
						num1=project_funding.get(3).u;
					}
					i.add(num1);
				}
				else if(s.get(i1).contains("team_experience_level"))
				{
					if(s.get(i1).contains("beginner")) 
					{
						num1=team_experience_level.get(0).u;
					}
					else if(s.get(i1).contains("intermediate")) 
					{
						num1 =team_experience_level.get(1).u;
					}
					else if(s.get(i1).contains("expert")) 
					{
						num1=team_experience_level.get(2).u;
					}
				}
				i.add(num1);
			}
			result = Math.max(i.get(0), i.get(1));
		}
		else if(r.contains("^")) 
		{
			int index=r.indexOf("^");
			String r1=r.substring(0, index);
			String r2=r.substring(index+2,r.length());
			ArrayList <String> s = new ArrayList <String>();
			s.add(r1);
			s.add(r2);
			ArrayList <Float> i = new ArrayList <Float>();
			float num1=-1;
			for(int i1 =0;i1<s.size();i1++) 
			{
				if(s.get(i1).contains("project_funding")) 
				{
					if(s.get(i1).contains("very low")) 
					{
						num1=project_funding.get(0).u;
					}
					else if(s.get(i1).contains("low")) 
					{
						num1=project_funding.get(1).u;
					}
					else if(s.get(i1).contains("medium")) 
					{
						num1=project_funding.get(2).u;
					}
					else if(s.get(i1).contains("high")) 
					{
						num1=project_funding.get(3).u;
					}
					i.add(num1);
				}
				else if(s.get(i1).contains("team_experience_level"))
				{
					if(s.get(i1).contains("beginner")) 
					{
						num1=team_experience_level.get(0).u;
					}
					else if(s.get(i1).contains("intermediate")) 
					{
						num1 =team_experience_level.get(1).u;
					}
					else if(s.get(i1).contains("expert")) 
					{
						num1=team_experience_level.get(2).u;
					}
				}
				i.add(num1);
			}
			result = Math.min(i.get(0), i.get(1));
		}
		else 
		{
			float num1=-1;
			if(r.contains("project_funding")) 
			{
				if(r.contains("very low")) 
				{
					num1=project_funding.get(0).u;
				}
				else if(r.contains("low")) 
				{
					num1=project_funding.get(1).u;
				}
				else if(r.contains("medium")) 
				{
					num1=project_funding.get(2).u;
				}
				else if(r.contains("high")) 
				{
					num1=project_funding.get(3).u;
				}
			}
			else if(r.contains("team_experience_level"))
			{
				if(r.contains("beginner")) 
				{
					num1=team_experience_level.get(0).u;
				}
				else if(r.contains("intermediate")) 
				{
					num1=team_experience_level.get(1).u;
				}
				else if(r.contains("expert")) 
				{
					num1=team_experience_level.get(2).u;
				}
			}
			result =num1;
		}
		return result;
	}
	static int test(String expression, int index) {
        int i=-1;
        if (expression.charAt(index) != '[') {
            return i;
        }
        Stack<Integer> st = new Stack<>();
        for (i = index; i < expression.length(); i++) { 
            if (expression.charAt(i) == '[') {
                st.push((int) expression.charAt(i));
            }
            else if (expression.charAt(i) == ']') {
                st.pop();
                if (st.empty()) {
                    return i;
                }
            }
        }
        return i;
    }
	
	
	
	
	Functions()
	{
		ArrayList<Integer> Set1_Fund = new ArrayList<Integer>();
		Set1_Fund.add(0);
		Set1_Fund.add(0);
		Set1_Fund.add(10);
		Set1_Fund.add(30);
		Sets verylow = new Sets("VeryLow",Set1_Fund,-1);
		ArrayList<Integer> Set2_Fund = new ArrayList<Integer>();
		Set2_Fund.add(10);
		Set2_Fund.add(30);
		Set2_Fund.add(40);
		Set2_Fund.add(60);
		Sets low = new Sets("Low",Set2_Fund,-1);
		ArrayList<Integer> Set3_Fund = new ArrayList<Integer>();
		Set3_Fund.add(40);
		Set3_Fund.add(60);
		Set3_Fund.add(70);
		Set3_Fund.add(90);
		Sets medium = new Sets("Medium",Set3_Fund,-1);
		ArrayList<Integer> Set4_Fund = new ArrayList<Integer>();
		Set4_Fund.add(70);
		Set4_Fund.add(90);
		Set4_Fund.add(100);
		Set4_Fund.add(100);
		Sets high = new Sets("High",Set4_Fund,-1);
		project_funding.add(verylow);
		project_funding.add(low);
		project_funding.add(medium);
		project_funding.add(high);
		ArrayList<Integer> Set1_Exp = new ArrayList<Integer>();
		Set1_Exp.add(0);
		Set1_Exp.add(15);
		Set1_Exp.add(30);
		Sets beginner = new Sets ("Beginner",Set1_Exp,-1);
		ArrayList<Integer> Set2_Exp = new ArrayList<Integer>();
		Set2_Exp.add(15);
		Set2_Exp.add(30);
		Set2_Exp.add(45);
		Sets intermediate = new Sets ("Intermediate",Set2_Exp,-1);
		ArrayList<Integer> Set3_Exp = new ArrayList<Integer>();
		Set3_Exp.add(30);
		Set3_Exp.add(60);
		Set3_Exp.add(60);
		Sets expert = new Sets ("Expert",Set3_Exp,-1);
		team_experience_level.add(beginner);
		team_experience_level.add(intermediate);
		team_experience_level.add(expert);
		ArrayList<Integer> Set1_risk = new ArrayList<Integer>();
		Set1_risk.add(0);
		Set1_risk.add(25);
		Set1_risk.add(50);
		Sets low_risk = new Sets("Low",Set1_risk,-1);
		ArrayList<Integer> Set2_risk = new ArrayList<Integer>();
		Set2_risk.add(25);
		Set2_risk.add(50);
		Set2_risk.add(75);
		Sets normal_risk = new Sets("Normal",Set2_risk,-1);
		ArrayList<Integer> Set3_risk = new ArrayList<Integer>();
		Set3_risk.add(50);
		Set3_risk.add(100);
		Set3_risk.add(100);
		Sets high_risk = new Sets("High",Set3_risk,-1);
		risk.add(low_risk);
		risk.add(normal_risk);
		risk.add(high_risk);
	}

}













//System.out.println(o +":");
//System.out.println(project_funding.get(h).set.get(o));
//System.out.println(project_funding.get(h).set.get(o+1));
//System.out.println(projectfunding);

//System.out.println(o +":");
//System.out.println(project_funding.get(h).set.get(o));
//System.out.println(project_funding.get(h).set.get(o+1));
//System.out.println(projectfunding);
/*for(int i =0;i<best.size();i++) 
{
	System.out.println(best.get(i).name);
	for(int j=0;j<risk.get(i).set.size();j++) 
	{
		System.out.print(risk.get(i).set.get(j)+"	");
	}
	System.out.println();
}*/
/*int best1 =100000000;
int best2=0;
for(int k=0;k<risk.size();k++) 
{
	for(int j=0;j<risk.get(k).set.size()-1;j++) 
	{
		if(result<risk.get(k).set.get(j+1) && result>risk.get(k).set.get(j)) 
		{
			best2 = risk.get(k).set.get(j+1);
		}
		best1 = best(best1,best2,result);
	}
}
for(int l=0;l<risk.size();l++) 
{
	for(int j=0;j<risk.get(l).set.size();j++) 
	{
		if(best1 == risk.get(l).set.get(j)) 
		{
			if(j==0 || j==2) 
			{
				System.out.println(risk.get(l).name);
			}
		}
	}
}*/
/*public int best(int num1,int num2,float key) 
{
	int k=-1;
	float res1=num1-key;
	float res2=num2-key;
	if(res1>res2) 
	{
		k=num2;
	}
	else 
	{
		k=num1;
	}
	return k;
}*/
