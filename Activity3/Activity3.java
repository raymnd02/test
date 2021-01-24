import java.util.*;
import java.util.stream.Collectors;
public class Activity3 {
	public static void main (String [] Args) {
		Scanner sc = new Scanner(System.in);
		int raceTrack;
		int numberOfHorses;
		long numberOfHealthyHorse;
		List<Horse> horses = new ArrayList<>();
		List<Horse> horseCanRace;
		System.out.println("\n\n==================== Welcome to the horse racing game =========================\n");
		
		do {
			horses.clear();
			System.out.println("Enter the distance of the race track. - (Minimum of 50)");

			raceTrack = Checker.inputChecker(sc,"Distance of the race track: ",50);

			System.out.println("Enter the number of horses to race. - (between 3 to 10)");
			numberOfHorses = Checker.inputChecker(sc,"Number of horses: ",3,10);
			sc.nextLine();
			for (int i = 0; i < numberOfHorses; i++) {
				horses.add(new Horse(
					i+1,
					(int)(Math.random() * 101) < 76 ? "Healthy" : "Sick"
				));
			}
			System.out.println("\n---------------   The status of the Horses ---------------\n");
			horses.stream()
				.forEach(horse -> System.out.println("\t\tHorse(#" + horse.getHorseNumber() + ")\t\t" + horse.getHealth()));
			
			
			horseCanRace = horses.stream()
				.filter(horse -> horse.getHealth().equals("Healthy"))
				.collect(Collectors.toList());
			
			numberOfHealthyHorse = horseCanRace.size();				
			
			System.out.println("");
			System.out.println(horseCanRace.size() < 3 ? "Most of the horses are sick, Try again!!." : "-----------   " + horseCanRace.size() + " horses can enter the track!!!   -----------");
			System.out.println("");
		} while (horseCanRace.size() < 3);
		horseCanRace.stream()
			.forEach(horse -> {
				System.out.println("\nEnter detail of horse #" + horse.getHorseNumber());
				System.out.print("Enter Horse name: ");
				String horseName = sc.nextLine();
				System.out.print("Enter warcry: ");
				String warcry = sc.nextLine();
				horse.setHorseName(horseName);
				horse.setHorseWarcry(warcry);
			});
			System.out.println("");
		HorseRacing race = new HorseRacing(raceTrack,horseCanRace);
		race.start();
	}
}