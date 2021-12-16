package blockchain;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < 100; i++) {
				Hash hash = new Hash(String.valueOf(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
