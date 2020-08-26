package org.edu.controller;

import java.io.File;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.validation.Valid;

import org.edu.service.IF_BoardService;
import org.edu.service.IF_MemberService;
import org.edu.util.FileDataUtil;
import org.edu.vo.BoardVO;
import org.edu.vo.MemberVO;
import org.edu.vo.PageVO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Inject
	private IF_MemberService memberService;
	@Inject
	private IF_BoardService boardService;
	@Inject
	private FileDataUtil fileDataUtil;
	/**
	 * 관리자 홈
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "admin/home";
	}
	
	/**
	 * 회원관리 목록 입니다.
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String memberList(@ModelAttribute("pageVO") PageVO pageVO, Locale locale, Model model) throws Exception {
		if(pageVO.getPage() == null) {
			pageVO.setPage(1);
		}
		pageVO.setPerPageNum(10);
		pageVO.setTotalCount(memberService.countUserId(pageVO));
		List<MemberVO>list = memberService.selectMember(pageVO);
		//model매개변수에 memberService에서 Select한 list값을 memberList란
		//이름으로 사용할 수 있도록 jsp화면으로 보낸다.
		//model { list -> memberList -> jsp }
		model.addAttribute("memberList", list);
		model.addAttribute("pageVO", pageVO);
		return "admin/member/member_list";
	}
	
	/**
	 * 회원관리 상세보기 입니다.
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/member/view", method = RequestMethod.GET)
	public String memberView(@ModelAttribute("pageVO") PageVO pageVO, @RequestParam("user_id") String user_id, Locale locale, Model model) throws Exception {
		MemberVO memberVO = memberService.viewMember(user_id);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("memberVO", memberVO);
		return "admin/member/member_view";
	}
	
	/**
	 * 회원관리 등록 입니다.
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/member/write", method = RequestMethod.GET)
	public String memberWrite(Locale locale, Model model) throws Exception {
		return "admin/member/member_write";
	}
	@RequestMapping(value = "/member/write", method = RequestMethod.POST)
	public String memberWrite(@Valid MemberVO memberVO, Locale locale, RedirectAttributes rdat) throws Exception {
		String new_pw = memberVO.getUser_pw();//1234
		if(new_pw != "") {
			//스프링 시큐리티 4.x BCryptPasswordEncoder  암호화 사용
			BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder(10);
			String bcryptPassword = bcryptPasswordEncoder.encode(new_pw);
			memberVO.setUser_pw(bcryptPassword);
		}
		memberService.insertMember(memberVO);
		rdat.addFlashAttribute("msg", "writeSuccess");
		return "redirect:/admin/member/list";
	}
	
	/**
	 * 회원관리 수정 입니다.
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String memberUpdate(@ModelAttribute("pageVO") PageVO pageVO, @RequestParam("user_id") String user_id, Locale locale, Model model) throws Exception {
		MemberVO memberVO = memberService.viewMember(user_id);
		model.addAttribute("memberVO", memberVO);
		model.addAttribute("pageVO", pageVO);
		return "admin/member/member_update";
	}
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String memberUpdate(@ModelAttribute("pageVO") PageVO pageVO, MemberVO memberVO, Locale locale, RedirectAttributes rdat) throws Exception {
		String new_pw = memberVO.getUser_pw();//1234
		if(new_pw != "") {
			//스프링 시큐리티 4.x BCryptPasswordEncoder  암호화 사용
			BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder(10);
			String bcryptPassword = bcryptPasswordEncoder.encode(new_pw);
			memberVO.setUser_pw(bcryptPassword);
		}
		memberService.updateMember(memberVO);
		rdat.addFlashAttribute("msg", "updateSuccess");
		return "redirect:/admin/member/view?user_id=" + memberVO.getUser_id() + "&page=" + pageVO.getPage();
	}
	
	/**
	 * 회원관리 삭제 입니다.
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/member/delete", method = RequestMethod.POST)
	public String memberDelete(@RequestParam("user_id") String user_id, Locale locale, RedirectAttributes rdat) throws Exception {
		memberService.deleteMember(user_id);
		rdat.addFlashAttribute("msg", "deleteSuccess");
		return "redirect:/admin/member/list";
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 게시물관리 목록 입니다.
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String boardList(@ModelAttribute("pageVO") PageVO pageVO, Locale locale, Model model) throws Exception {
		//PageVO pageVO = new PageVO();//매개변수로 받기전 테스트용
		if(pageVO.getPage() == null) {
			pageVO.setPage(1);//초기 page변수값 지정
		}
		pageVO.setPerPageNum(10);//1페이지당 보여줄 게시물 수 지정
		pageVO.setTotalCount(boardService.countBno(pageVO));//입력한 값을 쿼리로 대체
		List<BoardVO> list = boardService.selectBoard(pageVO);
		//모델클래스로 jsp화면으로 boardService에서 셀렉트한 list값을 boardList변수명으로 보낸다.
		//model { list -> boardList -> jsp }
		model.addAttribute("boardList", list);
		model.addAttribute("pageVO", pageVO);
		return "admin/board/board_list";
	}
	
	/**
	 * 게시물관리 상세보기 입니다.
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/board/view", method = RequestMethod.GET)
	public String boardView(@ModelAttribute("pageVO") PageVO pageVO, @RequestParam("bno") Integer bno,Locale locale, Model model) throws Exception {
		BoardVO boardVO = boardService.viewBoard(bno);
		//여기서 부터 첨부파일명 때문에 추가
		List<String> files = boardService.selectAttach(bno);//bno값에 저장된 파일명을 가져옴
		String[] filenames = new String[files.size()];//저장된갯수 만큼 filenames배열 개수 생성
		int cnt = 0;
		for(String fileName : files) {//파일명 수만큼 반복문
			filenames[cnt++] = fileName;//filenames에 cnt값을 사용해서 인덱스에 파일명 저장
		}
		boardVO.setFiles(filenames);//파일명 세팅
		//여기까지 첨부파일때문에 추가
		model.addAttribute("boardVO", boardVO);//jsp단에서 사용할수있게 boardVO 값을 보내준다
		model.addAttribute("pageVO", pageVO);//jsp단에서 사용할수있게 pageVO 값을 보내준다
		return "admin/board/board_view";
	}
	
	/**
	 * 게시물관리 등록 입니다.
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String boardWrite(Locale locale, Model model) throws Exception {
		return "admin/board/board_write";
	}
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String boardWrite(MultipartFile file,@Valid BoardVO boardVO, Locale locale, Model model, RedirectAttributes rdat) throws Exception {
		if(file.getOriginalFilename() == "") {
			//첨부파일 없이 저장
			boardService.insertBoard(boardVO);
		}else {//첨부파일 있을때 저장 
			String[] files = fileDataUtil.fileUpload(file);//첨부파일을 업로드하고 업로드된 파일명을 가져옴
			boardVO.setFiles(files);//업로드된 파일명을 게시물에 세팅
			boardService.insertBoard(boardVO);			
		}
		rdat.addFlashAttribute("msg", "writeSuccess");//게시물이 작성되면 성공 msg를 보낸다
		return "redirect:/admin/board/list";
	}
	
	/**
	 * 게시물관리 수정 입니다.
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String boardUpdate(@ModelAttribute("pageVO") PageVO pageVO, @RequestParam("bno") Integer bno, Locale locale, Model model) throws Exception {
		BoardVO boardVO = boardService.viewBoard(bno);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("pageVO", pageVO);
		return "admin/board/board_update";
	}
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String boardUpdate(@ModelAttribute("pageVO") PageVO pageVO, MultipartFile file,@Valid BoardVO boardVO,Locale locale, RedirectAttributes rdat) throws Exception {
		if(file.getOriginalFilename() == "") {//조건:첨부파일 전송 값이 없다면
			boardService.updateBoard(boardVO);
		} else {
			//기존등록된 첨부파일 삭제처리(아래)
			List<String> delFiles = boardService.selectAttach(boardVO.getBno());
			for(String fileName : delFiles) {
				//실제파일 삭제
				File target = new File(fileDataUtil.getUploadPath(), fileName); //업로드된 경로와 파일명을 가져옴
				if(target.exists()) { //조건:해당경로에 파일명이 존재하면
					target.delete();  //파일삭제
				}//End if
			}//End for
			//아래 신규파일 업로드
			String[] files = fileDataUtil.fileUpload(file);//실제파일업로드후 파일명 리턴
			boardVO.setFiles(files);//데이터베이스 <-> VO(get,set) <-> DAO클래스
			boardService.updateBoard(boardVO);
		}//End if
		rdat.addFlashAttribute("msg", "updateSuccess");// 수정완료시 성공 msg를 보냄
		//게시물 클릭하기 전 페이지 경로
		return "redirect:/admin/board/view?bno=" + boardVO.getBno() + "&page=" + pageVO.getPage();
	}
	
	/**
	 * 게시물관리 삭제 입니다.
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String boardDelete(@RequestParam("bno") Integer bno, Locale locale, RedirectAttributes rdat) throws Exception {
		List<String> files = boardService.selectAttach(bno);//첨부 파일명을 가져옴
		boardService.deleteBoard(bno);
		//첨부파일 삭제
		for(String fileName : files) {
			//삭제 명령문 추가
			File target = new File(fileDataUtil.getUploadPath(), fileName);
			if(target.exists()) {//경로에 파일명이 있을경우
				target.delete();//파일 삭제
			}
		}
		rdat.addFlashAttribute("msg", "deleteSuccess");//msg 를보내 삭제 성공을 알린다
		return "redirect:/admin/board/list";
	}
	
}
