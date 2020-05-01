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
@Table(name="tbl_activehotels")
public class ActiveHotels {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id")
	private int id;
	
	@Column(name="hotelcode")
	private int hotelcode;	
	
	@Column(name="hotelid")
	private long hotelid;	
	
	@Column(name="hotelname")
	private String hotelname;	
	
	@Column(name="country")
	private String country;	
	
	@Column(name="state")
	private String state;	
	
	@Column(name="city")
	private String city;	
	
	@Column(name="cityid")
	private long cityid;

	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHotelcode() {
		return hotelcode;
	}

	public void setHotelcode(int hotelcode) {
		this.hotelcode = hotelcode;
	}

	public long getHotelid() {
		return hotelid;
	}

	public void setHotelid(long hotelid) {
		this.hotelid = hotelid;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getCityid() {
		return cityid;
	}

	public void setCityid(long cityid) {
		this.cityid = cityid;
	}

	
}
