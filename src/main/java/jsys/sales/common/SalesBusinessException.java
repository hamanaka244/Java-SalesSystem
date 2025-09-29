package jsys.sales.common;
//例外処理
import java.util.ArrayList;

public class SalesBusinessException extends Exception {

	private ArrayList<String> messageList = new ArrayList<>();
	
	public SalesBusinessException(String message) {
		super(message);
	}
	
	public SalesBusinessException(ArrayList<String> messageList) {
		super();
		this.messageList = messageList;
	}

	
	
	public ArrayList<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(ArrayList<String> messageList) {
		this.messageList = messageList;
	}
		
}
