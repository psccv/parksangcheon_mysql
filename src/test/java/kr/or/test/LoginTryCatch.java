package kr.or.test;

class NotExistIDException extends Exception{
	//아이디가 존재하지 않을때 예외사항 처리 내용
	public NotExistIDException() {
		
	}
	public NotExistIDException(String message) {
		super(message);
	}
}
class WrongPasswordException extends Exception{
	//패스워드 입력 오류에 대한 예외사항 처리 내용
	public WrongPasswordException() {
		
	}
	public WrongPasswordException(String message) {
		super(message);
	}
}
public class LoginTryCatch {

	public static void main(String[] args) {
		try {
			login("white","12345");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			login("blue","12345");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void login(String id, String password) throws NotExistIDException, WrongPasswordException {
		//id가 'blue'가 아니라면 NotExistIDException 발생시킴
		if(!id.equals("blue")) {
			throw new NotExistIDException("아이디가 존재하지 않습니다.");
		}
		//password가 '54321'이 아니라면 WrongPasswordException 발생시킴
		if(!password.equals("54321")) {
			throw new WrongPasswordException("패스워드가 일치하지 않습니다.");
		}
	}
}
