package lab1;

public class Prog3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length<1){
			System.out.print("No input");
			lala
			lalala
			alalalalalal
		}
		else{
			int first = Integer.parseInt(args[0]);
			int life = iter_life_length(first);
			int life2 = rec_life_length(first);
			visual(first, life, life2);
		}
		
	}sdasdasd
	
	public static void visual(int x, int y, int z){
		String op;
		op="The life lenght of "+x+" is " + y;
		System.out.println(op);
		op="The recursive life length of " + x + " is " + z;
		System.out.println(op);
	}
sd
	
	public static int iter_life_length(int a){
		int fret=a;
		int count=0;
		while(fret!=1){
			fret=Prog1.f(fret);
			count = count +1;
		}
		
		return count;
	}
	
	public static int rec_life_length(int a){
		if(a==1){
			return 0;
		}
		else{
			return 1+rec_life_length(Prog1.f(a));
		}
	}

}
