
package romero_laura_practica2;
/**
 * 
 * @author Laura
 * Aquesta classe emmagatzema tots els atrivuts de cada estació amb els seus getters i alguns mètodes
 *
 */
public class Estacions {

	private double latitud, longitud, currenttemp;
	private double[] lasttemp;
	private int currentrain=0, first=0, last, raincity=0, lastpluja;
	private int[] lastrain;
	private String name; //ERRROR

/**
 * Mètode getter per obtenir la Latitud de l'estació
 * @return Latitud
 */
	public double getLatitud() {
		return latitud;
	}
/**
 * Mètode getter per obtenir la Longitud de l'estació
 * @returnLongitud
 */
	public double getLongitud() {
		return longitud;
	}
/**
 * Mètode getter per obtenir la temperatura actual de l'estació
 * @return temperatura actual
 */
	public double getCurrenttemp() {
		return currenttemp;
	}
/**
 * Mètode getter per obtenir la temperatura dins de la llista dels tres ultims registres de  de l'estació
 * @return llista de temperatures de la ciutat
 */
	public double[] getLasttemp() {
		return lasttemp;
	}
/**
 * Mètode getter per obtenir la pluja dins de la llista dels tres ultims registres de  de l'estació
 * @return pluja de la llista 
 */
	public int getCurrentrain() {
		return currentrain;
	}
/**
 * Mètode getter per obtenir la primera posició de la llista de plujes i temperatures de l'estació
 * @return priera posicio
 */
	public int getFirst() {
		return first;
	}
/**
 * Mètode getter per obtenir la última posició de la llista de plujes i temperatures de l'estació
 * @return última posició
 */
	public int getLast() {
		return last;
	}
/**
 * Mètode getter per obtenir la suma de la pluja dins de la llista dels tres últims registres de l'estació
 * @return suma de la pluja de l'estació
 */
	public int getRaincity() {
		return raincity;
	}
/**
 * Mètode getter per obtenir la pluja dins de la llista dels tres ultims registres de  de l'estació
 * @return llista de pluja de la ciutat
 */
	public int[] getLastrain() {
		return lastrain;
	}
/**
 * Mètode per obtenir el nom de la ciutat on hi ha l'estació
 * @return nom de la ciutat
 */
	public String getName() {
		return name;
	}
/**
 * Mètode getter per otenir la pluja que es va llegint de la taula de plujes per anar sumant la pluja total d'una ciutat
 * @return valor de pluja de la taula de plujes
 */
	public int getLastpluja() {
		return lastpluja;
	}

	
/**
 *	Mètode constructor per crear una nova estació
 * @param latitud
 * @param longitud
 * @param nom
 */
	public Estacions (double latitud, double longitud, String n){
				
		this.latitud=latitud;
		this.longitud=longitud;
		int i;
		this.name=n;
		
		lastrain=new int[3];
		lasttemp=new double[3];
		
		for(i=0; i<3; i++){
			lasttemp[i]=0;
			lastrain[i]=0;
		}
	}
	
/**
 * Mètode per actualitzar el valor de pluja i temperatura d'una estació
 * @param temperatura
 * @param pluja
 */
	public void actualitzadades(double temp,int rain){
		int i, j;
		this.currentrain=rain;
		this.currenttemp=temp;
		raincity=raincity+rain;
		
		if (last<3){
			lasttemp[last]=temp;
			lastrain[last]=rain;
			last++;
		}
		if (last==3){
			last=0;}
		
			lastpluja=0;
			for(i=0; i<3; i++){
				j=lastrain[i];
				lastpluja=lastpluja+j;
		
		}
	}

	
/**
 * Mètode per comparar la pluja de dues estacions
 * @param city
 * @return l'estacioó amb mes pluja
 */
	public Estacions mespluja(Estacions city){
		if (this.raincity>city.raincity) return this;
		else return city;
		}

	
/**
 * Mètode toString
 */
	public String toString(){
		//System.out.println("L'estacio de "+name+" amb latitud: "+latitud+ " i longitud: "+longitud+" la última temperatura resgistrada és:"+currenttemp+"ºC i la ultima pluja registrada és:"+currentrain+"mm");
		return "L'estacio de "+name+" amb latitud: "+latitud+ " i longitud: "+longitud+" la última temperatura resgistrada és:"+currenttemp+"ºC i la ultima pluja registrada és:"+currentrain+"mm" ;
	}

}


