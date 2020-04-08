package it.polito.tdp.lab04.model;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

import java.util.List;

public class Model {
	
	public CorsoDAO corsodao; 
	public StudenteDAO studentedao; 
	
	public Model() {
		corsodao = new CorsoDAO(); 
		
		
	}
	
	public List<Corso> getTuttiICorsi(){
		return corsodao.getTuttiICorsi();
	}
	
	public List<Studente> getCorso(Corso corso){
	
	return corsodao.getCorso(corso); 	
	
		
	}
	
	public Studente AutofillStudenti(int matricola) {
		return studentedao.AutofillStudenti(matricola); 
	}
	
	public List<Corso> CercaCorsiStudente(int matricola){
		return studentedao.CercaCorsiStudente(matricola); 
	}

}
