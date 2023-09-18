package Controller;

import Model.Model;
import View.View;

import java.util.HashMap;

public class Controller {
    View view = new View();
    Model model = new Model();
    HashMap<String, String> user = new HashMap<>();

    public void run() {
        view.Menu();
        while (true) {
            String input = view.Input();
            if (input.equals("sign up")) {
                HashMap<String, String> map = new HashMap<>();
                map = view.SignUpPrint();
                if (!model.FindID(map.get("ID"))) {
                    view.ExistID();
                } else {
                    model.SignUp(map);
                    view.SignupComplete();
                }


            } else if (input.equals("login")) {
                HashMap<String, String> map = view.LoginPrint();
                String ID = map.get("ID");
                String PW = map.get("PW");
                user = model.Login(ID, PW);
                if (user.isEmpty())
                    view.UnableLogin();
                else
                    view.LoginSuccess(user.get("Username"));
            } else if (input.equals("add")) {
                if (user.isEmpty()) {
                    view.NotLogin();
                } else {
                    HashMap<String, String> map = view.AddPrint();
                    model.Add(map.get("제목"), map.get("내용"), user.get("Username"));
                    view.AddSuccess();
                }
            } else if (input.equals("list")) {
                if (model.posts.isEmpty())
                    view.ListEmpty();
                else
                    view.List(model.posts);
            } else if (input.equals("update")) {
                HashMap<String, String> map = new HashMap<>();
                view.UpdateNum();
                int num = view.InputNum();
                if (model.FindNum(num).getWritter().equals(user.get("Username"))) {
                    if (model.FindNum(num) == null)
                        view.NotExist();
                    else {
                        map = view.UpdatePrint();
                        model.Update(model.FindNum(num), map.get("새 제목"), map.get("새 내용"));
                        view.Complete();
                    }
                } else
                    view.Unable();
            } else if (input.equals("delete")) {
                view.DeleteNum();
                int num = view.InputNum();
                if (model.FindNum(num).getWritter().equals(user.get("Username"))) {
                    if (model.FindNum(num) == null)
                        view.NotExist();
                    else {
                        model.Delete(model.FindNum(num));
                        view.Complete();
                    }
                } else
                    view.Unable();
            } else if (input.equals("detail")) {
                view.DetailNum();
                int num = view.InputNum();
                if (model.FindNum(num) == null)
                    view.NotExist();
                else {
                    view.DetailPrint(model.FindNum(num));
                }
            } else if (input.equals("exit")) {
                view.ExitPrint();
                break;
            }
        }
    }
}
