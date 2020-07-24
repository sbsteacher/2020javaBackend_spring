package com.springbook.board.user;

import org.springframework.stereotype.Service;
import com.springbook.board.common.MyUtils;

@Service
public class UserService {
	
	public int join(UserVO param) {
		int result = 0;
		String pw = param.getUpw();
		String hashPw = MyUtils.hashPassword(pw);		
		param.setUpw(hashPw);
		
		//param.setUpw(MyUtils.hashPassword(param.getUpw()));
		return result;
	}
}
