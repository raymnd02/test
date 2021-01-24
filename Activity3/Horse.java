public class Horse {
	private int horseNumber;
	private String horseName;
	private String health;
	private String warcry;
	private int distance;
	private int steps;
	private int position = 0;
	
	Horse (int horseNumber,String health) {
		this.horseNumber = horseNumber;
		this.health = health;
	}
	
	public int getHorseNumber () {
		return this.horseNumber;
	}
	public String getHorseName () {
		return this.horseName;
	}
	public void setHorseName(String name) {
		this.horseName = name;
	}
	public String getHealth () {
		return this.health;
	}
	public String getHorseWarcry () {
		return this.warcry;
	}
	public void setHorseWarcry (String warcry) {
		this.warcry = warcry;
	}
	public void setHorsePosition (int position) {
		this.position = position;
	}
	public int getHorsePosition () {
		return this.position;
	}
	
	public void setDistance (int distance) {
		this.distance = distance;
	}
	public int getDistance () {
		return this.distance;
	}
	public void setSteps (int steps) {
		this.steps = steps;
	}
	public int getSteps () {
		return this.steps;
	}
}