package docoTsubu;

import java.io.Serializable;
/**
 * Userクラス
 * このクラスはユーザー名、パスワード名
 * をもつJavabeansクラス。
 * @author 白川
 * @see Mutter
 *
 */

public class User implements Serializable{
	/** 名前*/
	private String name;
	/** パスワード**/
	private String pass;

	/**引数なしでもnewできるためのコンストラクタ**/
	public User(){}
	/** 戻り値がString型nameとString型passの２つのコンストラクタ**/
	/**
	 *
	 * @param name ユーザーのアカウント名
	 * @param pass パスワード
	 */
	public User(String name, String pass){
		this.name = name;
		this.pass = pass;
	}
	/** nameのゲッター**/
	public String getName(){
		return name;
	}
	/** passのゲッター **/
	public String getPass() {
		return pass;
	}

}
