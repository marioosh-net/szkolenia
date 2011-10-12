package myself;

import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Zad2 {
	private int x;
	private Integer[] list;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		list = new Integer[x];
	}

	public Integer[] getList() {
		return list;
	}
	
	public void setList(Integer[] list) {
		this.list = list;
	}
	
	public String sortuj() {
		Arrays.sort(list);
		return "zad2c";
	}
}
