package dataManipulation;

public class FilterFact implements FilterFactory {

	@Override
	public Filter getFilterFor(String s) {
		if (s.equals("Date")) {
			return new DateFilter();
		}
		//"Category", "From Account", "To Account"
		return new DateFilter();
	}

}
