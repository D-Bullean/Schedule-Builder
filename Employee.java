/**
 * 
 */


/**
 * @author Jack Lemmenes First iteration of the employee class. Designed to set,
 *         store and share the availability for a specific employee
 */
public class Employee
{

	// DATA
	public String _name;// should be a unique identifier
	public int _hoursWorking;
	public int _sharedHours;
	protected boolean[][] _availability;
	/*
	 * 8am = 8am to 9am, 9am = 9am to 10am etc
	 * 8am,9am,10am,11am,noon,1pm,2pm,3pm,4pm,5pm,6pm,7pm,8pm,9pm (0, 1, 2, 3,
	 * 4, 5, 6, 7, 8, 9, 10, 11, 12, 13) ____________________________________
	 * day 1| day 2| day 3| day 4| day 5|
	 * 
	 * Currently created with constants, assuming that the work week is Monday
	 * to Friday starting at 8am ending at 10pm This should be changed later to
	 * increase usability of the program
	 * 
	 */

	protected boolean[][] _employer_preference;// same structure as
												// _availability

	// Methods

	// Constructor
	public Employee(String name)
	{
		this._name = name;

		_availability = new boolean[Schedule._NUMBER_OF_DAYS][Schedule._NUMBER_OF_HOURS];
		_employer_preference = new boolean[Schedule._NUMBER_OF_DAYS][Schedule._NUMBER_OF_HOURS];

		Schedule.addEmployee(this);
		// Schedule.addForTest(this);

	}

	// setters for the employee's availability and employer preference
	public void setHoursTrue(int day, int startingHour, int endingHour)
	{

		for (int i = startingHour; i <= endingHour; i++)
		{
			this._availability[day][i] = true;
		}

	}

	public void setHoursFalse(int day, int startingHour, int endingHour)
	{

		for (int i = startingHour; i <= endingHour; i++)
		{
			this._availability[day][i] = false;
		}

	}

	public void setPrefTrue(int day, int startingHour, int endingHour)
	{

		for (int i = startingHour; i <= endingHour; i++)
		{
			this._employer_preference[day][i] = true;
		}

	}

	public void setPrefFalse(int day, int startingHour, int endingHour)
	{

		for (int i = startingHour; i <= endingHour; i++)
		{
			this._employer_preference[day][i] = false;
		}

	}

	// traverses the entire 2D array and adds up the amount of true values
	public void setHoursWorking(Schedule sc)
	{
		int work = 0;
		int shared = 0;

		for (int i = 0; i < sc._NUMBER_OF_DAYS; i++)
		{
			for (int j = 0; j < sc._NUMBER_OF_HOURS; j++)
			{
				if (this._name.equals(sc._finalSchedule[i][j]))
				{
					work++;
				} else
				{
					if (sc._finalSchedule[i][j] != null)
					{
						String x = sc._finalSchedule[i][j].toString();

						if (x.contains(toString()))
						{
							shared++;
						}
					}
				}
			}
		}

		_hoursWorking = work;
		_sharedHours = shared;
	}

	public String toString()
	{
		return _name;
	}

	// prints out the schedule
	public String print()
	{
		String ts = "";

		// Accessing each day of the week in the array

		for (boolean[] element : _availability)
		{
			for (boolean ele : element)
			{
				ts += ele + " ";
			}
			ts += "\n";
		}

		return ts;
	}
}
