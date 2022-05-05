import java.util.*;

class TestContatto{
	public static void main(String arg[]){
		Scanner input=new Scanner(System.in);
		Boolean trovato;
		char char_temp;
		String cognome,nome,cellulare,vuota,nome_temp,cognome_temp;
		int anno_nascita,scelta,eta,anno_corrente,temp,temp2,somma,i=0,cont;
		Contatto rubrica[]=new Contatto[1000];
		
		do{
			System.out.println("premi 0 per uscire");
			System.out.println("premi 1 per inserire un contatto");	
			System.out.println("premi 2 per visualizzare i contatti inseriti");
			System.out.println("premi 3 per calcolare le eta' di tutti contatti");
			System.out.println("premi 4 per l'eta' di un solo contatto di cui il cognome e il nome vengono presi in input");
			System.out.println("premi 5 per il primo cognome in ordine alfabetico");
			System.out.println("premi 6 per il cognome più lungo");
			System.out.println("premi 7 per conoscere quanti cognomi iniziano con la lettera 'A'");
			System.out.println("premi 8 per calcolare l'età media");
			System.out.println("premi 9 per contare quanti contatti hanno un'età maggiore della media");
			System.out.println("premi 10 per l'eta' massima");
			System.out.println("premi 11 per l'eta' minima");
			System.out.println("premi 12 per contare quanti nomi contengono la stringa anna");
			System.out.println("premi 13 per prendere una stringa in input e contare quanti nomi contengono la stringa");
			System.out.println("premi 14 per contare quanti nomi finiscono con la lettera 'a'");
			System.out.println("premi 15 per contare quanti nomi finiscono con una consonante");
			System.out.println("premi 16 per contare quanti contanti hanno il doppio nome");

			scelta=input.nextInt();
			vuota=input.nextLine();	
			switch(scelta){
				case 0:
					break;

				case 1:	
					if(i<1000){
						System.out.println("dammi il cognome");
						cognome=input.nextLine();
						System.out.println("dammi il nome");
						nome=input.nextLine();
						System.out.println("dammi il cellulare");
						cellulare=input.nextLine();
						System.out.println("dammi l'anno di nascita");
						anno_nascita=input.nextInt();
						vuota=input.nextLine();	
						rubrica[i]=new Contatto(cognome,nome,cellulare,anno_nascita);
						i++;
					}
					else{
						System.out.println("rubrica piena");
					}
					break;

				case 2:
					for(cont=0;cont<i;cont++){
						System.out.println("Contatto numero: "+(cont+1));
						System.out.println("cognome = "+rubrica[cont].cognome);
						System.out.println("nome = "+rubrica[cont].nome);
						System.out.println("cellulare = "+rubrica[cont].cellulare);
						System.out.println("anno di nascita = "+rubrica[cont].anno_nascita);
						System.out.println("");
					}			
					break;
				case 3:
					System.out.println("dammi l'anno corrente");
					anno_corrente=input.nextInt();
					vuota=input.nextLine();
					for(cont=0;cont<i;cont++){
						eta=rubrica[cont].calcolaEta(anno_corrente);
						if(eta==-1){
							System.out.println("l'anno di nascita non e' valido");
						}
						else{
							System.out.println("eta' del contatto numero "+(cont+1)+" e': "+eta);
						}
					}
					break;
				
				case 4:
					trovato=false;
					System.out.println("dammi l'anno corrente");
					anno_corrente=input.nextInt();
					vuota=input.nextLine();
					System.out.println("dammi il nome");
					nome_temp=input.nextLine();
					System.out.println("dammi il cognome");
					cognome_temp=input.nextLine();
					for(cont=0;cont<i;cont++){
						if(nome_temp.equals(rubrica[cont].nome)&&cognome_temp.equals(rubrica[cont].cognome)){
							eta=rubrica[cont].calcolaEta(anno_corrente);
							trovato=true;
							if(eta==-1){
								System.out.println("l'anno di nascita non e' valido per il contatto "+(cont+1));
							}
							else{
								System.out.println("eta' del contatto numero "+(cont+1)+" e': "+eta);
							}
						}
					}
					if (!trovato) {
						System.out.println("contatto non trovato");
					}
					break;

				case 5:
					cognome_temp=rubrica[0].cognome;
					for(cont=1;cont<i;cont++){
						if(rubrica[cont].cognome.compareTo(cognome_temp)<0){
							cognome_temp=rubrica[cont].cognome;
						}
					}
					System.out.println("il primo cognome in ordine alfabetico e': "+cognome_temp);
					break;
				
				case 6:
					cognome_temp=rubrica[0].cognome;
					for(cont=1;cont<i;cont++){
						if(rubrica[cont].cognome.length()>cognome_temp.length()){
							cognome_temp=rubrica[cont].cognome;
						}
					}
					System.out.println("il cognome piu' lungo e': "+cognome_temp);
					break;
				
				case 7:
					temp=0;
					trovato=false;
					for(cont=0;cont<i;cont++){
						if(rubrica[cont].cognome.toUpperCase().charAt(0)=='A'){
							temp++;
							trovato=true;
						}
					}
					if(!trovato){
						System.out.println("non ci sono cognomi che iniziano con la lettera 'A'");
					}else{
						System.out.println("numero di cognomi che iniziano con la lettera 'A': "+temp);						
					}
					break;
				
				case 8:
					System.out.println("dammi l'anno corrente");
					anno_corrente=input.nextInt();
					vuota=input.nextLine();
					somma=0;
					temp=0;
					for(cont=0;cont<i;cont++){
						eta=rubrica[cont].calcolaEta(anno_corrente);
						if(eta==-1){
							System.out.println("l'anno di nascita non e' valido per il contatto "+(cont+1)+" e non verra' considerato");
							temp++;
						}
						else{
							somma=somma+eta;
						}

					}
					if (somma==0) {
						System.out.println("errore");
					}else{
						System.out.println("eta' media: "+somma/(i-temp));
					}
					break;
				
				case 9:
					System.out.println("dammi l'anno corrente");
					anno_corrente=input.nextInt();
					vuota=input.nextLine();
					somma=0;
					temp2=0;
					temp=0;
					for(cont=0;cont<i;cont++){
						eta=rubrica[cont].calcolaEta(anno_corrente);
						if(eta==-1){
							System.out.println("l'anno di nascita non e' valido per il contatto "+(cont+1)+" e non verra' considerato");
							temp++;
						}else{
							somma=somma+eta;
						}
					}
					if (somma==0) {
						System.out.println("errore");
					}else{
						for(cont=0;cont<i;cont++){
							eta=rubrica[cont].calcolaEta(anno_corrente);
							if(eta!=-1 && eta>somma/(i-temp)){
								temp2++;
							}
						}
						System.out.println("numero di contatti che hanno un'eta' maggiore della media: "+temp2);
					}
					break;

				case 10:
					System.out.println("dammi l'anno corrente");
					anno_corrente=input.nextInt();
					vuota=input.nextLine();
					temp=0;
					trovato=false;
					for(cont=0;cont<i;cont++){
						eta=rubrica[cont].calcolaEta(anno_corrente);
						if(eta!=-1 && eta>temp){
							temp=eta;
							trovato=true;
						}
					}
					if(!trovato){
						System.out.println("non ci sono contatti che hanno un'eta' valida");
					}else{
						System.out.println("eta' massima: "+temp);
					}
					break;
				
				case 11:
					System.out.println("dammi l'anno corrente");
					anno_corrente=input.nextInt();
					vuota=input.nextLine();
					temp=0;
					trovato=false;
					for(cont=0;cont<i;cont++){
						eta=rubrica[cont].calcolaEta(anno_corrente);
						if(eta!=-1){
							if (!trovato) {
								temp=eta;
								trovato=true;
							}else{
								if(eta<temp){
									temp=eta;
								}
							}
						}
					}
					if(!trovato){
						System.out.println("non ci sono contatti che hanno un'eta' valida");
					}else{
						System.out.println("eta' minima: "+temp);
					}
					break;

				case 12:
					temp=0;
					trovato=false;
					for(cont=0;cont<i;cont++){
						if (rubrica[cont].nome.toLowerCase().indexOf("anna") != -1){
							temp++;
							trovato=true;
						}
					}
					if(!trovato){
						System.out.println("non ci sono contatti che hanno un nome contenente la stringa 'anna'");
					}else{
						System.out.println("numero di contatti che hanno un nome contenente la stringa 'anna': "+temp);
					}
					break;

				case 13:
					temp=0;
					trovato=false;
					System.out.println("dammi la stringa da cercare nei nomi");
					nome_temp=input.nextLine();
					for(cont=0;cont<i;cont++){
						if (rubrica[cont].nome.toLowerCase().indexOf(nome_temp) != -1){
							temp++;
							trovato=true;
						}
					}
					if(!trovato){
						System.out.println("non ci sono contatti che hanno un nome contenente la stringa '"+nome_temp+"'");
					}else{
						System.out.println("numero di contatti che hanno un nome contenente la stringa '"+nome_temp+"': "+temp);
					}
					break;

				case 14:
					temp=0;
					trovato=false;
					for(cont=0;cont<i;cont++){
						if(rubrica[cont].nome.toUpperCase().charAt(rubrica[cont].nome.length()-1)=='A'){
							temp++;
							trovato=true;
						}
					}
					if(!trovato){
						System.out.println("non ci sono nomi che finiscono con 'a'");
					}else{
						System.out.println("numero di nomi che finiscono con 'a': "+temp);
					}
					break;

				case 15:
					temp=0;
					trovato=false;
					for(cont=0;cont<i;cont++){
						char_temp=rubrica[cont].nome.toLowerCase().charAt(rubrica[cont].nome.length()-1);
						if(char_temp!='a' && char_temp!='e' && char_temp!='i' && char_temp!='o' && char_temp!='u'){
							temp++;
							trovato=true;
						}
					}
					if(!trovato){
						System.out.println("non ci sono nomi che finiscono con una consonante");
					}else{
						System.out.println("numero di nomi che finiscono con una consonante: "+temp);
					}
					break;

				case 16:
					temp=0;
					trovato=false;
					// count how many contacts have 2 word names
					for(cont=0;cont<i;cont++){
						if(rubrica[cont].nome.indexOf(" ")!=-1){
							temp++;
							trovato=true;
						}
					}
					if(!trovato){
						System.out.println("non ci sono contatti che hanno il doppio nome");
					}else{
						System.out.println("numero di contatti che hanno il doppio nome: "+temp);
					}
					break;

				default:
					System.out.println("scelta non prevista");
			}
		}while(scelta!=0);
	}	
}
