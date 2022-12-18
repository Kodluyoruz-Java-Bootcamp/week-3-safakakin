package emlakcepte.model;

import java.util.List;

public class ProvinceWindow {
	
	private String province;
	private List<Realty> realityList;
	
	public ProvinceWindow() {
		
	}
	
	public ProvinceWindow(String province, List<Realty> realityList) {
		super();
		this.province = province;
		this.realityList = realityList;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public List<Realty> getRealityList() {
		return realityList;
	}

	public void setRealityList(List<Realty> realityList) {
		this.realityList = realityList;
	}
	
	
	
}
