package com.br.apiItau.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Marcus Leal
 * e-mail marcusleal674@gmail.com 
 *
 */
@Getter
@Setter
@Repository
public class CitiesDao {
	
	private String city;
	
	private int distance;
	

	/**
	 * This method simulates a Database and returns a list of Cities in the State of São Paulo and their respective distances
	 * 
	 * @return List<CitiesDao>
	 */
	public List<CitiesDao> listCitiesDAO() {
		
		List<CitiesDao> listCitiesAdd = new ArrayList<CitiesDao>();
		
		CitiesDao citiesDao = new CitiesDao();
		citiesDao.setCity("São Paulo");
		citiesDao.setDistance(0);
		listCitiesAdd.add(citiesDao);
		
		CitiesDao citiesDao1 = new CitiesDao();
		citiesDao1.setCity("Santos");
		citiesDao1.setDistance(79);
		listCitiesAdd.add(citiesDao1);
		
		CitiesDao citiesDao3 = new CitiesDao();
		citiesDao3.setCity("Osasco");
		citiesDao3.setDistance(23);
		listCitiesAdd.add(citiesDao3);
		
		CitiesDao citiesDao4 = new CitiesDao();
		citiesDao4.setCity("Marilia");
		citiesDao4.setDistance(446);
		listCitiesAdd.add(citiesDao4);
		
		CitiesDao citiesDao5 = new CitiesDao();
		citiesDao5.setCity("São Carlos");
		citiesDao5.setDistance(240);
		listCitiesAdd.add(citiesDao5);
		
		CitiesDao citiesDao6 = new CitiesDao();
		citiesDao6.setCity("Presidente Prudente");
		citiesDao6.setDistance(560);
		listCitiesAdd.add(citiesDao6);
		
		return listCitiesAdd;
	}

}
