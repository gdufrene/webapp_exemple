package ex1;

import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	private List<String> elements = new ArrayList<>();
	
	
	public DAO() {
		for (int i = 0; i < 10; i++) {
			elements.add("element " + i);
		}
	}
	
	public String findById(int i) {
		return elements.get(i);
	}
	
	public List<String> findAll() {
		return new ArrayList<>( elements );
	}

}
