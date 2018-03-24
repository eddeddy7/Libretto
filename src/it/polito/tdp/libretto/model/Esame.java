package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Esame {
	
	private String codice;
	private String titolo;
	private String docente;
    private boolean superato;
    private int voto;
    private LocalDate dataSuperamento;
	
    public Esame(String codice, String titolo, String docente) {
		
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		this.superato=false;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public boolean isSuperato() {
		return superato;
	}

	public void setSuperato(boolean superato) {
		this.superato = superato;
	}
 
	//restituisco solo se esame è superato altrimenti eccezione
	public int getVoto() {
		if(this.superato)
		return voto;
		else {
    		//ho chiamato metodo quando non devo
    		throw new IllegalStateException("Esame "+ this.codice + " non superato");
    	}
	}

	private void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getDataSuperamento() {
		if(this.superato)
			return dataSuperamento;
			else {
	    		//ho chiamato metodo quando non devo
	    		throw new IllegalStateException("Esame "+ this.codice + " non superato");
	    	}
	}

	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		//queste ultime due righe mi interessano
		return true;
	}
	
	//se supero esame chiamo questo non set voto set data quindi li metto private
    public void supera(int voto, LocalDate data) {
    	if(! this.superato) {
    		this.superato=true;
    		this.voto=voto;
    		this.dataSuperamento=data;
    		return ;
    	}
    	else {
    		//ho chiamato metodo quando non devo
    		throw new IllegalStateException("Esame "+ this.codice + " gia superato");
    	}
    }

	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}
	
    
    
}
