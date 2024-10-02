package EntranceTest.InternJava.model;

public class ResponseObj {
	private String stt;
	private String mess;
	private Object data;
	
	
	public ResponseObj() {
		super();
	}
	public ResponseObj(String stt, String mess, Object data) {
		super();
		this.stt = stt;
		this.mess = mess;
		this.data = data;
	}
	public String getStt() {
		return stt;
	}
	public void setStt(String stt) {
		this.stt = stt;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
