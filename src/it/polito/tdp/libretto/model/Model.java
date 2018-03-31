package it.polito.tdp.libretto.model;

import java.util.*;

import it.polito.tdp.libretto.db.EsameDAO;

public class Model {
//gestira dati di tipo esame
	
	
	private List <Esame> esami;
	
	public Model() {
		this.esami=new ArrayList <Esame>();
	}
	
	
	public boolean addEsame(Esame e) {
		/*if(!esami.contains(e)) {
		esami.add(e);
		return true;
		}
		else 
			return false;*/
		EsameDAO dao=new EsameDAO();
		
		return dao.create(e);
		
	}
	
	
	public Esame trovaEsame(String codice) {
	/*	this.esami.indexOf(codice); //noo dovrei mettere esame non codice
	int pos=esami.indexOf(new Esame(codice,null,null));
    if(pos==-1)
    	return null;
    else {
    	return esami.get(pos);
    }
    */
		EsameDAO dao=new EsameDAO();
		Esame e =dao.find(codice);
		return e;
	}
	
}
