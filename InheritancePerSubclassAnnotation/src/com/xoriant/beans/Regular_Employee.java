package com.xoriant.beans;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="regular_emp_5")
@AttributeOverrides({
	@AttributeOverride(name="id",column=@Column(name="emp_id")),
	@AttributeOverride(name="name",column=@Column(name="emp_name"))
})
public class Regular_Employee extends Employee{
	
	@Column(name="salary")
	private float salary;
	
	@Column(name="bonus")
	private int bonus;
	
	public Regular_Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public Regular_Employee(String name, float salary, int bonus) {
		super(name);
		this.salary = salary;
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "Regular_Employee [salary=" + salary + ", bonus=" + bonus + "]";
	}
	

}
