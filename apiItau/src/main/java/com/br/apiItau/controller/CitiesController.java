package com.br.apiItau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.apiItau.service.CitiesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Marcus Leal
 * e-mail marcusleal674@gmail.com 
 *
 */
@RestController
@RequestMapping("/itau")
@Api(value = "CitiesController")
public class CitiesController {
	
	@Autowired
	private CitiesService citiesService;
	
	@ApiOperation(value = "Api compares the distance between the cities of São Paulo, Santos, Osasco, Marilia, São Carlos and Presidente Prudente")
	@GetMapping(value = "/cities")
	public ResponseEntity<ResponseEntity<String>> compareDistanceBetweenCities(String cityLocation, String compareDistanceCity, String compareDistanceCity1) {		
		
		ResponseEntity<ResponseEntity<String>> returnObjectResponseCities = null;
		
		try {
			String returnMsg = this.citiesService.listCitiesService(cityLocation, compareDistanceCity, compareDistanceCity1);
			
			ResponseEntity<String> log = new ResponseEntity<String>(returnMsg, HttpStatus.OK);
			
			returnObjectResponseCities = ResponseEntity.status(HttpStatus.OK).body(log);
		} catch (IllegalArgumentException e) {
			ResponseEntity<String> log = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
			
			returnObjectResponseCities = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(log);
		}
		
		return returnObjectResponseCities;
	}


}
