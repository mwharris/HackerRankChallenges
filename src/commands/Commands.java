package commands;

public class Commands {

	public static void main(String[] args) {
		String[] command1 = {"G"};
		String[] expected1 = {"NO"};
		
		String[] command2 = {"L"};
		String[] expected2 = {"YES"};
		
		String[] command3 = {"R"};
		String[] expected3 = {"YES"};
		
		String[] command4 = {"G", "L"};
		String[] expected4 = {"NO", "YES"};
		
		String[] command5 = {"GL"};
		String[] expected5 = {"YES"};
		
		String[] command6 = {"GRGL"};
		String[] expected6 = {"NO"};
		
		boolean test1 = isCorrect(command1, expected1);
		boolean test2 = isCorrect(command2, expected2);
		boolean test3 = isCorrect(command3, expected3);
		boolean test4 = isCorrect(command4, expected4);
		boolean test5 = isCorrect(command5, expected5);
		boolean test6 = isCorrect(command6, expected6);
		
		System.out.println("Test 1: " + test1);
		System.out.println("Test 2: " + test2);
		System.out.println("Test 3: " + test3);
		System.out.println("Test 4: " + test4);
		System.out.println("Test 5: " + test5);
		System.out.println("Test 6: " + test6);
	}
	
	private static boolean isCorrect(String[] commands, String[] expected) {
		String[] results = doesFormCircle(commands);
		
		for (int i = 0; i < results.length; i++) {
			if (results[i] != expected[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static String[] doesFormCircle(String[] commands) {
		String[] ret = new String[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			if (processCommand(commands[i])) {
				ret[i] = "YES";
			} else {
				ret[i] = "NO";
			}
		}
		
		return ret;
	}

	private static boolean processCommand(String command) {
		if (command.equals("G")) {
			return false;
		}
		else if (command.equals("L")) {
			return true;
		}
		else if (command.equals("R")) {
			return false;
		}
		
		int x = 0;
		int y = 0;
		int dirX = 0;
		int dirY = 1;
		int runs = 0;
		while (runs < 4) {
			for (int i = 0; i < command.length(); i++) {
				if (command.charAt(i) == 'G') {
					moveForward(x, y, dirX, dirY);
				}
				else if (command.charAt(i) == 'L') {
					rotateLeft();
				}
				else if (command.charAt(i) == 'R') {
					rotateRight();
				}
			}
			
			runs++;
		}
	}
	
	private static void moveForward(int x, int y, int dirX, int dirY) {
		x += dirX;
		y += dirY;
	}
	
	private static void rotateLeft(int dirX, int dirY) {
		
	}
	
	private static void rotateRight() {
		
	}
}
