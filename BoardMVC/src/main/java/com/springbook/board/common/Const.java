package com.springbook.board.common;

public class Const {
	public static final String KAKAO_CLIENT_ID = "0703fd57658ec25df8c8da4165296968";
	public static final String KAKAO_AUTH_REDIRECT_URI = "http://192.168.1.1:8090/user/joinKakao";
	public static final String KAKAO_ACCESS_TOKEN_HOST = "https://kauth.kakao.com/oauth/token";
	public static final String KAKAO_API_HOST = "https://kapi.kakao.com";
	
	//게시판 한번에 가져오는 데이터 수
	public static final int ROW_COUNT = 60;
}
