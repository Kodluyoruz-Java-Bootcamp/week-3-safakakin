package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import emlakcepte.model.ProvinceWindow;


public class ProvinceWindowDao {
	private static List<ProvinceWindow> windowList = new ArrayList<>();
	
	public void saveProvinceWindow(ProvinceWindow window) {
		windowList.add(window);
	}
	
	public List<ProvinceWindow> findAll(){
		return windowList;
	}
	
}
