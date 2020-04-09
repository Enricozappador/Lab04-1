package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public Studente AutofillStudenti(int matricola){
		
		String sql = "SELECT s.nome, s.cognome, s.matricola, s.CDS FROM Studente AS s WHERE s.matricola = ?"; 
		
		
	
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Studente s = new Studente(rs.getInt("matricola"),rs.getString("nome"), rs.getString("cognome"), rs.getString("CDS")); 
				return s; 
			
			}
			conn.close();
			
			}catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db", e);
			}
		
	return null; 
		
	}
	
	public List<Corso> CercaCorsiStudente(int matricola){
		String sql = "SELECT c.codins,c.crediti,c.nome,c.pd FROM corso AS c, iscrizione AS i, studente AS s WHERE c.codins= i.codins AND s.matricola = i.matricola AND s.matricola = ?";
		List<Corso> result = new ArrayList<>(); 
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"),rs.getInt("pd"));  
			result.add(c); 
			}
			conn.close();
			
			}catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db", e);
			}
		
	return result; 
	}
	
	public boolean isStudenteIscritto(Studente studente, Corso corso){
		String sql= " SELECT * FROM iscrizione WHERE codins = ? AND matricola = ?";
		boolean flag = false; 
		int count = 0; 
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodins());
			st.setInt(2, studente.getMatricola());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
			count++; 
			}
			conn.close();
			
			}catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db", e);
			}
		
		
		if(count>0) {
			flag = true; 
		}
		return flag; 
	}
}
