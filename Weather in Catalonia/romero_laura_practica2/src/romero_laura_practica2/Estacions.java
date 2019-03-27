
package romero_laura_practica2;
/**
 * 
 * @author Laura
 * Aquesta classe emmagatzema tots els atrivuts de cada estaci� amb els seus getters i alguns m�todes
 *
 */
public class Estacions {

	private double latitud, longitud, currenttemp;
	private double[] lasttemp;
	private int currentrain=0, first=0, last, raincity=0, lastpluja;
	private int[] lastrain;
	private String name; //ERRROR

/**
 * M�tode getter per obtenir la Latitud de l'estaci�
 * @return Latitud
 */
	public double getLatitud() {
		return latitud;
	}
/**
 * M�tode getter per obtenir la Longitud de l'estaci�
 * @returnLongitud
 */
	public double getLongitud() {
		return longitud;
	}
/**
 * M�tode getter per obtenir la temperatura actual de l'estaci�
 * @return temperatura actual
 */
	public double getCurrenttemp() {
		return currenttemp;
	}
/**
 * M�tode getter per obtenir la temperatura dins de la llista dels tres ultims registres de  de l'estaci�
 * @return llista de temperatures de la ciutat
 */
	public double[] getLasttemp() {
		return lasttemp;
	}
/**
 * M�tode getter per obtenir la pluja dins de la llista dels tres ultims registres de  de l'estaci�
 * @return pluja de la llista 
 */
	public int getCurrentrain() {
		return currentrain;
	}
/**
 * M�tode getter per obtenir la primera posici� de la llista de plujes i temperatures de l'estaci�
 * @return priera posicio
 */
	public int getFirst() {
		return first;
	}
/**
 * M�tode getter per obtenir la �ltima posici� de la llista de plujes i temperatures de l'estaci�
 * @return �ltima posici�
 */
	public int getLast() {
		return last;
	}
/**
 * M�tode getter per obtenir la suma de la pluja dins de la llista dels tres �ltims registres de l'estaci�
 * @return suma de la pluja de l'estaci�
 */
	public int getRaincity() {
		return raincity;
	}
/**
 * M�tode getter per obtenir la pluja dins de la llista dels tres ultims registres de  de l'estaci�
 * @return llista de pluja de la ciutat
 */
	public int[] getLastrain() {
		return lastrain;
	}
/**
 * M�tode per obtenir el nom de la ciutat on hi ha l'estaci�
 * @return nom de la ciutat
 */
	public String getName() {
		return name;
	}
/**
 * M�tode getter per otenir la pluja que es va llegint de la taula de plujes per anar sumant la pluja total d'una ciutat
 * @return valor de pluja de la taula de plujes
 */
	public int getLastpluja() {
		return lastpluja;
	}

	
/**
 *	M�tode constructor per crear una nova estaci�
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
 * M�tode per actualitzar el valor de pluja i temperatura d'una estaci�
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
 * M�tode per comparar la pluja de dues estacions
 * @param city
 * @return l'estacio� amb mes pluja
 */
	public Estacions mespluja(Estacions city){
		if (this.raincity>city.raincity) return this;
		else return city;
		}

	
/**
 * M�tode toString
 */
	public String toString(){
		//System.out.println("L'estacio de "+name+" amb latitud: "+latitud+ " i longitud: "+longitud+" la �ltima temperatura resgistrada �s:"+currenttemp+"�C i la ultima pluja registrada �s:"+currentrain+"mm");
		return "L'estacio de "+name+" amb latitud: "+latitud+ " i longitud: "+longitud+" la �ltima temperatura resgistrada �s:"+currenttemp+"�C i la ultima pluja registrada �s:"+currentrain+"mm" ;
	}

}


