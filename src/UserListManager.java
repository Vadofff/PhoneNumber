import java.util.ArrayList;
import java.util.List;

public class UserListManager {
    private List<User> userList;

    public UserListManager() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }
}