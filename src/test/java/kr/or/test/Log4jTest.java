package kr.or.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
// logger 레벨 : debug<info<warn<error<fatal
public class Log4jTest {
	private Logger log = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		new Log4jTest().test();

	}
	public void test() {
		MemberVO memberVO = new MemberVO();
		memberVO.setName("홍길동");
		memberVO.setAge(99);
		memberVO.setPhoneNum("000-1111-2222");
		
		try {
			InetAddress localPC = InetAddress.getLocalHost();
			String ip = localPC.getHostAddress();
			log.info("info !!!!!"+"\ntest 메서드를 사용한 PC의 아이피 : " + ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		 
		log.debug("debug !!!!!\n"+memberVO);
		log.info("info !!!!!");
		log.warn("warn !!!!!");
		log.error("error !!!!!");
		log.fatal("fatal !!!!!");
		
	}

}
