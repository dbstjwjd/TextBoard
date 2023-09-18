package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    public ArrayList<Post> posts = new ArrayList<>();
    public ArrayList<Member> members = new ArrayList<>();

    public void SignUp(HashMap<String, String> map) {
        String ID = map.get("ID");
        String PW = map.get("PW");
        String name = map.get("name");
        Member member = new Member(ID, PW, name);
        members.add(member);
    }
    public boolean FindID(String ID) {
        for(Member m : members) {
            if(m.getID().equals(ID))
                return false;
        }
        return true;
    }

    public HashMap<String, String> Login(String ID, String PW) {
        HashMap<String, String> map = new HashMap<>();
        for(Member m : members) {
            if(m.getID().equals(ID) && m.getPW().equals(PW)) {
                map.put("UserID", m.getID());
                map.put("UserPW", m.getPW());
                map.put("Username", m.getName());
            }
        } return map;
    }

    public void Add(String title, String content, String name) {
        Post post = new Post(title, content);
        if (posts.isEmpty())
            post.setNumber(1);
        else
            post.setNumber(posts.get(posts.size() - 1).getNumber() + 1);
        post.setWritter(name);
        posts.add(post);
    }
    public Post FindNum(int num) {
        Post index = null;
        for(int i = 0; i < posts.size(); i++) {
            if(num == posts.get(i).getNumber())
                index = posts.get(i);
        }
        return index;
    }
    public void Update(Post index, String title, String content) {
        index.setTitle(title);
        index.setContent(content);
    }
    public void Delete(Post index) {
        posts.remove(index);
    }
}
