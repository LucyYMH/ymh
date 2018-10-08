package cn.pojo;

import java.util.List;

public class UserVo extends User{
	private List<Car> cars;

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "UserVo [cars=" + cars + ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getBirthday()="
				+ getBirthday() + ", getSex()=" + getSex() + ", getAddress()=" + getAddress() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
