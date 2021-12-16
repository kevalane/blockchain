package blockchain;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		try {
			Miner miner = new Miner("thisIsAHeader", 6);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
