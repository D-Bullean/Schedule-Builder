/**
 * 
 */


import java.util.Random;

/**
 * @author Jack Lemmenes
 * 
 *         Testing for classes
 *
 */
public class main
{

	public static void main(String[] args)
	{

		int _NUMBER_OF_TESTS = 1000;
		
		Schedule finalsc = Schedule.getInstance();
		Employee Jack = new Employee("Jack");
//		Employee Dylan = new Employee("Dylan");
//		Employee DG3 = new Employee("DG3");
//		Employee Beer = new Employee("Beer");
//		Employee Carter = new Employee("Carter");
//		Employee Garret = new Employee("Garret");
//		Employee Akhil = new Employee("Ahkil");
//		Employee Vishal = new Employee("Vishal");
//		Employee Colin = new Employee("Colin");

		Random rng = new Random();
		// days and hours both start at zero
		// set hours 2 to 5, including 5, to be true on day 3
	//	Employee[] Staff =
	//	{ Jack, Dylan, DG3, Beer, Carter, Garret, Akhil, Vishal, Colin };
		
		Employee KellyAnn = new Employee("Kelly Ann");
		Employee Nick = new Employee("Nick Todd");
		Employee Spencer = new Employee("Spencer");
		Employee Matt = new Employee("Matt");
		Employee Jacob = new Employee("Jacob");
		Employee David = new Employee("David");
		Employee Ben = new Employee("Ben");
		
		Employee[] Sample1 = {Jack, KellyAnn, Nick, Spencer, Matt, Jacob, David, Ben};
		
		//[0,1,2, 3,  4,5,6,7,8,9, 10,11,12]
		//[8,9,10,11,12,1,2,3,4,5,6,7,8,9]
		
		Jack.setHoursTrue(0, 0, 0);
		Jack.setHoursTrue(0, 3, 5);
		Jack.setHoursTrue(0, 6, 13);
			
		Jack.setHoursTrue(1, 0, 13);
		Jack.setHoursFalse(1, 7, 9);
		
		Jack.setHoursTrue(2, 0, 0);
		Jack.setHoursTrue(2, 3, 5);
		Jack.setHoursTrue(2, 6, 12);
		
		Jack.setHoursTrue(3, 0, 13);
		Jack.setHoursFalse(3, 7, 9);
		Jack.setHoursFalse(3, 2, 6);
		
		Jack.setHoursTrue(4, 0, 13);
		Jack.setHoursFalse(4, 0, 0);
		Jack.setHoursFalse(4, 5, 5);
		
		
		
		KellyAnn.setHoursTrue(0, 0, 6);
		
		KellyAnn.setHoursTrue(1, 0, 3);
		
		KellyAnn.setHoursTrue(2, 0, 6);
		
		KellyAnn.setHoursTrue(3, 0, 3);
		KellyAnn.setHoursTrue(3, 11,13);
		
		KellyAnn.setHoursTrue(4, 0, 12);
		KellyAnn.setHoursFalse(4, 5, 5);
		
		
		//[0,1,2, 3,  4,  5,6,7,8,9, 10,11, 12, 13]
		//[8,9,10,11, 12, 1,2,3,4,5, 6, 7,  8,  9]
		
		Nick.setHoursTrue(0, 0, 13);
		Nick.setHoursFalse(0, 4, 4);
		
		Nick.setHoursTrue(1, 0, 13);
		Nick.setHoursFalse(1, 4, 8);
		Nick.setHoursFalse(1, 9, 10);
		Nick.setHoursFalse(1, 13, 13);
		
		Nick.setHoursTrue(2, 0, 13);
		Nick.setHoursFalse(2, 4, 4);
		
		Nick.setHoursTrue(3, 0, 13);
		Nick.setHoursFalse(3, 4, 8);
		Nick.setHoursFalse(3, 9, 10);
		
		Nick.setHoursTrue(4, 0, 13);
		Nick.setHoursFalse(4, 4, 4);
		
		
		Spencer.setHoursTrue(0, 3, 5);
		Spencer.setHoursTrue(0, 9, 12);
		
		Spencer.setHoursTrue(1, 4, 12);
		
		Spencer.setHoursTrue(2, 3, 5);
		Spencer.setHoursTrue(2, 9, 12);
		
		Spencer.setHoursTrue(3, 4, 12);
		
		Spencer.setHoursTrue(4, 3, 12);
		
		//[0,1,2, 3,  4,  5,6,7,8,9, 10,11, 12, 13]
		//[8,9,10,11, 12, 1,2,3,4,5, 6, 7,  8,  9]
		
		Matt.setHoursTrue(0, 10, 13);
		
		Matt.setHoursTrue(1, 0, 13);
		
		Matt.setHoursTrue(2, 10, 13);
		
		Matt.setHoursTrue(3, 0, 13);
		
		Matt.setHoursTrue(4, 0, 13);
		
		
		Jacob.setHoursTrue(0, 6, 8);
		
		Jacob.setHoursTrue(1, 6, 7);
		
		Jacob.setHoursTrue(2, 10, 11);
		
		Jacob.setHoursTrue(3, 6, 11);
		
		Jacob.setHoursTrue(4, 7, 13);
		
		//[0,1,2, 3,  4,  5,6,7,8,9, 10,11, 12, 13]
		//[8,9,10,11, 12, 1,2,3,4,5, 6, 7,  8,  9]
		
		David.setHoursTrue(0, 2, 2);
		David.setHoursTrue(0, 4, 5);
		David.setHoursTrue(0, 8, 12);
		
		David.setHoursTrue(1, 1, 3);
		David.setHoursTrue(1, 5, 8);
		David.setHoursTrue(1, 11, 12);
		
		David.setHoursTrue(2, 5, 12);
		
		David.setHoursTrue(3, 2, 3);
		David.setHoursTrue(3, 5, 8);
		David.setHoursTrue(3, 11, 12);
		
		David.setHoursTrue(4, 3, 5);
		David.setHoursTrue(4, 8, 12);
		
		Ben.setHoursTrue(0, 9, 13);
		
		Ben.setHoursTrue(1, 6,13);
		
		Ben.setHoursTrue(2, 10, 13);
		
		Ben.setHoursTrue(3, 6, 13);
		
		Ben.setHoursTrue(4, 3, 13);
		
		
		// //Monday
		// Staff[rng.nextInt(8)].setHoursTrue(0,0,4);
		// Staff[rng.nextInt(8)].setHoursTrue(0,2,8);
		// Staff[rng.nextInt(8)].setHoursTrue(0,0,rng.nextInt(7));
		// Staff[rng.nextInt(8)].setHoursTrue(0,0,4);
		// Staff[rng.nextInt(8)].setHoursTrue(0,4,12);
		//
		// //Tuesday
		// Staff[rng.nextInt(8)].setHoursTrue(01,0,4);
		// Staff[rng.nextInt(8)].setHoursTrue(01,2,10);
		// Staff[rng.nextInt(8)].setHoursTrue(01,0,rng.nextInt(12));
		// Staff[rng.nextInt(8)].setHoursTrue(01,0,rng.nextInt(12));
		// Staff[rng.nextInt(8)].setHoursTrue(01,8,12);
		//
		// //Wednesday
		// Staff[rng.nextInt(8)].setHoursTrue(02,0,12);
		// Staff[rng.nextInt(8)].setHoursTrue(02,0,rng.nextInt(12));
		// Staff[rng.nextInt(8)].setHoursTrue(02,0,rng.nextInt(12));
		// Staff[rng.nextInt(8)].setHoursTrue(02,0,rng.nextInt(12));
		//
		// //Thursday
		// Staff[rng.nextInt(8)].setHoursTrue(03,0,rng.nextInt(12));
		// Staff[rng.nextInt(8)].setHoursTrue(03,0,rng.nextInt(12));
		// Staff[rng.nextInt(8)].setHoursTrue(03,0,rng.nextInt(12));
		//
		// //Friday
		// Staff[rng.nextInt(8)].setHoursTrue(04,0,rng.nextInt(10));
		// Staff[rng.nextInt(8)].setHoursTrue(04,0,rng.nextInt(10));
		// Staff[rng.nextInt(8)].setHoursTrue(04,0,rng.nextInt(10));
		// Staff[rng.nextInt(8)].setHoursTrue(04,0,10);
		// Staff[rng.nextInt(8)].setHoursTrue(04,0,rng.nextInt(10));
		//
		//
		
//		int[] totalHours = new int[Staff.length];
//		double[] avgHours = new double[Staff.length]; 
//		
//		for (int k = 0; k < _NUMBER_OF_TESTS; k++)
//		{
//
//			for (Employee scrub : Staff)
//			{
//				for (int i = 0; i < 5; i++)
//				{
//					for (int j = 0; j < 13; j++)
//					{
//						//boolean prefVAvail = rng.nextBoolean();
//
//						scrub.setHoursTrue(i, j, j);
//
//						if (rng.nextBoolean())
//						{
//							scrub.setHoursFalse(i, j, j);
//						} else
//						{
//							if (rng.nextBoolean())
//								scrub.setPrefTrue(i, j, j);
//						}
//					}
//				}
//			}
		finalsc.buildSchedule();
		System.out.println();
		System.out.println(Schedule._empList);
		System.out.println(finalsc.printSchedule());
//			
//			for(int h = 0; h < Staff.length; h++)
//			{
//				totalHours[h] += Staff[h]._hoursWorking;
//			}
//			
//		}
//		
//		System.out.println();
//		System.out.println("AVERAGE HOURS AFTER " + _NUMBER_OF_TESTS + " TESTS WITH RANDOMIZED INPUT");
//		for(int i = 0; i < Staff.length; i++)
//		{
//			avgHours[i] = totalHours[i] / (double)_NUMBER_OF_TESTS;
//			System.out.println(Staff[i].toString() + ": " + avgHours[i]);
//		}

	}

}
