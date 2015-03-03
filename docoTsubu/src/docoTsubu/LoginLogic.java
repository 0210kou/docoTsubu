package docoTsubu;

public class LoginLogic {
	public boolean execute(User user){


		//判定条件名前が8文字以上でpasswordは1234のみ受け付ける
		if( user.getName().length() >= 8 && user.getPass().equals("1234")){
			return true;
		}

		return false;
	}


	}

