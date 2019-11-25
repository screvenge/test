package com.study.model.car;

/**
 * a_car_component javaModel
 *
 */
public class CarComponent {

	private Long compId;

	private Long carId;

	private Integer light;

	private Integer mirror;

	private Integer door;

	private Integer window;

	private Integer engine;

	private Integer battery;

	private Integer bumper;

	private Integer brake;

	private Integer tire;

	private Integer chassis;

	private Integer turn;

	private Integer horn;

	private String checkTime;

	private Integer enterStore;

	private Long checkStaffId;

	public Long getCompId() {
		return compId;
	}

	public void setCompId(Long compId) {
		this.compId = compId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Integer getLight() {
		return light;
	}

	public void setLight(Integer light) {
		this.light = light;
	}

	public Integer getMirror() {
		return mirror;
	}

	public void setMirror(Integer mirror) {
		this.mirror = mirror;
	}

	public Integer getDoor() {
		return door;
	}

	public void setDoor(Integer door) {
		this.door = door;
	}

	public Integer getWindow() {
		return window;
	}

	public void setWindow(Integer window) {
		this.window = window;
	}

	public Integer getEngine() {
		return engine;
	}

	public void setEngine(Integer engine) {
		this.engine = engine;
	}

	public Integer getBattery() {
		return battery;
	}

	public void setBattery(Integer battery) {
		this.battery = battery;
	}

	public Integer getBumper() {
		return bumper;
	}

	public void setBumper(Integer bumper) {
		this.bumper = bumper;
	}

	public Integer getBrake() {
		return brake;
	}

	public void setBrake(Integer brake) {
		this.brake = brake;
	}

	public Integer getTire() {
		return tire;
	}

	public void setTire(Integer tire) {
		this.tire = tire;
	}

	public Integer getChassis() {
		return chassis;
	}

	public void setChassis(Integer chassis) {
		this.chassis = chassis;
	}

	public Integer getTurn() {
		return turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public Integer getHorn() {
		return horn;
	}

	public void setHorn(Integer horn) {
		this.horn = horn;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public Integer getEnterStore() {
		return enterStore;
	}

	public void setEnterStore(Integer enterStore) {
		this.enterStore = enterStore;
	}

	public Long getCheckStaffId() {
		return checkStaffId;
	}

	public void setCheckStaffId(Long checkStaffId) {
		this.checkStaffId = checkStaffId;
	}

	@Override
	public String toString() {
		return "CarComponent [compId=" + compId + ", carId=" + carId + ", light=" + light + ", mirror=" + mirror
				+ ", door=" + door + ", window=" + window + ", engine=" + engine + ", battery=" + battery + ", bumper="
				+ bumper + ", brake=" + brake + ", tire=" + tire + ", chassis=" + chassis + ", turn=" + turn + ", horn="
				+ horn + ", checkTime=" + checkTime + ", enterStore=" + enterStore + ", checkStaffId=" + checkStaffId
				+ "]";
	}
	
}
