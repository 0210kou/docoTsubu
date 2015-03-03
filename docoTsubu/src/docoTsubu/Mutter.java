package docoTsubu;

import java.io.Serializable;

/** つぶやきクラス
 * @author 白川
 * @see User
 * **/

public class Mutter implements Serializable{
	/** アカウントネーム**/
	private String userName;

	/** つぶやき内容**/
	private String text;
	/** 引数なしでもnewできるようにするためのコンストラクタ**/
	public Mutter(){}
	/** 戻り値がuserName String型とtext String型のコンストラクタ＊引数必須**/
	/**
	 *
	 * @param userName ユーザーの名前
	 * @param text つぶやいた内容
	 */
	public Mutter(String userName, String text){
		this.userName = userName;
		this.text  = text;
	}
	/** UserNameのゲッター**/
	public String getUserName() {
		return userName;
	}
	/** text(つぶやき)のゲッター**/
	public String getText() {
		return text;
	}

}
