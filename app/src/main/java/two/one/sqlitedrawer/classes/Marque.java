package two.one.sqlitedrawer.classes;

import java.util.List;


public class Marque {
	private long id;
	private String code;
	private String libelle;

	public Marque() {
		
	}

	public Marque(long id, String code, String libelle, List<Machine> machines) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}

    public Marque(String code, String libelle) {
		this.code = code;
		this.libelle = libelle;
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
