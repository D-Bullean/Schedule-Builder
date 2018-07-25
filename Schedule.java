

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Jack Lemmenes Takes all the employees availabilities and preferences
 *         and creates one final schedule
 *
 */

public class Schedule
{

	// DATA
	// promotes tight coupling....
	protected static int _NUMBER_OF_DAYS = 5; // should be final?
	protected static int _NUMBER_OF_HOURS = 14; // should be final?
	protected static Random _RANDOM = new Random();

	protected static Schedule sc = new Schedule();
	protected static ArrayList<Employee> _empList = new ArrayList<Employee>();
	protected static String[][] _finalSchedule = new String[_NUMBER_OF_DAYS][_NUMBER_OF_HOURS];
	protected static String[][] _totalPref = new String[_NUMBER_OF_DAYS][_NUMBER_OF_HOURS];

	// constructor
	private Schedule()
	{

	}

	// static instance
	public static Schedule getInstance()
	{
		if (sc == null)
		{
			sc = new Schedule();
		}
		return sc;
	}

	/*
	 * This function makes the final automatic modifications to the final
	 * schedule array It loops through the employees and sets who can work for
	 * each hour, First off of employee preference, then based off of employee
	 * availability.
	 * 
	 * Next, the schedule handles the overlap for each hour individually It
	 * checks to see who has the least amount of hours currently slated to just
	 * them and checks the number of the most amount of hours currently being
	 * worked by any one employee. Any overlap containing the employee with the
	 * lowest amount of hours is given to that employee until they reach the
	 * amount of hours of the previous max + 1, or iterate through the entire
	 * schedule. That stage is looped until the schedule is completed.
	 */
	public void buildSchedule()
	{
		for (Employee em : _empList)
		{
			// initial round of entering data with minor processing
			// preferences and availability are handled
			// if certain employees are preferred over others that have the same
			// availability
			// only they the take over the time period
			for (int i = 0; i < _NUMBER_OF_DAYS; i++)
			{
				for (int j = 0; j < _NUMBER_OF_HOURS; j++)
				{
					// first the preference array must be updated
					if (em._employer_preference[i][j])
					{
						if (_totalPref[i][j] == null)
						{
							_totalPref[i][j] = em.toString();
						} else
						{
							_totalPref[i][j] += "," + em.toString();
						}

						if (_finalSchedule[i][j] == null)
						{
							_finalSchedule[i][j] = em.toString();
						} else
						{
							_finalSchedule[i][j] += "," + em.toString();
						}
					}

					if (em._availability[i][j] && (_totalPref[i][j] == null))
					{
						if (_finalSchedule[i][j] == null)
						{
							_finalSchedule[i][j] = em.toString();
						} else
						{
							_finalSchedule[i][j] += "," + em.toString();
						}
					}
				}
			}
		}

		int max = -1;
		int sum;
		do
		{

			// set the hour values after everyone has been
			for (Employee em : _empList)
			{
				em.setHoursWorking(sc);
			}

			// minimize the shared hours among
			int[] shardHours = new int[_empList.size()];
			int[] workingHours = new int[_empList.size()];

			for (int i = 0; i < _empList.size(); i++)
			{
				shardHours[i] = _empList.get(i)._sharedHours;
				workingHours[i] = _empList.get(i)._hoursWorking;
			}

			int min = 0;
			max = min;
			int index = 0;

			// find the employee with the least hours and most amount of hours
			// worked by one employee
			// this is to compare the max working with the guy working the least
			// as he gets more hours added on
			for (int i = 0; i < _empList.size(); i++)
			{
				if (i == 0)// && shardHours[0] != 0)
				{
					min = workingHours[i];
					max = workingHours[i];
				} else if (min >= workingHours[i] && shardHours[i] > 0)
				{
					// if the employee with the least amount of hours also has
					// no more shared
					// hours available, choose a different
					// if(min == workingHours[i] && workingHours[i] <
					// workingHours[index])
					// {
					index = i;
					// }
					min = workingHours[i];

				} else if (max < workingHours[i])
				{
					max = workingHours[i];
				}
			}

			String name = _empList.get(index).toString();

			// loops through the final schedule until the employee with the
			// least amount of hours
			// has one more than the employee with the most, or he runs out of
			// shared hours to take
			int sharedhrs = shardHours[index];

			for (int i = 0; i < _NUMBER_OF_DAYS; i++)
			{
				for (int j = 0; j < _NUMBER_OF_HOURS; j++)
				{
					if (sharedhrs > 0 && min <= max)
					{
						if (_finalSchedule[i][j] != null)
						{
							
							System.out.println("BLOCK AT: [" + i + "][" + j + "]" + _finalSchedule[i][j]);
							
							if (_finalSchedule[i][j].contains(name) && !name.equals(_finalSchedule[i][j]))
							{
								sharedhrs--;
								_finalSchedule[i][j] = name;
								min++;
							}
						}
					}
				}
			}

			
			
			sum = 0;
			for (int i = 0; i < shardHours.length; i++)
			{
				sum += shardHours[i];
			}

		} while (sum != 0);

	}

	// print out the finalized schedule
	public String printSchedule()
	{

		String out = "";

		for (String[] day : _finalSchedule)
		{
			for (String empl : day)
			{
				out += empl + " | ";
			}
			out += "\n";
		}

		for (Employee em : _empList)
		{
			out += em + " hours: " + em._hoursWorking + " shared: " + em._sharedHours + " | ";
		}

		return out;
	}

	// this is causing fairly tight coupling....
	// add an employee to the list
	public static void addEmployee(String name, boolean[][] aval, boolean[][] pref)
	{
		Employee empl = new Employee(name);

		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 13; j++)
			{
				empl._availability[i][j] = aval[i][j];
				empl._employer_preference[i][j] = pref[i][j];
			}
		}
		// _empList.add(empl);
	}

	public static void addEmployee(Employee empl)
	{
		_empList.add(empl);
	}

	// removing and employee from the list
	public static void cutEmployee(Employee empl)
	{
		_empList.remove(empl);
	}

}
