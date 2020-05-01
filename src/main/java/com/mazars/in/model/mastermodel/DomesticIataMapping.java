/***
 * 
 * @author User samit tiwary
 * date 12032020
 * @The table will be used to maintain the Sub Organization of the Company 
 * of the account of instance. ABPL, BOPL, ABP etc
 * 
 * 
 */

package  com.mazars.in.model.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tbl_domestic_iata_mapping")
public class DomesticIataMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id")
	private int id;
	
	@Column(name="city")
	private String city;
	
	@Column(name="iata")
	private String iata;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	
	
	
	
	
}
