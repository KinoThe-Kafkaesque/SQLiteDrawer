package two.one.sqlitedrawer.classes;

import java.util.Date;

public class Machine {

	private int id;
	private String reference;
	private String marque;
	
	public Machine() {
		
	}

	public Machine(String reference, String marque) {
		this.reference = reference;
		this.marque = marque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}



	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", reference=" + reference + ", dateAchat=" + ", marque=" + marque + "]";
	}
	
	
	

}
