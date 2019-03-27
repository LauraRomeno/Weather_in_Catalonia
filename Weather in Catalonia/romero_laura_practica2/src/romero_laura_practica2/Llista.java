package romero_laura_practica2;

public class Llista {
	private Estacions[] llistaestacions;
	private Estacions[] llistaneu;
	private static int numestacions=0;
	private static int numneu=0;
	
/**
 * Mètode Constructor de Llista
 * @param posicions de la llista
 */
	public Llista(int i){
		llistaestacions=new Estacions[i];
		llistaneu=new Estacions[i];
	}
/**
 * Mètode getter per retorna la llista d'estacions creades	
 * @return lliesta d'estacions
 */
	public Estacions[] getLlistaestacions() {
		return llistaestacions;
	}
/**
 * Mètode getter per retornar la llista de les estacions amb perill de neu
 * @return llista d'estacions amb perill de neu
 */
	public Estacions[] getLlistaneu() {
		return llistaneu;
	}
/**
 * Mètode getter per retornar el numero d'estacions que hi ha creades
 * @return numero d'estacions guardades
 */
	public static int getNumestacions() {
		return numestacions;
	}
/**
 * Mètode getter per retronar el numero d'estacions que hi ha a la llista estacions amb perill de neu
 * @return estacions amb perill de neu (nuemro)
 */
	public static int getNumneu() {
		return numneu;
	}
/**
 * Mètode per afegir una nova ciutat a la llista i ordenarla de major a menor latitud
 * @param latitud
 * @param longitud
 * @param nomciutat
 */
	public void newEstacions(double latitud, double longitud, String nomciutat){
		int bucle=0;
		int estacions=numestacions;
		if (numestacions!=0){
			if (numestacions<llistaestacions.length){
				for(bucle=0; (bucle<numestacions)&&(llistaestacions[bucle].getLatitud()>=latitud); bucle++){ 
				if (llistaestacions[bucle].getLatitud()==latitud){
					while(llistaestacions[bucle].getLongitud()<=longitud){
						bucle++;
					}
					break;}
			}}}

		if (estacions!=0) {
			while(estacions>bucle){
			llistaestacions[estacions]=llistaestacions[(estacions-1)];
			estacions--;
			}}
		llistaestacions[bucle]=new Estacions(latitud, longitud, nomciutat);
		numestacions++;
		}
/**
 * Mètode per bucar una estacio dins de la llista a partir del seu nom i retornar la instància
 * @param nom
 * @return instància
 */
	public Estacions buscar (String nom){
		int i;
		
		for(i=0; i<numestacions; i++){
			if (llistaestacions[i].getName().equals(nom)){ 
				return llistaestacions[i];
			}
		}
		return null;
		
	}
/**
 * Mètode per buscar en quina posició de la llista esta l'estació que es vol eliminar	
 * @param nom
 * @return posició de la llista
 */
public int buscareliminar (String nom){
		int i;
		for(i=0; i<numestacions; i++){
			if (llistaestacions[i].getName().equals(nom)){ 
				return i;
			}
		}
		return -1;
	}
/**
 * mètode per eliminar una estació de la llista i reordenar els restants	
 * @param posició de la llista a eliminar
 */
	public void eliminar(int i){
		
		while(numestacions!=i+1){				//i es la posició de la taula a eliminar
			llistaestacions[i]=llistaestacions[i+1];
			i++;
		}
		llistaestacions[i]=null;
		numestacions--;
	}
/**
 * Mètode per buscar el nom de l'estació que ha enregistrat el valor més alt de pluja	
 * @return nom 
 */
	public String morerain(){
		int i=0, pluja=0, major=0, j, mas=0;
		
		while (i<numestacions-1){
			for(j=0; j<3; j++){
			pluja=llistaestacions[i].getLastrain()[j];
				if (pluja>major) {
					major=pluja;
					mas=i;
				}
			}
			i++;
		}
		return llistaestacions[mas].getName();
}
/**
 * Mètode per sumar el total de pluja dels últims 3 registres de totes les estacions	
 * @return total de pluja
 */
	public int totalpluja(){
		int i=0, j, pluja, total=0;
		
		while (i<numestacions){
			for(j=0; j<3; j++){
			pluja=llistaestacions[i].getLastrain()[j];
					total=total+pluja;
				}
			i++;
			}
		return total;
		}
/**
 * Mètode que buscar la ciutat més al nord on s'han enregistrat temperaures de més de 20ºC
 * @return nom de la ciutat
 */
	public String mesnord(){
		String nom="-";
		int i=0;
		double temp, latitud=0, maxlatitud=0;
				
		while (i<numestacions-1){
			temp=llistaestacions[i].getCurrenttemp();
				if(temp>20) {
					latitud=llistaestacions[i].getLatitud();
					if (latitud>maxlatitud) maxlatitud=latitud;
					nom=llistaestacions[i].getName();
				}
			i++;
		}
		return nom;
	}
/**
 * Mètode que omple la llista d'estacions amb perill de neu	
 * @return llista d'estacions amb perill de neu
 */
	public Estacions[] neu(){
		int i, z=0;

		
		for(i=0; i<(numestacions-1); i++){
			if ((llistaestacions[i].getCurrenttemp()<0)&&(llistaestacions[i].getCurrentrain()>50)){ 
				llistaneu[z]=llistaestacions[i];
				z++;
				numneu++;
			}
		}
		return llistaneu;
		
	}
/**
 * Mètode que coprova dins d'un subconjunt d'estacions si els valors de pluja van en augment
 * @param primer
 * @param ultim
 * @return cert si van en augment i fals si no
 */
	public boolean perillplujes(int primer, int ultim){
		int i, pluja1=0, pluja2;
		
		while(primer<=ultim){
			for (i=0; i<3; i++){
			pluja2=llistaestacions[primer].getLastrain()[i];
			if (pluja2>pluja1) pluja1=pluja2;
			else return false;
			}
			pluja1=0;
			primer++;
		}
		return true;
	}
/**
 * Mètode getter que retorna una estació de la llista d'estacions amb perill de neu	
 * @param i
 * @return estacio amb perill de neu
 */
	public Estacions getEstacio(int i){

		return llistaneu[i];
	}
	
	}
