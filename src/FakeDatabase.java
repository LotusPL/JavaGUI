import java.util.Collections;
import java.util.List;

/**
 * Created by Lotus on 2015-04-20.
 */
public class FakeDatabase {
    Boolean IsCorrect(String login, String password){return true;}
    Boolean Register(String login, String password){return true;}
    void SaveMessage(Message content){}
    List<Message> GetMessage(String nick){return Collections.emptyList();}
}
