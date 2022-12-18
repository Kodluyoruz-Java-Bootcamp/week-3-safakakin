package emlakcepte;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import emlakcepte.model.DwellingType;
import emlakcepte.model.Message;
import emlakcepte.model.ProvinceWindow;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyDefinition;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;
import emlakcepte.service.ProvinceWindowService;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;

public class Main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		

		User userPelin = prepareUser("Pelin", "mimar.pelin@gmail.com", "Pelin123");
		User userSami = new User("Sami", "sami@gmail.com", "123", UserType.INDIVIDUAL, Collections.emptyList());

		/*
		 * UserService userService = UserService.getSameInstance();
		 * 
		 * UserService userService1 = UserService.getSameInstance();
		 * 
		 * UserService userService2 = UserService.getDifferentInstance();
		 * 
		 * System.out.println(userService); System.out.println(userService1);
		 * System.out.println(userService2);
		 */

		// eski yöntem
		//UserService userService = new UserService();

		//Spring bizim yerime create ediyor
		UserService userService = applicationContext.getBean(UserService.class);
		
		userService.createUser(userPelin);
		userService.createUser(userSami);

		userService.printAllUser();

		System.out.println("-----");

		// userList.add(user);
		// userList.add(userPelin);

		// userList.forEach(usr -> System.out.println(usr.getName()));

		RealtyService realtyService = new RealtyService();

		Realty realty = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userSami,
				RealtyType.ACTIVE,"İstanbul","Kağıthane",DwellingType.APARTMENT,RealtyDefinition.FORSALE);

		realtyService.createRealty(realty);

		Realty realty1 = new Realty();
		realty1.setNo(124L);
		realty1.setTitle("Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA");
		realty1.setStatus(RealtyType.ACTIVE);
		realty1.setUser(userPelin);
		realty1.setProvince("İstanbul");
		realty1.setDistrict("Beşiktaş");
		realty1.setType(DwellingType.DETACHEDHOUSE);

		realtyService.createRealty(realty1);

		Realty favori1 = new Realty();
		favori1.setNo(125L);
		favori1.setTitle("KAVAKPINAR MAHALLESİNDE 2+1 80 M2 ARAKAT İSKANLI");
		favori1.setStatus(RealtyType.ACTIVE);
		favori1.setUser(userPelin);
		favori1.setProvince("Ankara");

		realtyService.createRealty(favori1);

		realty.setUser(userSami);
		userSami.setRealtyList(List.of(realty, realty1));

		List<Realty> fovarilerim = new ArrayList<>();
		fovarilerim.add(favori1);
		userSami.setFavoriteRealtyList(fovarilerim);

		// sistemdeki bütün ilanlar

		System.out.println("Bütün ilanlar");

		realtyService.printAll(realtyService.getAll());

		// İstanbuldaki ilanların bulunması

		System.out.println("İstanbul'daki ilanlar");

		realtyService.getAllByProvince("İstanbul");

		// Bir kullanıcının bütün ilanlarını listele
		realtyService.printAll(realtyService.getAllByUserName(userPelin));

		realtyService.printAll(realtyService.getActiveRealtyByUserName(userSami));

		/*
		 * userList.forEach(usr -> {
		 * 
		 * usr.getFavoriteRealtyList().forEach(favoriRealty ->
		 * System.out.println(favoriRealty.getTitle()) );
		 * 
		 * });
		 */
		userSami.getMessages();
		
		//İstanbul,Ankara ve İzmir ilan sayıları
		realtyService.getAllByProvince("İstanbul").size();
		realtyService.getAllByProvince("Ankara").size();
		realtyService.getAllByProvince("İzmir").size();
		
		//İstanbul,Ankara ve İzmir toplam ilan sayısı
		int count = realtyService.getAllByProvince("İstanbul").size() + 
					realtyService.getAllByProvince("Ankara").size() +
					realtyService.getAllByProvince("İzmir").size();
		
		
		//İstanbul,Ankara ve İzmir satılık ilan sayıları
		realtyService.getAllByProvince("İstanbul").stream().filter(r->r.getDefinition()==RealtyDefinition.FORSALE).toList().size();
		realtyService.getAllByProvince("Ankara").stream().filter(r->r.getDefinition()==RealtyDefinition.FORSALE).toList().size();
		realtyService.getAllByProvince("İzmir").stream().filter(r->r.getDefinition()==RealtyDefinition.FORSALE).toList().size();
		
		//İstanbul,Ankara ve İzmirdeki toplam satılık ilan sayıları
		int count2 =
		realtyService.getAllByProvince("İstanbul").stream().filter(r->r.getDefinition()==RealtyDefinition.FORSALE).toList().size()+
		realtyService.getAllByProvince("Ankara").stream().filter(r->r.getDefinition()==RealtyDefinition.FORSALE).toList().size()+
		realtyService.getAllByProvince("İzmir").stream().filter(r->r.getDefinition()==RealtyDefinition.FORSALE).toList().size();

	
		ProvinceWindowService provinceWindowService=new ProvinceWindowService();
		
		Realty realty4 = new Realty(523L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userSami,
				RealtyType.ACTIVE,"istanbul","Kağıthane",DwellingType.APARTMENT,RealtyDefinition.FORSALE);
		Realty realty5 = new Realty(723L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userSami,
				RealtyType.ACTIVE,"istanbul","Kağıthane",DwellingType.APARTMENT,RealtyDefinition.FORSALE);
		Realty realty6 = new Realty(323L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userSami,
				RealtyType.ACTIVE,"istanbul","Kağıthane",DwellingType.APARTMENT,RealtyDefinition.FORSALE);
		
		realtyService.createRealty(realty4);
		realtyService.createRealty(realty5);
		realtyService.createRealty(realty6);
		
		ProvinceWindow provinceWindow1=new ProvinceWindow("istanbul",List.of(realty4,realty5,realty6));
		
		provinceWindowService.saveProvinceWindow(provinceWindow1, "istanbul");
	
	}
	
	

	private static User prepareUser(String name, String email, String password) {
		User user = new User();
		user.setName(name);
		user.setMail(email);
		user.setPassword(password);
		user.setType(UserType.INDIVIDUAL);
		user.setCreateDate(LocalDateTime.now());
		return user;
	}

}
