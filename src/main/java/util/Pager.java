package util;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装分页的页数据类
 * @author 吊车尾
 *
 */
public class Pager<T> extends ArrayList<T>{
	private List<T> date;
	private int total;//总页数
	public List<T> getDate() {
		return date;
	}
	public void setDate(List<T> date) {
		this.date = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
