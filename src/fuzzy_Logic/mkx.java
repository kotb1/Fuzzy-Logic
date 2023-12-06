package fuzzy_Logic;

public class mkx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		long start2 = System.nanoTime();
		//System.out.println(System.nanoTime());
		int [] x= {10,22,34,43,8,9,5,4,90,12,32,44,65,56,49,14,69,96,35,18,79,97,100,60,31,103,450,88,109,150,53,11};
		int [] y= {10,34,44,77,99,102,48,42,31,60,69,4,106,114,132,91};
		for(int i = 0;i<524288;i++)
		{
			for(int j =0;j<1048576;j++) 
			{
				//if(y[i] == x[j]) {
					//System.out.println("dazzz");
				//}
			}
		}
		long end = System.currentTimeMillis();
		long end2 = System.nanoTime();
		//System.out.println(System.nanoTime());
		//System.out.println(start);
		System.out.println(end-start);
		System.out.println(end2-start2);
			

	}

}
