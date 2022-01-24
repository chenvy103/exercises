import java.util.Scanner;
public class GradeStudent {
	public static int[] W=new int[3];	//weight0-100
	public static int totalW=100;		//total weight==100
	public static int S;   			//score
	public static int Smax=100;		//max score
	public static int plus;			//extra points
	public static double[] WS=new double[3];//weighted score

	public static void main(String[] args) {
		begin();
		Scanner input = new Scanner(System.in);
		midTerm(input);
		finalTerm(input);
		homework(input);
		report();
	}

	//Show welcome message
	public static void begin() {
		System.out.println("This program reads exam/homework scores and reports your overall course grade");
	}

	//Enter & calculate midterm exam scores
	public static void midTerm(Scanner input) {
		System.out.println("Midterm:");

		Weight(input, W, 0);
		Score(input);
		ans(input);
		Total();
		WeightedScore(WS,0,W);

		System.out.println();
	}

	//Enter & cal finalterm exam scores
	public static void finalTerm(Scanner input) {
		System.out.println("Final:");

		Weight(input, W ,1);
		Score(input);
		ans(input);
		Total();
		WeightedScore(WS,1,W);

		System.out.println();
	}

	//Enter & cal homework scores
	public static void homework(Scanner input) {
		System.out.println("Homework:");

		do {Weight(input, W ,2);}while(totalW!=0); //Enter until total weighted score = exactly 100

		System.out.print("Number of assignments? ");
		int numAsm=input.nextInt();

		int[] asmS= new int[numAsm]; //asm score
		int[] asmM = new int[numAsm];//asm maxscore

		//reset value
		S=0;
		Smax=0;

		for(int i=0;i<numAsm;i++) {
			do {
				System.out.print("Assignment "+(i+1)+" score and max? ");
				asmS[i]=input.nextInt();
				asmM[i]=input.nextInt();
			}while(asmS[i]>asmM[i]);

			S+=asmS[i]; 	//total asm score
			Smax+=asmM[i];	//total asm maxscore
		}

		//max score of Asm section = 150
		if (Smax>150) {
			Smax=150;
			S=S/Smax*150;//change score values proportionally (Ex 120/180: totalmaxcore180=>150; totalscore120=>100)
		}

		System.out.print("How many sections did you attend? ");
		int attend=input.nextInt();

		plus=attend*5;
		if(plus>30) {plus=30;}//maxscore for attendance part = 30
		Smax+=plus;

		System.out.println("Section points = "+plus+" / 30");

		Total();
		WeightedScore(WS,2,W);

		System.out.println();
	}

	//cal & display GPA result + corresponding cmt mess
	public static void report() {
		double overall=0.0; //total score achieved by students is calculated on a scale of 100
		for(int i=0; i<WS.length; i++) {overall+=WS[i];}

		System.out.println("Overall percentage = "+overall);
		System.out.println("Your grade will be at least: "+minGrade(overall));
		System.out.println("<< your custom grade messenger here >>");
	}


//Related submethods

	//enter& store weights
	public static int Weight(Scanner input, int[] w, int i) {
		do {
			System.out.print("Weight (0-100)? ");
			w[i] =input.nextInt();
		} while(w[i]<0||w[i]>totalW);
		totalW-=w[i];

		if(i==2&&totalW!=0) {totalW+=w[i];}
		return w[i];
	}

	//enter scores
	public static int Score(Scanner input) {
		System.out.print("Score earned? ");
		S=input.nextInt();
		return S;
	}

	//plus points or not?
	public static void ans(Scanner input) {
		int ans;
		do {
			System.out.print("Were scores shifted (1=yes, 2=no)? ");
			ans=input.nextInt();
		} while(ans!=1&&ans!=2);
		if (ans==1) {
			System.out.print("Shift amount? ");
			plus=input.nextInt();
		}else {plus=0;}
	}

	//Total points
	public static int Total() {
		S+=plus;
		if(S>Smax) {S=Smax;}
		System.out.println("Total points = "+S+" / "+Smax);
		return S;
	}

	//cal & store weighted scores
	public static double WeightedScore(double[] ws, int i,int[] w) {
		ws[i]=(double)S/Smax*w[i];
		ws[i]=(double)Math.round(ws[i]*10)/10;

		System.out.println("Weighted score = "+ws[i]+" / "+w[i]);
		return ws[i];
	}

	//minGrade(minGPA) can achieve
	public static double minGrade(double x) {
		if(x>=85.0) return 3.0;
		else if(x>=75.0) return 2.0;
		else if(x>=60.0) return 1.0;
		return 0.0;
	}
}
