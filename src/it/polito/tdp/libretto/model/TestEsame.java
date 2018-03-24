package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestEsame {

	public static void main(String[] args) {
		Esame tdp =new Esame("03FYZ", "Tecniche di programmazione", " FulvioCorno");
        Esame ami=new Esame ("01QZP", "Ambient Intelligence", "FlivioCorno");
        System.out.println(tdp);
        System.out.println(ami);
        
        tdp.supera(30, LocalDate.now());
        System.out.println(tdp);
        
        tdp.supera(28, LocalDate.now());
	}

}
