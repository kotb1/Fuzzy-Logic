package fuzzy_Logic;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner x =new Scanner(System.in);
		Functions f = new Functions();
		System.out.println("Please Enter number of Variables");
		int var = Integer.parseInt(x.nextLine());
		System.out.println("Please Enter Project Fund");
		int Project_Fund = Integer.parseInt(x.nextLine());
		System.out.println("Please Enter Experience level");
		int Experience_level = Integer.parseInt(x.nextLine());
		f.Fuzzification(Project_Fund, Experience_level);
		System.out.println("Do u want the default Inference Rules??");
		String choice =x.nextLine();
		if(choice.equals("Yes")) 
		{
			f.Inference();
			System.out.println(f.Defuzzification());
		}
		else 
		{
			ArrayList<String> rules = new ArrayList<String>();
			boolean x2 =true;
			while(x2==true) 
			{
				System.out.println("Write OR Quit");
				String choice2 =x.nextLine();
				if(choice2.equals("Quit")) 
				{
					x2=false;
				}
				else 
				{
					rules.add(choice2);
				}
			}
			f.Inference2(rules);
			System.out.println(f.Defuzzification());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*for(int i=0;i<f.project_funding.size();i++) 
		{
			System.out.println(f.project_funding.get(i).u);
		}
		for(int i=0;i<f.team_experience_level.size();i++) 
		{
			System.out.println(f.team_experience_level.get(i).u);
		}*/
		/*for(int i =0;i<f.project_funding.size();i++) 
		{
			//for(int j =0;j<f.project_funding.get(i).set.size();j++) 
			//{
				System.out.print(f.project_funding.get(i).name+ "	"+f.project_funding.get(i).u);
			//}
			System.out.println();
		}
		for(int i =0;i<f.team_experience_level.size();i++) 
		{
			//for(int j =0;j<f.project_funding.get(i).set.size();j++) 
			//{
				System.out.print(f.team_experience_level.get(i).name+ "	"+f.team_experience_level.get(i).u);
			//}
			System.out.println();
		}*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*for(int i=0;i<f.project_funding.size();i++) 
		{
			System.out.println(f.project_funding.get(i));
		}
		for(int i=0;i<f.team_experience_level.size();i++) 
		{
			System.out.println(f.team_experience_level.get(i));
		}
		for(int i=0;i<f.risk.size();i++) 
		{
			System.out.println(f.risk.get(i));
		}*/
	}

}
