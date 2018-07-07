package com.project0.ProjektGrupowy;

import com.project0.ProjektGrupowy.controller.CarController;
import com.project0.ProjektGrupowy.dto.CarClassDto;
import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.dto.PriceDto;
import com.project0.ProjektGrupowy.service.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjektGrupowyApplicationTests {

	@Autowired
	private I18NService i18NService;

	@Autowired
	private CarService carService;

	@Autowired
	private PriceService priceService;

	@Autowired
	private CarClassService carClassService;

	@Autowired
	private CarController carController;


//	Test i18n local message (Poprawnosc komunikatow lokalnych)
	@Test
	public void testMessageByLocaleService() throws Exception {
		String expectedResult = "Coders Team";
		String messageId = "navbar.coder.text";
		String actual = i18NService.getMessage(messageId);
		Assert.assertEquals("The actual and expected Strings don't match", expectedResult, actual);
	}

	@Test
	public void testGetAllCars() {
		List<CarDto> allCarsList = carService.getAllCars();
		Assert.assertNotNull(allCarsList);
	}

	@Test
	public void testFindByNameFragment() {
		List<CarDto> carsByNameFragment = carService.findByNameFragment("BMW");
		Assert.assertEquals("BMW 318 GT", carsByNameFragment.get(0).getCarName());
	}

	@Test
	public void testGetAllPrices() {
		List<PriceDto> allPricesList = priceService.getAllPrices();
		Assert.assertNotNull(allPricesList);
	}

	@Test
	public void testFindCarClassById(){
		CarClassDto requestedCarClass = carClassService.findCarClassById(1L);
		Assert.assertEquals("Klasa miejska", requestedCarClass.getCarClassName());
	}

	@Test
	public void testGetAllCarClasses() {
		List<CarClassDto> allCarClassesList = carClassService.getAllCarClasses();
		Assert.assertNotNull(allCarClassesList);
	}

//	@Test
//	public void testSearch(){
//		Model model = new Model() {
//			@Override
//			public Model addAttribute(String s, @Nullable Object o) {
//				return null;
//			}
//
//			@Override
//			public Model addAttribute(Object o) {
//				return null;
//			}
//
//			@Override
//			public Model addAllAttributes(Collection<?> collection) {
//				return null;
//			}
//
//			@Override
//			public Model addAllAttributes(Map<String, ?> map) {
//				return null;
//			}
//
//			@Override
//			public Model mergeAttributes(Map<String, ?> map) {
//				return null;
//			}
//
//			@Override
//			public boolean containsAttribute(String s) {
//				return false;
//			}
//
//			@Override
//			public Map<String, Object> asMap() {
//				return null;
//			}
//		};
//		ModelAndView testowy = carController.search("Fiat Panda", "2018-02-02","2018-05-05", model);
//		Assert.assertTrue(testowy,"Fiat Panda","2018-02-02","2018-05-05",model);
//	}

}
