package es.jllopezalvarez.programacion.ut14.ejercicios.ejercicios03_04_05;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Customer implements Serializable {

	private static final long serialVersionUID = 7523595216710542017L;

	private int id;
	private int storeId;
	private String firstName;
	private String lastName;
	private String email;
	private int addressId;
	private boolean active;
	private Timestamp createDate;
	private Timestamp lastUpdate;

	public Customer(int id, int storeId, String firstName, String lastName, String email,
			int addressId, boolean active, Timestamp createDate, Timestamp lastUpdate) {
		this.id = id;
		this.storeId = storeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.addressId = addressId;
		this.active = active;
		this.createDate = createDate;
		this.lastUpdate = lastUpdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public int getStoreId() {
		return storeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getAddressId() {
		return addressId;
	}

	public boolean isActive() {
		return active;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

}
