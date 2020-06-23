package pl.project.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "repair")
public class RepairRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String describe;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<TypeOfEquipment> typeOfEquipments;
	
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<TypeOfEquipment> getTypeOfEquipments() {
		return typeOfEquipments;
	}
	public void setTypeOfEquipments(List<TypeOfEquipment> typeOfEquipments) {
		this.typeOfEquipments = typeOfEquipments;
	}
	@Override
	public String toString() {
		return "RepairRequest [id=" + id + ", describe=" + describe + ", date=" + date + ", typeOfEquipments="
				+ typeOfEquipments + "]";
	}
}
