package cn.pojo;

public class Car {
	private int carId;
	private String carName;
	private String userId;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", userId=" + userId + "]";
	}
	
	
}
