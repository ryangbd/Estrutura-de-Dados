package view;

import controller.PaginaController;

public class Pagina{
	public static void main(String[] args){
		try{
			PaginaController c = new PaginaController("terra.com.br");
			c.links("https://www.terra.com.br/");
		}catch(Exception e){
				System.out.println("Falha ao carreegar");
				e.printStackTrace();
		}	
		
	}
}