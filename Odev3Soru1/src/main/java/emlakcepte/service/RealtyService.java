package emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.dao.RealtyDao;
import emlakcepte.model.DwellingType;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyDefinition;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;

@Service
public class RealtyService {
	
	private RealtyDao realtyDao = new RealtyDao();
	
	public void createRealty(Realty realty) {	
	
		if (realty.getUser().getType()==UserType.INDIVIDUAL) {
			if(realty.getType()==DwellingType.APARTMENT && 
				(realty.getUser().getRealtyList().size()<=3 || realty.getUser().getRealtyList()==null)){
				realtyDao.saveRealty(realty);
			}
		}
		else {
			realtyDao.saveRealty(realty);
		}	
	}
	
	public List<Realty> getAll(){
		return realtyDao.findAll();
	}
	
	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}
	
	//Liste döndüren il bazlı filtreleme methodu olarak güncellendi.
	public List<Realty> getAllByProvince(String province) {
		
		return getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		.toList();
		
	}
	
	public List<Realty> getAllByUserName(User user){	
		return getAll().stream()
		.filter(realty -> realty.getUser().getMail().equals(user.getMail()))
		.toList();		
	}

	public List<Realty> getActiveRealtyByUserName(User user) {
		
		return getAll().stream()
		.filter(realty -> realty.getUser().getName().equals(user.getName()))
		.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
		.toList();

	}
	
	//İl + ilçe bazlı arama için yeni bir method oluşturuldu. İl sorgusu için daha önce 
	//oluşturulan method çağırıldı.
	public List<Realty> getAllByProvinceAndDistrict(String province,String district) {
		return getAllByProvince(province).stream()
				.filter(realty -> realty.getDistrict().equals(district))
				.toList();
	}
	
	
	public long getRealtyCountByProvince(List<String> provinces) {
		return getAll().stream()
				.filter(realty->provinces.contains(realty.getProvince()))
				.count();
	}
	
	public long getRealtyCountByProvinceByDefinitionAndDwellingType(List<String> provinces,RealtyDefinition realtyDefinition,DwellingType dwellingType) {
		return getAll().stream()
				.filter(realty->realty.getDefinition().equals(realtyDefinition))
				.filter(realty->realty.getType().equals(dwellingType))
				.filter(realty->provinces.contains(realty.getProvince()))
				.count();
	}

}
