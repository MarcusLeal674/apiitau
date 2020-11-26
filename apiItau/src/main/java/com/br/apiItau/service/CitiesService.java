package com.br.apiItau.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.apiItau.dao.CitiesDao;
import com.br.apiItau.dto.CitiesDTO;

/**
 * 
 * @author Marcus Leal
 * e-mail marcusleal674@gmail.com 
 *
 */
@Service
public class CitiesService {
	
	@Autowired
	private CitiesDao citiesDao;
	
	
	public String listCitiesService(String cityLocation, String compareDistanceCity, String compareDistanceCity1) throws IllegalArgumentException{
		
		List<CitiesDao> listCitiesthis = this.citiesDao.listCitiesDAO();
				
		List<CitiesDTO> validatingListCitiesAdd = validatingCity(cityLocation, compareDistanceCity, compareDistanceCity1, listCitiesthis);
		
		String msg = compareDistanceCities(cityLocation, compareDistanceCity, compareDistanceCity1, validatingListCitiesAdd);
		
		return msg;
	}

	private List<CitiesDTO> validatingCity(String cityLocation, String compareDistanceCity, String compareDistanceCity1, List<CitiesDao> listCitiesthis) 
	throws IllegalArgumentException {
		
		CitiesDTO citiesDTO;
		List<CitiesDTO> listCitiesAdd = new ArrayList<CitiesDTO>();
		boolean foundCity = false;
		
		for (CitiesDao citiesDao : listCitiesthis) {
			
			if (cityLocation.trim().equalsIgnoreCase(citiesDao.getCity())) {
				citiesDTO = new CitiesDTO();
				citiesDTO.setCity(citiesDao.getCity());
				citiesDTO.setDistance(citiesDao.getDistance());				
				listCitiesAdd.add(citiesDTO);
				
				foundCity = true;				
				break;
			} 
		}
		
		if (!foundCity) {
			throw new IllegalArgumentException("Cidade de " + cityLocation + " n�o Localizada.");
		}
		
		foundCity = false;
		
		for (CitiesDao citiesDao : listCitiesthis) {			

			if (compareDistanceCity.trim().equalsIgnoreCase(citiesDao.getCity())) {
				citiesDTO = new CitiesDTO();
				citiesDTO.setCity(citiesDao.getCity());
				citiesDTO.setDistance(citiesDao.getDistance());				
				listCitiesAdd.add(citiesDTO);foundCity = true;
				
				foundCity = true;				
				break;
			} 
		}
		
		if (!foundCity) {
			throw new IllegalArgumentException("Cidade de " + compareDistanceCity + " n�o Localizada.");
		}
		
		foundCity = false;
		
		for (CitiesDao citiesDao : listCitiesthis) {
			
			if (compareDistanceCity1.trim().equalsIgnoreCase(citiesDao.getCity())) {
				citiesDTO = new CitiesDTO();
				citiesDTO.setCity(citiesDao.getCity());
				citiesDTO.setDistance(citiesDao.getDistance());				
				listCitiesAdd.add(citiesDTO);
				
				foundCity = true;
				break;
			} 
		}
		
		if (!foundCity) {
			throw new IllegalArgumentException("Cidade de " + compareDistanceCity1 + " n�o Localizada.");
		}
		
		return listCitiesAdd;
	}
	
	private String compareDistanceCities(String cityLocation, String compareDistanceCity, String compareDistanceCity1, List<CitiesDTO> validatingListCitiesAdd) {
		
		String distanceCities = "";
		int difference = 0;
		
		for (CitiesDTO citiesDTO : validatingListCitiesAdd) {
			
			if (compareDistanceCity.equalsIgnoreCase(citiesDTO.getCity())) {
				
					for (CitiesDTO citiesDTO1 : validatingListCitiesAdd) {
						
					if (compareDistanceCity1.equalsIgnoreCase(citiesDTO1.getCity())) {
						
						if (citiesDTO.getDistance() <= citiesDTO1.getDistance()) {
							difference = citiesDTO1.getDistance() - citiesDTO.getDistance();
							distanceCities = "A cidade mais pr�xima de " + cityLocation + " � " + citiesDTO.getCity() + ". Com uma diferen�a de " + difference + "km da cidade de " + citiesDTO1.getCity();
						} else {
							difference = citiesDTO.getDistance() - citiesDTO1.getDistance();
							distanceCities = "A cidade mais pr�xima de " + cityLocation + " � " + citiesDTO1.getCity() + ". Com uma diferen�a de " + difference + "km da cidade de " + citiesDTO.getCity();
						}
					} 
				}
			}
		}
		
		return distanceCities;
	}

}
