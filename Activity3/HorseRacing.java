import java.util.*;
import java.util.stream.*;
public class HorseRacing extends Thread{
	int raceTrackDistance;
	List<Horse> horseCanRace;
	
	HorseRacing (int raceTrackDistance,List<Horse> horseCanRace) {
		this.raceTrackDistance = raceTrackDistance;
		this.horseCanRace = horseCanRace;
		System.out.println("------------Horses------------");
		horseCanRace.stream()
			.forEach(horse -> System.out.println("Horse(#" + horse.getHorseNumber() + ")\t\t" + horse.getHorseName()+ "\t\t" + horse.getHealth()));
	}
	
	public void run() {
		try{
			
			Race.preperation(horseCanRace);
			Thread.sleep(1000);
			System.out.println("\nStart the Horse Race");
			Thread.sleep(1000);
			for (int i = 3; i > 0 ; i--) {
				Thread.sleep(1000);
				System.out.println("Race will start in " + i);
			}
			Thread.sleep(1000);
			System.out.println("Go!!");
			Race.startTheRace(horseCanRace,this.raceTrackDistance);
		} catch (Exception e) {}
	}
	
	
}