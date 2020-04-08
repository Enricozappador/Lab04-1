package it.polito.tdp.lab04.model;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import java.util.List;

public class Model {
	
	public CorsoDAO corsodao; 
	
	public Model() {
		corsodao = new CorsoDAO(); 
		
		
	}
	
	public List<Corso> getTuttiICorsi(){
		return corsodao.getTuttiICorsi();
	}

}
