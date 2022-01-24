import java.util.Scanner;
public class LuckyNumber {

	public static int total=0; 	//total guess
	public static int gamecnt=0;	//total games
	public static int mincnt;  	//best game

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String regame;	//Player answers about replaying

		//Give plays, continue playing when answers yes/y(dontcareCapslock)
		do {
			play(input);
			System.out.print("Bạn có muốn tiếp tục chơi không?");
			regame=input.next();
		}while((regame.equalsIgnoreCase("yes"))||(regame.equalsIgnoreCase("Y")));

		//Print the result of the game when stop playing
		report();

	}

	//execute the game
	public static void play(Scanner input) {
		//create random luckynum
		double ran=Math.random()*100;
		int Num= (int) ran;

		System.out.println("Tôi đang nghĩ một số trong khoảng từ 0 đến 100...");
		//System.out.println(Num);

		boolean lucky = false; //guess right/wrong
		int cnt=0; //count guesses

		do {
			System.out.print("Bạn đoán? ");
			int n=input.nextInt(); //the number the player guessed
			cnt++;

			//Check the difference to give the right message to the players
			if(n>Num) {
				System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
			}else if(n<Num) {
				System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
			}else {
				System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau "+cnt+" lần dự đoán!");
				lucky=true;
			}
		}while(lucky==false);

		//save values after playing is done
		total+=cnt;
		gamecnt++;
		//get bestgame
		if(gamecnt==1) {mincnt=cnt;}
		else {mincnt=Math.min(mincnt, cnt);}
	}

	//display the report
	public static void report() {
		double avg=(double) total/ (double) gamecnt; //guess avg
		System.out.println("Kết quả tổng quát của trò chơi:");
		System.out.println("Tổng số lần chơi = "+gamecnt);
		System.out.println("Tổng số lần dự đoán = "+total);
		System.out.println("Số lần dự đoán trung bình mỗi lượt = "+(double)Math.round(avg*10)/10 );
		System.out.println("Số lần dự đoán ít nhất = "+mincnt);

	}




}
