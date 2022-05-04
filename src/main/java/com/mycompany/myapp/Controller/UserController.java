package com.mycompany.myapp.Controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.myapp.service.IUserService;
import com.mycompany.myapp.vo.ProductVO;
import com.mycompany.myapp.vo.UploadFileVO;
import com.mycompany.myapp.vo.UserVO;

@Controller
public class UserController {

	//김지현
	@Autowired
	IUserService userService;
	
	final Logger logger	= LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "user/index";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {			
		return "user/join";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLogin() {		
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(UserVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{

		UserVO userVO = userService.userLogin(vo);
		System.out.println("login().userVO : " + userVO);

		if(userVO == null) {
			System.out.println("로그인 실패");
			session.setAttribute("login", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/login";
		}
		
		System.out.println("로그인 성공");
		session.setAttribute("login", userVO);
		session.setAttribute("name", userVO.getUserName());
		session.setAttribute("userId", userVO.getUserId());
		return "redirect:/";
	}
	
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String userMyPage() {		
		return "user/myPage";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertUser(UserVO vo, String userId, Model model) {
		int idCheck = idCheck(userId);
		if(idCheck == 1) {
			return "user/join";
		} else if(idCheck == 0){
			userService.insertUser(vo);
		}
		return "user/login";
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(String userId) {	
		return userService.idCheck(userId);
	}
	
	@RequestMapping(value = "/pwCheck", method = RequestMethod.POST)
	@ResponseBody
	public int pwCheck(String userId, String userPassword) {	
		System.out.println(userId + " " + userPassword);
		return userService.pwCheck(userId, userPassword);
	}
	
	@RequestMapping(value = "/update/{userId}", method = RequestMethod.GET)
	public String updateUser(@PathVariable String userId, Model model) {
		model.addAttribute("user", userService.getUserInfo(userId));
		return "user/updateForm";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(UserVO vo) {
		userService.updateUser(vo);		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable String userId, Model model) {
		model.addAttribute("user", userService.getUserInfo(userId));
		return "user/deleteForm";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteUser(String userId, String userPassword, HttpSession session, RedirectAttributes rttr) {
		int pwCheck = pwCheck(userId, userPassword);
		
		if (pwCheck == 1) {		
			userService.deleteUser(userId, userPassword);
			logout(session, rttr);
		} else if (pwCheck == 0) {
			return "user/deleteForm";
		}
		return "redirect:/";
	}	
	
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		session.removeAttribute("login");
		rttr.addFlashAttribute("msg", "로그아웃 되셨습니다.");
		return "redirect:/";
	}
	//--------------------------------------------------------------
	
	//윤민우 카테고리 클릭
//	@RequestMapping(value= {"/all", "/clothes", "/shoes", "/bag", "/accessories"}, method = RequestMethod.GET)	
//	public String getProductSample(@RequestParam("categoryname") String categoryname, Model model) {
//		System.out.println(categoryname);
//		//model.addAttribute("productList", userService.getCategoryAll());
//		return "/user/sample1";
//	}
	
	@RequestMapping(value = "/sample1", method = RequestMethod.GET)
	public String sample() {
		
		return "user/sample1";
	}
	
	//윤민우 카테고리 클릭 all
	@RequestMapping(value="/all", method = RequestMethod.GET)	
	public String getProductAll(Model model) {
		List<ProductVO> productList = userService.getCategoryAll();
		//List<CategoryVO> categoryList = userService.getCategroyName(productList);
		model.addAttribute("productList", productList);
		//model.addAttribute("categoryList", categoryList);
		return "/user/productList";
	}
	//윤민우 카테고리 클릭 옷
	@RequestMapping(value="/clothes", method = RequestMethod.GET)	
	public String getProductClothes(Model model) {
		model.addAttribute("productList", userService.getCategoryClothes());
		return "/user/productList";
	}
	//윤민우 카테고리 클릭 신발
	@RequestMapping(value="/shoes", method = RequestMethod.GET)		
	public String getProductShoes(Model model) {
		model.addAttribute("productList", userService.getCategoryShoes());
		return "/user/productList";
	}
	//윤민우 카테고리 클릭 가방
	@RequestMapping(value="/bag", method = RequestMethod.GET)		
	public String getProductBag(Model model) {
		model.addAttribute("productList", userService.getCategoryBag());
		return "/user/productList";
	}
	//윤민우 카테고리 클릭 악세
	@RequestMapping(value="/accessories", method = RequestMethod.GET)		
	public String getProductAccessories(Model model) {
		model.addAttribute("productList", userService.getCategoryAccessoris());
		return "/user/productList";
	}
	//윤민우 상품별 상세목록
	@RequestMapping("/{productNo}")
	public String getProductInfo(@PathVariable int productNo, Model model) {
		ProductVO productInfo = userService.getProductInfo(productNo);
		UserVO userInfo = userService.getUserInfoByPrdNo(productNo);
		String categoryName = userService.getCategoryNameByPrdNo(productNo);
		List<UploadFileVO> uploadFile = userService.getFileList(productNo);
		model.addAttribute("productInfo", productInfo);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("categoryName", categoryName);
		model.addAttribute("uploadFile", uploadFile);
		return "user/productInfo";
	}
	//윤민우 찜목록
	@RequestMapping(value = "/addwishlist", method = RequestMethod.POST)
	public String addWishList(ProductVO vo) {
		System.out.println("wishlist" + vo);
		userService.setWishList(vo);
		return "user/productInfo";
	}
	//윤민우 상품 검색
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String productSearch(String searchbox, Model model) {
		List<ProductVO> productList = userService.getSearchProduct(searchbox);
		model.addAttribute("productList", productList);
		return "user/productList";
	}
	
	//이미지 관리
	@RequestMapping(value = "/prd/upload", method = RequestMethod.GET)
	public String productMultiUpload( ) {
		return "user/productMultiUpload";
	}
	
	@RequestMapping(value = "/prd/multiupload", method = RequestMethod.POST)
	public String productSubmit(@RequestParam("article_file") List<MultipartFile> multipartFile, RedirectAttributes redirectAttrs)	{
		try {
			if(multipartFile.size() > 0 && !multipartFile.get(0).getOriginalFilename().equals("")) {
				for(MultipartFile file:multipartFile) {
					logger.info(file.getOriginalFilename());
					try{
						if(file!=null	&&	!file.isEmpty())	{
							logger.info("/upload : " + file.getOriginalFilename());
							UploadFileVO newFile = new UploadFileVO();
							newFile.setFileName(file.getOriginalFilename());
							newFile.setFileSize(file.getSize());
							newFile.setFileContentType(file.getContentType());
							newFile.setFileData(file.getBytes());
							System.out.println(newFile.toString());
							userService.uploadFile(newFile);
						}
					}catch(Exception e){
						logger.error(e.getMessage());
						redirectAttrs.addFlashAttribute("message",	e.getMessage());
					}	
				}
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping("/img/{fileNo}")
	 public ResponseEntity<byte[]> getImageFile(@PathVariable int fileNo) {
		 UploadFileVO file = userService.getFile(fileNo);
		 final HttpHeaders headers = new HttpHeaders();
		 if(file !=	null) {
			 logger.info("getFile" + file.toString());
			 String[] mtypes = file.getFileContentType().split("/");
			 headers.setContentType(new	MediaType(mtypes[0], mtypes[1]));
			 headers.setContentLength(file.getFileSize());
			 headers.setContentDispositionFormData("attachment",	
			 file.getFileName(), Charset.forName("UTF-8"));
			 return	new	ResponseEntity<byte[]>(file.getFileData(),	headers,	
			 HttpStatus.OK);
		 }else {
			 return	new	ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		 }
	 }
}
