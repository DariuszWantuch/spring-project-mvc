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



@Entity
public class RepairRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String des;
	private Date date;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TypeOfEquipment> typeOfEquipments;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
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
		return "RepairRequest [id=" + id + ", des=" + des + ", date=" + date + ", typeOfEquipments=" + typeOfEquipments
				+ "]";
	}
	
	
	
	
	
}
