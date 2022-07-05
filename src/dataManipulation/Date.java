package dataManipulation;

/**
 * Date interface.
 * Allows the user to get the month, year, and day of month; also the name of the month;
 * also the full date as a text string.
 *
 */
public interface Date {
	/**
	 * @return the date as a String in the format mm/dd/yyyy.
	 */
	public String getDateMMDDYYYY();
	
	/**
	 * @return the data in the form YYMMDD, no slashes
	 */
	public String getDateYYMMDD();
	
	/**
	 * @return the month name, January through December
	 */
	public String getMonthName();
	
	/**
	 * @param month integer representing the month of the year from 1 (January) to 12 (December)
	 * @return the month name, January through December
	 */
	public String getMonthName(int month);
	
	/**
	 * @return the month name as a three-letter abbreviation, plus the day of the month
	 */
	public String getAsPackDate();
	
	/**
	 * @return the month and day, eg. 05/14
	 */
	public String getMMDD();
	
	/**
	 * @return the month as a number, 1-12
	 */
	public int getMonthofYear();
	
	/**
	 * @return the year
	 */
	public int getYear();
	
	/**
	 * @return the day as a number, 1-31
	 */
	public int getDayOfMonth();
	
	/**
	 * Checks whether this date equals the given date.
	 * @param d the Date to compare to
	 * @return true if the dates are equal, false otherwise
	 */
	public boolean equalsDate(Date d);
}
