package com.project.ministre.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Citoyen")
public class Citoyen {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long id;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String firstName;
	private String lastName;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String adresse;
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepermis() {
		return codepermis;
	}

	public void setCodepermis(String codepermis) {
		this.codepermis = codepermis;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getInfractions() {
		return infractions;
	}

	public void setInfractions(String infractions) {
		this.infractions = infractions;
	}



	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String codepermis;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String matricule;
	
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String infractions;
	
	
	public Citoyen() {}
	
	public Citoyen(String firstName, String lastName, String adresse, String codepermis, String matricule, String infractions) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adresse = adresse;
		this.codepermis = codepermis;
		this.matricule = matricule;
		this.infractions = infractions;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", adresse=" + adresse
				+ ", codepermis="+ codepermis+ ",matricule="+matricule+", infractions="+infractions+"]";
	}	
}
