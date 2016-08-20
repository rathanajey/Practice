import java.util.*;
class FlightTime  implements Comparable {
	boolean isTakeOff;
	int time;
	public FlightTime(int time, boolean isto) {
		this.time = time;
		this.isTakeOff = isto;
	}
	@Override
	public int compareTo(Object arg0) {
		return this.time - ((FlightTime)arg0).time;
	}
}
public class FlightTracker {
	int maxAir2(Flight[] flights) {
		ArrayList<FlightTime> flightTimeLine = new ArrayList<FlightTime>();
		for(Flight f:flights){
			flightTimeLine.add(new FlightTime(f.takeoff,true));
			flightTimeLine.add(new FlightTime(f.landing,false));
		}
		Collections.sort(flightTimeLine);
		int currentInAir = 0;
		int maxInAir =0;
		for(FlightTime t:flightTimeLine) {
			if(t.isTakeOff) {
				currentInAir++;
			} else {
				currentInAir--;
			}
			if(currentInAir>maxInAir) {
				maxInAir = currentInAir;
			}
		}
		return maxInAir;
	}

	int maxAir(Flight[] flights){
		int arrLength=2*flights.length;
		int[] arr=new int[arrLength];
		int i=0;
		for(Flight f:flights){
			arr[i++]=f.takeoff;
			arr[i++]=f.landing;
		}
		Arrays.sort(arr);
		System.out.println(arr);
		for(int j:arr){
			System.out.println(j);
		}
		int max=0, inAir=0;
		for(i=0;i<arrLength;i++){
			for(Flight f:flights){
				if(f.takeoff==arr[i]){
					inAir++;
					if(inAir>max) max=inAir;
				}
				else if(f.landing==arr[i]) inAir--;
			}
			
		}
		return max;
	}
	
	
	public static void main(String args[]){
		Flight a=new Flight(1,10);
		Flight b=new Flight(8,12);
		Flight c=new Flight(5,15);
		Flight[] flights={a,b,c};
		FlightTracker ft=new FlightTracker();
		int max=ft.maxAir2(flights);
		System.out.println("Max number of flights in air="+max);
	}
}
