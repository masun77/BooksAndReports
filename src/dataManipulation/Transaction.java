package dataManipulation;

public class Transaction {
	private String otherParty = "";
	private float value = 0;
	private String fromAccount = "from: ";
	private String toAccount = "To: ";
	private String note = "notes: ";
	private Date date = new DateImp();
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	private String category = "";
	
	public Transaction() {}
	
	public Transaction(float v, String from, String to, String nt, Date d) {
		value = v;
		fromAccount = from;
		toAccount = to;
		note = nt;
		date = d;
	}
	
	public Transaction(float v, String from, String to, String nt, Date d, String cat) {
		value = v;
		fromAccount = from;
		toAccount = to;
		note = nt;
		date = d;
		category = cat;
	}
	
	public String getOtherParty() {
		return otherParty;
	}

	public void setOtherParty(String otherParty) {
		this.otherParty = otherParty;
	}
	
	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return date.getDateMMDDYYYY() + ": $" + value + " From: " + fromAccount + " To: " + toAccount 
				+ " Category: " + category 
				+ " Notes: " + note;
	}
}
