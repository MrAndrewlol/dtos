/**
 * @author MrAndrewlol
 *
 */
public class Radio implements IRadio {


	boolean encendidoapagado;
	String Frequence;
	double FMActualStation;
	int AMActualStation;
	int[] listasaveAM = new int[12];
	double[] listasaveFM = new double[12];
	


	public Radio(){
		encendidoapagado = false;
		Frequence = "";
		FMActualStation = 87.9;
		AMActualStation = 530;
		listasaveAM[0] = 1;
		listasaveFM[0] = 1;
		
		
	}


	public Radio(String Frequence, boolean encendidoapagado, double FMActualStation, int AMActualStation, int[] listasaveAM, double[] listasaveFM){
		this.encendidoapagado = encendidoapagado;
		this.Frequence = Frequence;
		this.FMActualStation = FMActualStation;
		this.AMActualStation = AMActualStation;
		this.listasaveAM = listasaveAM;
		this.listasaveFM = listasaveFM;


	}


	public boolean isEncendidoapagado() {
		return this.encendidoapagado;
	}

	public boolean getEncendidoapagado() {
		return this.encendidoapagado;
	}

	public void setEncendidoapagado(boolean encendidoapagado) {
		this.encendidoapagado = encendidoapagado;
	}

	public String getFrequence() {
		return this.Frequence;
	}

	public int[] getListasaveAM() {
		return this.listasaveAM;
	}

	public void setListasaveAM(int[] listasaveAM) {
		this.listasaveAM = listasaveAM;
	}

	public double[] getListasaveFM() {
		return this.listasaveFM;
	}

	public void setListasaveFM(double[] listasaveFM) {
		this.listasaveFM = listasaveFM;
	}

	
	
	
	public void on(){
		setEncendidoapagado(true);
		
	}
	

	public void off(){
		setEncendidoapagado(false);

		

	}
	
	/***
	 * Este metodo nos indica si la radio esta encendida o apagada
	 * @return true si la radio esta encendida y false cuando la radio este apagada
	 */
	public boolean isOn(){

		boolean estado;

		estado = getEncendidoapagado();

		return estado; 
		
	}
	
	/***
	 * Este metodo nos ayuda a establecer la frecuencia, recibe un parametro llamado freq que puede "AM" o "FM"
	 * @param freq La frecuencia la cual puede ser AM o FM, de lo contrario error.
	 */
	public void setFrequence(String freq) throws Exception{

			switch(freq){
				case "AM":{
					this.Frequence = "AM";
					setAMActualStation(530);
					break;
				}
	
				case "FM":{
					this.Frequence = "FM";
					setFMActualStation(87.9);
					break;
				}
	
				default:{
					freq = getFrequence() ;
					break;
				}
			}
	}

	
	public void Forward(){
		switch(getFrequence()){
			case "AM":{
				if (getAMActualStation() < 1610){
					AMActualStation = getAMActualStation() + 10;
					setAMActualStation(AMActualStation);
				}
				else{
					setAMActualStation(530);
				}

			}


			case "FM":{
				if (getFMActualStation() < 107.9){
					FMActualStation = getFMActualStation() + 0.2;
					setFMActualStation(FMActualStation);
				}
				else{
					setFMActualStation(87.9);
				}

			}
		}
	}
	
	public void Backward(){
		switch(getFrequence()){
			case "AM":{
				if (getAMActualStation() > 530){
					AMActualStation = getAMActualStation() - 10;
					setAMActualStation(AMActualStation);
				}
				else{
					setAMActualStation(1610);
				}
			}


			case "FM":{
				if (getFMActualStation() > 87.9){
					FMActualStation = getFMActualStation() - 0.2;
					setFMActualStation(FMActualStation);
				}
				else{
					setFMActualStation(107.9);
				}

			}
		}

	}
	
	public double getFMActualStation(){
		return this.FMActualStation;}
	
	public int getAMActualStation(){
		return this.AMActualStation;}
	
	//Regresa el la estacion a FM
	public void setFMActualStation(double actualStation){
		this.FMActualStation = actualStation;

	}
	
	//Regresa la estacion a AM con frecuencia
	public void setAMActualStation(int actualStation){
		this.AMActualStation = actualStation;

	}

	
	
	public void saveFMStation(double actualStation, int slot){
		listasaveFM[slot] = actualStation;
		
		

	}
	
	public void saveAMStation(int actualStation, int slot){
		listasaveAM[slot] = actualStation;

	}
	
	public double getFMSlot(int slot){
		try {
			if (listasaveFM[slot-1] < 87.9 || listasaveFM[slot-1] > 107.9){
				setFMActualStation(87.9);
			}
			setFMActualStation(listasaveFM[slot-1]);
			
		} catch (Exception e) {
			System.out.println("Espacio disponible.");
		}
		return listasaveFM[slot-1];

	}
	
	public int getAMSlot(int slot){
		try {
			if (listasaveAM[slot-1] < 530 || listasaveAM[slot-1] > 1610){
				setAMActualStation(530);
			} else{
				setAMActualStation(listasaveAM[slot-1]);
			}
			
		} catch (Exception e) {
			System.out.println("Espacio disponible.");
		}
		return listasaveAM[slot-1];
	}
}


  