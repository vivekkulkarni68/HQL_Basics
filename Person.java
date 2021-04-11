
import java.util.*;

public class Person {
	String firstName;
	String lastName;
	Long id;
	Address homeAddress;
	Address shippingAddress;
	Person(){}
	Person(String first,String last){
		this.firstName = first;
		this.lastName = last;
	}
	
	public String toString(){
		return "Name : "+this.firstName+"  "+this.lastName+"\nHome Address= "+homeAddress+"\nShipping Addr= "+shippingAddress ;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
		this.homeAddress.setUser(this);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
		this.shippingAddress.setUser(this);
	}
	

}
