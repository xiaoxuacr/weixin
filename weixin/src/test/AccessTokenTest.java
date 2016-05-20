package test;

import service.Access_TokenGet;

public class AccessTokenTest {
	public static void main(String[] args) {
		try {
			new Access_TokenGet().getToken_getTicket();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
