package com.atia.roadrunner.car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.atia.roadrunner.car.Controller.CarController;
import com.atia.roadrunner.car.Model.Car;
import com.atia.roadrunner.car.Repository.ICarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class CarControllerTests {

	private MockMvc mvc;
	@Mock
	private ICarRepository carRepo;

	@InjectMocks
	private CarController carController;

	private JacksonTester<Car> jsonCar;

	private JacksonTester<Collection<Car>> jsonCars;

	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(carController).build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void canAddANewCar() throws Exception {
		Car car = new Car(5L,"This is a best car.","abc","The official Mercedes-AMG website all about Performance Luxury: unique vehicles, exciting stories \u2013 and exclusive benefits as a Private Lounge member.", "image.png",10055432.00 );
       when(carRepo.save(car)).thenReturn((car));
		mvc.perform(post("/cars/post")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonCar.write(car).getJson()))
				.andExpect(status().isOk());

	}

	@Test
	public void canGetAllCars() throws Exception {
		Car car1 = new Car(5L,"This is a best car.","abc","The official Mercedes-AMG website all about Performance Luxury: unique vehicles, exciting stories \u2013 and exclusive benefits as a Private Lounge member.", "image.png",10055432.00 );

       Car car2 = new Car(10L,"This is a best car.","abc","The official Mercedes-AMG website all about Performance Luxury: unique vehicles, exciting stories \u2013 and exclusive benefits as a Private Lounge member.", "image.png",1005442.00 );
		List<Car> carList = new ArrayList<>();
		carList.add(car1);
		carList.add(car2);
		when(carRepo.findAll()).thenReturn(carList);
		mvc.perform(get("/cars/getallcars")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonCars.write(carList).getJson()));
	}

	@Test
	public void canGetACar() throws Exception {
		Car car1 = new Car(10L,"This is a best car.","abc","The official Mercedes-AMG website all about Performance Luxury: unique vehicles, exciting stories \u2013 and exclusive benefits as a Private Lounge member.", "image.png",1005442.00 );
		when(carRepo.findById(10L)).thenReturn(Optional.of(car1));
		mvc.perform(MockMvcRequestBuilders.get("/cars/get/10")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(jsonCar.write(car1).getJson()));
	}
}