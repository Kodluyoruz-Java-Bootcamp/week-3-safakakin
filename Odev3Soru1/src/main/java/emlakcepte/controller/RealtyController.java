package emlakcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.model.DwellingType;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyDefinition;
import emlakcepte.service.RealtyService;

@RestController
@RequestMapping(value="/realtyes")
public class RealtyController {
	
	@Autowired
	public RealtyService realtyService;
	
	
	//İle göre arama endpoint
	@GetMapping("/getallbyprovince")
	public List<Realty> getAllByProvince(@PathVariable String province) {
		return realtyService.getAllByProvince(province);
	}
	//İl ve ilçeye göre arama endpoint
	@GetMapping("/getallbyprovinceanddistrict")
	public List<Realty> getAllByProvince(@PathVariable String province,@PathVariable String district) {
		return realtyService.getAllByProvinceAndDistrict(province,district);
	}
	//İle göre ilan adeti endpoint
	@GetMapping("/getrealtycountbyprovince")
	public long getRealtyCountByProvince(@PathVariable List<String> provinces) {
		return realtyService.getRealtyCountByProvince(provinces);
	}
	
	//İle göre satılık kiralık, konut müstakil ev ilan adeti endpoint
	@GetMapping("/getrealtycountbyprovincebydefinitionanddwellingtype")
	public long getRealtyCountByProvinceByDefinitionAndDwellingType(@PathVariable List<String> provinces,
			@PathVariable RealtyDefinition realtyDefinition, @PathVariable DwellingType dwellingType) {
		return realtyService.getRealtyCountByProvinceByDefinitionAndDwellingType(provinces,realtyDefinition,dwellingType);
	}
	
	
	
	
}
