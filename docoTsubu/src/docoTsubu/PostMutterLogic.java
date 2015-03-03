package docoTsubu;

import java.util.List;
/**
 *
 * @author 白川
 *
 *つぶやきの投稿に関する処理を行うModelクラス
 */
public class PostMutterLogic {
	public void execute(Mutter mutter, List<Mutter> mutterList){
		mutterList.add(0,mutter);

	}
}
