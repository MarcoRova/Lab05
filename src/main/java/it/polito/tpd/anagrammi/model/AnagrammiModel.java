package it.polito.tpd.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class AnagrammiModel {
	
	private AnagrammaDAO anagrammaDAO;
	
	public AnagrammiModel() {
		this.anagrammaDAO = new AnagrammaDAO();
	}
	
	public boolean isCorrect(String anagramma) {
		return this.anagrammaDAO.isCorrect(anagramma);
	}
	
	public List<String> anagrammi(String parola) {
		if(parola.length()==1) {
			List<String> risultato = new LinkedList<String>() ;
			risultato.add(parola) ;
			return risultato ;
		} else {
			List<String> risultato = new LinkedList<String>() ;
			
			for(int pos=0; pos<parola.length(); pos++) {
				char lettera = parola.charAt(pos) ;
				String restanti = parola.substring(0,pos)+parola.substring(pos+1);
				
				List<String>anagrammiRestanti = anagrammi(restanti) ;
				for(String sol: anagrammiRestanti) {
					risultato.add(lettera+sol) ;
				}
			}
			return risultato ;
		}
	}
		
}