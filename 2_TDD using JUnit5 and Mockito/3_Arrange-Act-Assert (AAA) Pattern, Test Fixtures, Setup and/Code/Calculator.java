public class Calculator {
	public int add(int a,int b)
	{
		return a+b;
	}
	public int sub(int a,int b)
	{
		return a-b;
	}
	public int mul(int a,int b)
	{
		return a*b;
	}
    public int div(int a,int b)
    {
    	if(a==0 || b==0)
    	{
    		System.out.println("Cannot divide a number by 0 - division error");    	
    	}
    	return a/b;
     }
  }