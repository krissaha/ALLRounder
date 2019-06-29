package eXcel_Read_Right;
public class TwoDArray {

	public static void main(String[] args) {
		Object ob[][] = new Object[3][5];

		ob[0][0] = 'A';
		ob[0][1] = 'B';
		ob[0][2] = 'C';
		ob[0][3] = 'D';
		ob[0][4] = 'E';

		ob[1][0] = "A1";
		ob[1][1] = "B1";
		ob[1][2] = "C1";
		ob[1][3] = "D1";
		ob[1][4] = "E1";

		ob[2][0] = "A2";
		ob[2][1] = "B2";
		ob[2][2] = "C2";
		ob[2][3] = "D2";
		ob[2][4] = "E2";

		for (int row = 0; row < ob.length; row++) {
			for (int col = 0; col < ob[0].length; col++) {
				System.out.println(ob[row][col]);
			}

		}

	}

}
