package oppgave3;


public class Ansatt {

	String fornavn;
	String etternavn;
	Kjonn kjonn;
	String stilling;
	double aarslonn;
	
	public Ansatt(String fornavn, String etternavn, Kjonn kjonn, String stilling, double aarslonn) {
		
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.stilling = stilling;
		this.aarslonn = aarslonn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Kjonn getKjonn() {
		return kjonn;
	}

	public void setKjonn(Kjonn kjonn) {
		this.kjonn = kjonn;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public double getAarslonn() {
		return aarslonn;
	}

	public void setAarslonn(double aarslonn) {
		this.aarslonn = aarslonn;
	}
	
	public String toString() {
		return ("\nfornavn: " + fornavn + ", etternavn: " + etternavn + ", årslønn: " + aarslonn);
	}
	
}
