
package com.springbook.board.user;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbook.board.common.Const;
import com.springbook.board.common.MyUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}	
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public String login(UserVO param, HttpSession hs) {
		
		return "user/login";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model, @RequestParam(required=false) String err) {
		
		if(err != null) {
			model.addAttribute("msg", err);
		}
		
		return "user/join";
	}
	
	@RequestMapping(value="/joinPost", method=RequestMethod.POST)
	public String join(UserVO param, HttpSession hs, RedirectAttributes ra) {
		String rNumbers = (String)hs.getAttribute("rNumbers");
		if(!rNumbers.equals(param.getPhAuthNumber())) {
			ra.addAttribute("err", "인증번호가 맞지 않습니다.");
			return "redirect:/user/join";
		}
		
		int result = service.join(param);
		
		
		return "redirect:/user/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/phAuth", method=RequestMethod.GET)
	public Map<String, Object> phAuth(@RequestParam String ph, HttpSession hs) {
		System.out.println("ph : " + ph);	
		int len =  6; //인증번호길이
		String rNumbers = MyUtils.makeRandomNumber(len);
		System.out.println("rNumbers: " + rNumbers);
		//ph번호로 인증번호를 문자로 보낸다.
		
		hs.setAttribute("rNumbers", rNumbers);
		
		Map<String, Object> map = new HashMap();
		map.put("result", 1);
		
		return map;
	}
	
	@RequestMapping(value="/loginKAKAO", method=RequestMethod.GET)
	public String loginKAKAO() {
		String uri = String.format("redirect:https://kauth.kakao.com/oauth/authorize?"
				+ "client_id=%s&redirect_uri=%s&response_type=code"
				, Const.KAKAO_CLIENT_ID, Const.KAKAO_REDIRECT_URI);
		return uri;
	}
	
	@RequestMapping(value="/joinKakao", method=RequestMethod.GET)
	public String joinKAKAO(@RequestParam(required=false) String code,
			@RequestParam(required=false) String error) {
		
		System.out.println("code : " + code);
		System.out.println("error : " + error);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("KEY", "VALUE");
		
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> respEntity = restTemplate.exchange(Const.KAKAO_ACCESS_TOKEN_HOST, HttpMethod.POST, entity, String.class);
		
		
		return "redirect:/user/login";
	}
	
	
}



















