package romero_laura_practica2;

import java.util.*;

public class romero_laura_practica2 {
	int inicialitzats;
    private static Scanner keyboard=new Scanner(System.in);
	private static Llista llistaestacions;
	private static Llista llistaneu;

    private static int numestacions;
    
    
	public static void main(String[] args) {

	System.out.println("Digues el numero de posicions de la taula d'estacions: ");
	numestacions=keyboard.nextInt();
	
	llistaestacions=new Llista(numestacions);
	llistaneu=new Llista(numestacions);
	
	llistaestacions.newEstacions(41.7330, 1.8333, "Manresa");			//creem les 6 ciutats inicials
	llistaestacions.newEstacions(41.3850, 2.1734, "Barcelona");
	llistaestacions.newEstacions(41.1186, 1.2443, "Tarragona");
	llistaestacions.newEstacions(41.5462, 2.1085, "Sabadell");
	llistaestacions.newEstacions(42.1014, 1.8440, "Berga");
	llistaestacions.newEstacions(41.9794, 2.8213, "Girona");

	
	llistaestacions.buscar("Manresa").actualitzadades(13, 0);
	llistaestacions.buscar("Manresa").actualitzadades(15, 0);
	llistaestacions.buscar("Manresa").actualitzadades(-2, 55);
	
	llistaestacions.buscar("Barcelona").actualitzadades(18, 4);
	llistaestacions.buscar("Barcelona").actualitzadades(20, 15);
	llistaestacions.buscar("Barcelona").actualitzadades(17, 17);
	
	llistaestacions.buscar("Tarragona").actualitzadades(18, 16);
	llistaestacions.buscar("Tarragona").actualitzadades(23, 17);
	llistaestacions.buscar("Tarragona").actualitzadades(21, 18);
	
	llistaestacions.buscar("Sabadell").actualitzadades(22, 22);
	llistaestacions.buscar("Sabadell").actualitzadades(18, 15);
	llistaestacions.buscar("Sabadell").actualitzadades(20, 7);
	
	llistaestacions.buscar("Berga").actualitzadades(18, 9);
	llistaestacions.buscar("Berga").actualitzadades(17, 2);
	llistaestacions.buscar("Berga").actualitzadades(19, 7);
	
	llistaestacions.buscar("Girona").actualitzadades(23, 5);
	llistaestacions.buscar("Girona").actualitzadades(19, 0);
	llistaestacions.buscar("Girona").actualitzadades(18, 80);
	
	Menu();
	int op= Integer.parseInt(keyboard.next());
	while (op!=10) {
		switch(op) {
		case 1: enucarmain(); break;
		case 2: actualitzar(); break;
		case 3: esborrar(); break;
		case 4: consultar(); break;
		case 5: totalpluja(); break;
		case 6: mespluja(); break;
		case 7: plugesimportants(); break;
		case 8: perillneu(); break;
		case 9: nord(); break;
		}
		
		Menu();
		op=keyboard.nextInt();
		}
	}
	
	/**
	 * Mètode que mostra el menú per pantalla
	 */
	
	public static void Menu() {
		System.out.println("\n\n Opcions:");
		System.out.println("\n\t1. Afegir una estació");
		System.out.println("\t2. Afegir noves dades a una estació preexistent");
		System.out.println("\t3. Esborrar una estació");
		System.out.println("\t4. Consultar dades d'una estació a partir del seu nom");
		System.out.println("\t5. Consultar el total de pluja de totes les estacions");
		System.out.println("\t6. Consultar el nom de l'estació amb més pluja");
		System.out.println("\t7. Consultar si dona tun rang d'estacions l'acumulació de plujes va en augment");
		System.out.println("\t8. Consultar les estacions que tenen el darrer valor de temperatura menor a 0ºC");
		System.out.println("\t9. Consultar l'estació més al nord amb una temperatura superior a 20ºC");
		System.out.println("\t10. Sortir");
		System.out.print("\n\t\tEscull una opció:\n");
	}
	
	/**
	 * Mètode per encuar les estacions a la llista
	 */
	
	public static void enucarmain(){
		String nomciutat;
		double latitud, longitud;
		
		System.out.println("Introdueix el no de la ciutat: ");
		nomciutat=keyboard.next(); 
		System.out.println("Introdueix la latitud de la ciutat: ");
		latitud=keyboard.nextDouble();
		System.out.println("Introdueix la longitud de la ciutat: ");
		longitud=keyboard.nextDouble();

		llistaestacions.newEstacions(latitud, longitud, nomciutat); 
		}

	/**
	 * Mètode per actualitzar els valors de les estacions
	 */
	
	public static void actualitzar(){
		int pluja;
		double temps;
		String nom;
		
		System.out.println("Introdueix el nom de la ciutat que vols actualitzar:");
		nom=keyboard.next();
		System.out.println("Introdueix la pluja de la ciutat: ");
		pluja=keyboard.nextInt();
		System.out.println("Introdueix la temperatura de la ciutat: ");
		temps=keyboard.nextDouble();

		llistaestacions.buscar(nom).actualitzadades(temps, pluja);
	}

	/**
	 * Mètode per eliminar una estació de la llista
	 */
	
	public static void esborrar(){
		String nom;
		int i;
		
		System.out.println("Introdueix el nom de la ciutat que vols borrar:");
		nom=keyboard.next();
		i=llistaestacions.buscareliminar(nom);
		llistaestacions.eliminar(i);
	}
	
	/**
	 * Mètode per consultar les dades d'una estació meteorològica de la llista
	 */
	
	public static void consultar(){
		String nom;

		System.out.println("Introdueix el nom de la ciutat que vols consultar:");
		nom=keyboard.next();
		System.out.println(llistaestacions.buscar(nom));
		
	}
	
	/**
	 * Mètode per coslutar l'estacio que ha acumulat mès pluja en un dels seus registres
	 */
	
	public static void mespluja(){
		String nom;
		
		nom=llistaestacions.morerain();
		System.out.println("La ciutat amb el registre amb més pluja es: "+nom);
		
	}
	
	/**
	 * Mètode per calcular el total de pluja de totes les estacions 
	 */
	
	public static void totalpluja(){
		int total;
		total=llistaestacions.totalpluja();
		System.out.println("El total de pluja acumulat és: "+total);
		
	}

	/**
	 * Mètode per buscar l'estació mes al nord amb un darrer valor de temperatura superior a 20ºC
	 */
	
	public static void nord(){
		String nom;
		
		nom=llistaestacions.mesnord();
		System.out.println("La ciutat més al nord amb l'ultima temperatura major de 20ªC es: "+nom);
	}
	
	/**
	 * Mètode per comprovar si hi ha risc de plujes importants
	 */
	
	public static void plugesimportants(){
		int primer, ultim;

		System.out.println("Introdueix el primer numero del rang: ");
		primer=keyboard.nextInt();
		System.out.println("Introdueix el darrer numero del rang: ");
		ultim=keyboard.nextInt();
		
		boolean plujes=llistaestacions.perillplujes(primer, ultim);
		if (plujes==true) System.out.println("Hi ha perill de plujes entre els rangs que has introduit");

	}
	
	/**
	 * Mètode per comprovar si hi ha perill de neu en alguna estació
	 */
	
	public static void perillneu (){

		int i=0;
		
		llistaestacions.neu();
		

		for(i=0; i<=(Llista.getNumneu()-1); i++){

			System.out.println(llistaneu.getEstacio(i));
		}
	}

}

