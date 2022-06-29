package main;

public class Transaction {
	private String otherParty = "";
	private float value = 0;
	private String fromAccount = "from: ";
	private String toAccount = "To: ";
	private String note = "notes: ";
	private Date date = new DateImp();
	
	public Transaction() {}
	
	public Transaction(float v, String from, String to, String nt, Date d) {
		value = v;
		fromAccount = from;
		toAccount = to;
		note = nt;
		date = d;
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
		return date.getDateMMDDYYYY() + ": $" + value + " From: " + fromAccount + " To: " + toAccount + " Notes: " + note;
	}
}
