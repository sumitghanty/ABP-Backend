package  com.mazars.in.model.mastermodel;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mazars.in.model.transactionmodel.LineItem;


@Entity
@Table(name="tbl_trip_master")

public class TripMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	
	private long id;
	
	@Column(name="total")
	private double total;
	
	
	private String name;
	
	//@OneToMany(mappedBy="cart1",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "cart_id",nullable=false)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "trip",cascade = CascadeType.ALL)
	private Set<LineItem> items1;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<LineItem> getItems1() {
		return items1;
	}
	public void setItems1(Set<LineItem> items1) {
		this.items1 = items1;
	}
	
	
}

