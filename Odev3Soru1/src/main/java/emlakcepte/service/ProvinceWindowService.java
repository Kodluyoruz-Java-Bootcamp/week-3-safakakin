package emlakcepte.service;

import java.util.List;

import org.springframework.stereotype.Service;

import emlakcepte.dao.ProvinceWindowDao;
import emlakcepte.model.ProvinceWindow;
import emlakcepte.model.Realty;

@Service
public class ProvinceWindowService {
	
	private ProvinceWindowDao provinceWindowDao=new ProvinceWindowDao();
	
	public void saveProvinceWindow(ProvinceWindow window,String province) {
		
		
		if(window.getRealityList().size()<=10) {
			
			boolean val=true;
		
			for(Realty x : window.getRealityList()) {
				if(x.getProvince()!=province) {
					val=false;
				}
			}
			if(val) {
				provinceWindowDao.saveProvinceWindow(window);
				for(Realty x : window.getRealityList()) {
					System.out.println(x.getNo());
				}
			}
		}
	}
	
	public List<ProvinceWindow> findAll(){
		return provinceWindowDao.findAll();
	}
}
