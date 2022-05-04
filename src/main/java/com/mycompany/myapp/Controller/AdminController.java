package com.mycompany.myapp.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.myapp.service.IAdminService;
import com.mycompany.myapp.vo.NoticeVO;
import com.mycompany.myapp.vo.UserVO;

@Controller
public class AdminController {
	
	@Autowired
	@Qualifier("adservice")
	IAdminService adminService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminIndex() {
		return "admin/adminIndex";
	}
	
	// 로그인 화면
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String adminLoginForm() {
		return "admin/login";
	}
	
	// 로그인처리 - session 이용
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String adminLogin(UserVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		System.out.println("login().vo : " + vo);
		
		// DB에서 입력한 정보에 맞는 데이터를 가져온다.
		UserVO userVO = adminService.adminLogin(vo);
		System.out.println("login().userVO : " + userVO);
		
		// userVO가 null : 아이디와 비밀번호가 틀려서 데이터를 가져올 수 없었다.
		
		if(userVO == null) {
			session.setAttribute("login", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/admin/login";
		}
		
		// 실제적인 로그인 처리
		session.setAttribute("login", userVO);
		session.setAttribute("name", userVO.getUserName());
		session.setAttribute("userId", userVO.getUserId());
		return "redirect:/admin";
	}
	
	// 로그아웃
	@GetMapping("/admin/logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		// 로그아웃 처리
		session.removeAttribute("login");
		// 메시지 처리 - 한번만
		rttr.addFlashAttribute("msg", "로그아웃이 되셨습니다.");
		return "redirect:/admin/login";
	}
	
	// 회원관리 페이지
	@RequestMapping(value = "/admin/userManage", method = RequestMethod.GET)
	public String userManage() {
		return "admin/userManage";
	}
	
	// 상품관리 페이지
	@RequestMapping(value = "/admin/productManage", method = RequestMethod.GET)
	public String productManage() {
		return "admin/productManage";
	}
	
	// 공지사항 관리 페이지
	@RequestMapping(value = "/admin/noticeManage", method = RequestMethod.GET)
	public String getNoticeList(Model model) {
		List<NoticeVO> noticeList = adminService.getNoticeList();
		model.addAttribute("noticeList", noticeList);
		return "admin/noticeManage";
	}
	
	
	// 공지사항 폼
	@RequestMapping(value="/admin/noticeManageInsert", method = RequestMethod.GET)
	public String noticeInsertPage() {
		return "admin/noticeManageInsert";
	}
	
	// 공지사항 등록
	@RequestMapping(value="/admin/noticeManageInsert", method = RequestMethod.POST)
	public String noticeInsert(NoticeVO vo, Model model) {
		System.out.println(vo);
		adminService.noticeInsert(vo);
		return "redirect:/admin/noticeManage";
	}
	
	// 공지사항 상세
	@RequestMapping(value="/admin/noticeManage/{noticeNo}")
	public String noticeInfo(@PathVariable("noticeNo") int noticeNo, Model model) {
		NoticeVO nvo = adminService.getnoticeInfo(noticeNo);
		model.addAttribute("nvo", nvo);
		return "admin/noticeManageDetail";
	}
	
	// 공지사항 수정
	@RequestMapping(value="/admin/noticeManage/update", method=RequestMethod.GET)
	public String updateNotice(int noticeNo, Model model) {
		model.addAttribute("nvo", adminService.getnoticeInfo(noticeNo));
		return "admin/updateform";
	}
	
	// 공지사항 수정
	@RequestMapping(value="/admin/noticeManage/update", method=RequestMethod.POST)
	public String updateNotice(NoticeVO nvo, Model model) {
		adminService.updateNotice(nvo);
		return "redirect:/admin/noticeManage/" + nvo.getNoticeNo();
	}
	
	// 공지사항 삭제
	@RequestMapping(value="/admin/noticeManage/delete", method=RequestMethod.GET)
	public String deleteForm(int noticeNo, Model model) {
		model.addAttribute("nvo", adminService.getnoticeInfo(noticeNo));
		return "admin/deleteform";
	}
	
	// 공지사항 삭제
	@RequestMapping(value="/admin/noticeManage/delete", method=RequestMethod.POST)
	public String deleteNotice(int noticeNo, Model model) {
		adminService.deleteNotice(noticeNo);
		return "redirect:/admin/noticeManage";
	}

	
	
	
}
