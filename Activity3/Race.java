import java.util.*;
import java.util.stream.*;
public class Race {
	private static Map<Integer,Horse> ranking = new LinkedHashMap<> ();
	public static void preperation(List<Horse> horseCanRacePreperation)  throws InterruptedException {
		// Thread.sleep(2000);
		int lastHorseInRacing = 0;
		
			
			System.out.println("\n\t\t\tHorses are moving to the track...");
			horseCanRacePreperation.parallelStream()
				.forEach(horsePreperation -> {
					do {
					int step = (1 + (int) (Math.random() * 10));
					horsePreperation.setDistance(Checker.stepChecker(horsePreperation.getDistance(),step,75));
					horsePreperation.setSteps(step);
					
			       
					String line = "";
					String distanceFromStable = "";
					for (int i = 0; i < horsePreperation.getDistance(); i++) {
						line += "-";
					}
					for (int k = 0;k < 75; k++) {
						distanceFromStable += " ";
					}
					distanceFromStable += "Race Track";
					if (horsePreperation.getDistance() >= 75) {
						distanceFromStable += " (ready)" + horsePreperation.getHorseName();
					}
					System.out.println("Horse #" + horsePreperation.getHorseNumber() + 
						" (Stable)" + line + ">" + 
						distanceFromStable.substring(horsePreperation.getDistance()));
						
					
				
					} while(horsePreperation.getDistance() < 75);
				});

				
			
		horseCanRacePreperation.stream()
				.forEach(horse -> horse.setDistance(0));
	}
	
	public static void startTheRace (List<Horse> horseCanRace,int trackDistance) throws InterruptedException {	
		// Thread.sleep(2000);
		int lastHorseInRacing = 0;
			// Thread.sleep(400);
			System.out.println("\n\t\t\tRacing Status...\n");
			 horseCanRace.parallelStream()
				.forEach(horse -> {
					
		do {
					int steps = (1 + (int) (Math.random() * 10));
					String status = "";
					horse.setDistance(Checker.stepChecker(horse.getDistance(),steps,trackDistance));
					horse.setSteps(steps);
					if(horse.getDistance() == trackDistance && horse.getHorsePosition() == 0) {
						horse.setHorsePosition(1);
						ranking.put(horse.getHorseNumber(),horse);
					}
					String line = "";
					String distance = "";
					// System.out.println(horse.getHorseName());
					for (int i = 0; i < horse.getDistance(); i++) {
						line += "-";
					}
					for (int k = 0;k < trackDistance; k++) {
						distance += " ";
					}
					distance += "Finish Line";
					if (horse.getDistance() >= trackDistance) {
						distance += " (finish)" + horse.getHorseName();
					}
					if (horse.getDistance() == trackDistance) {
						status = ")\t->\tFinish!!!\n";
					} else {
						status = ")\t->\tTraveled: " + horse.getSteps() + " meter, Distance: " + horse.getDistance() + " meter\n";
					}
					
					System.out.println( horse.getHorseName() + "(#" + 
						horse.getHorseNumber() + status + 
						"Horse #" + horse.getHorseNumber() + 
						" (Starting point)" + line + ">" + 
						distance.substring(horse.getDistance()));
						
						
		} while(horse.getDistance() < trackDistance);
				});
				
			System.out.println();
				
			// Horse lastHorse = horseCanRace.stream()
				// .min(Comparator.comparing(Horse::getDistance))
				// .get();
				
			// lastHorseInRacing = lastHorse.getDistance();
		
		
		int rank = 1;
		String victoryCry = "";
		for (Map.Entry<Integer, Horse> entry : ranking.entrySet()) {
			if (rank == 1) {
				victoryCry = "\n\nHorse(#" + entry.getValue().getHorseNumber() + ") " + entry.getValue().getHorseName() + 
					" won the race\nShouted his warcry: " + entry.getValue().getHorseWarcry() + "!!!";
				System.out.println(victoryCry);
				
				
				System.out.println("\n\n\t\t---Ranking---\n");
			}
			
			System.out.println("\t" + rank + "\t\t" + 
				entry.getValue().getHorseName() + "(#" + 
				entry.getValue().getHorseNumber() + ")" );
			
			rank += 1;
		}
		
	}
}