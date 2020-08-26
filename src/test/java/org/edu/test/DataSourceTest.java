package org.edu.test;

import java.sql.Connection;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.edu.service.IF_MemberService;
import org.edu.vo.MemberVO;
import org.edu.vo.PageVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class DataSourceTest {
	@Inject
	private DataSource ds;
	@Inject
	private IF_MemberService memberService;
	
	@Test
	public void testConnection() throws Exception{
		
		Connection con = ds.getConnection();
		System.out.println("데이터베이스 커넥션 성공 : "+con);
			
	}
	
	@Test
	public void testSelectMember() throws Exception{
		System.out.println("회원리스트 입니다.");
		PageVO pageVO = new PageVO();
		pageVO.setPage(1);
		pageVO.setPerPageNum(10);
		memberService.selectMember(pageVO);
		List<MemberVO> list = memberService.selectMember(pageVO);
		System.out.println("--------------------------------------------");
		System.out.println(list);
		System.out.println("--------------------------------------------");
		/*for(MemberVO vo:list) {
			System.out.println("사용자 아이디 : " + vo.getUser_id() +
					"\n사용자 패스워드 : " + vo.getUser_pw()+
					"\n사용자 이름 : " + vo.getUser_name()+
					"\n사용자 이메일 : " + vo.getEmail()+
					"\n사용자 포인트 : " + vo.getPoint()+
					"\n사용자 활성화 : " + vo.getEnabled()+
					"\n사용자 등급 : " + vo.getLevels());
		}*/
	}
	@Test
	public void testInsertMember() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setUser_id("doolipapa");
		memberVO.setUser_pw("1234");
		memberVO.setUser_name("둘리");
		memberVO.setEmail("dooli@test.com");
		memberVO.setPoint(999999999);
		memberVO.setEnabled(true);
		memberVO.setLevels("ROLE_USER");
		memberService.insertMember(memberVO);
	}
	@Test
	public void testUpdateMember() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setUser_id("user02");
		memberVO.setUser_pw("1234");
		memberVO.setUser_name("둘리");
		memberVO.setEmail("dooli@test.com");
		memberVO.setPoint(999999999);
		memberVO.setEnabled(true);
		memberVO.setLevels("ROLE_ADMIN");
		memberService.updateMember(memberVO);
	}
	@Test
	public void testDeleteMember() throws Exception{
		memberService.deleteMember("user02");
	}
	
}
