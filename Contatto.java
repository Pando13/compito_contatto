class Contatto{

// attributi
	String cognome, nome, cellulare;
	int anno_nascita;

// costruttore caso 1
	public Contatto(String cognome, String nome, String cellulare, int anno_nascita){
		this.cognome=cognome;
		this.nome=nome;
		this.cellulare=cellulare;
		this.anno_nascita=anno_nascita;
	}
		
// costruttore caso 2
/*
	public Contatto(String cog, String nom, String cel, int anno){
		cognome=cog;
		nome=nom;
		cellulare=cel;
		anno_nascita=anno;
	}
*/

// metodi	
	int calcolaEta(int anno_corrente){
		int eta;
		if(anno_nascita>anno_corrente){
			return -1;
		}
		else{
			eta=anno_corrente-anno_nascita;
		}
		return eta;
	}
}