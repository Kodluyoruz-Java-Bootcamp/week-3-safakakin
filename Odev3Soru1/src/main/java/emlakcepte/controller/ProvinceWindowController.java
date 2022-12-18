package emlakcepte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.model.ProvinceWindow;
import emlakcepte.service.ProvinceWindowService;

@RestController
@RequestMapping(value="provinceWindows")
public class ProvinceWindowController {
	
	@Autowired
	private ProvinceWindowService provinceWindowService;
	
	//Şehir vitrini eklemek için endpoint
	@PostMapping("saveprovincewindow")
	public ResponseEntity<ProvinceWindow> saveProvinceWindow(@RequestBody ProvinceWindow window,@PathVariable String province){
		provinceWindowService.saveProvinceWindow(window, province);
		return new ResponseEntity<>(window,HttpStatus.CREATED);
	}
	
	
	
}
