package View;

import Model.Member;
import Model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class View {
    Scanner scan = new Scanner(System.in);
    public void Menu() {
        System.out.println("sign up / login / add / list / update / delete / detail / exit");
    }
    public String Input() {
        System.out.print("명령어 입력 : ");
        return scan.nextLine();
    }
    public HashMap<String, String> SignUpPrint() {
        HashMap<String, String> map = new HashMap<>();
        System.out.print("ID : ");
        map.put("ID", scan.nextLine());
        System.out.print("PW : ");
        map.put("PW", scan.nextLine());
        System.out.print("name : ");
        map.put("name", scan.nextLine());
        return map;
    }
    public void SignupComplete() {
        System.out.println("회원가입 완료!");
    }
    public void NotLogin() {
        System.out.println("로그인 후 이용해주세요.");
    }
    public void ExistID() {
        System.out.println("이미 존재하는 아이디입니다.");
    }
    public HashMap<String, String> LoginPrint() {
        HashMap<String, String> map = new HashMap<>();
        System.out.print("ID : ");
        map.put("ID", scan.nextLine());
        System.out.print("PW : ");
        map.put("PW", scan.nextLine());
        return map;
    }
    public void LoginSuccess(String name) {
        System.out.println(name + "님 환영합니다!");
    }
    public void UnableLogin() {
        System.out.println("등록된 회원이 아닙니다.");
    }
    public HashMap<String, String> AddPrint() {
        HashMap<String, String> map = new HashMap<>();
        System.out.print("제목 : ");
        map.put("제목", scan.nextLine());
        System.out.print("내용 : ");
        map.put("내용", scan.nextLine());
        return map;
    }
    public void AddSuccess() {
        System.out.println("게시물이 등록되었습니다.");
    }
    public void List(ArrayList<Post> post) {
        System.out.println("================");
        for(Post p : post) {
            System.out.println("번호 : " + p.getNumber());
            System.out.println("제목 : " + p.getTitle());
            System.out.println("================");
        }
    }
    public void ListEmpty() {
        System.out.println("게시물이 존재하지 않습니다.");
    }
    public void UpdateNum() {
        System.out.print("수정할 게시물 번호 : ");
    }
    public int InputNum() {
        return  Integer.parseInt(scan.nextLine());
    }
    public void Complete() {
        System.out.println("완료되었습니다.");
    }
    public HashMap<String, String> UpdatePrint() {
        HashMap<String, String> map = new HashMap<>();
        System.out.print("새 제목 : ");
        map.put("새 제목", scan.nextLine());
        System.out.print("새 내용 : ");
        map.put("새 내용", scan.nextLine());
        return map;
    }
    public void NotExist() {
        System.out.println("없는 게시물 번호입니다.");
    }
    public void DeleteNum() {
        System.out.print("삭제할 게시물 번호 : ");
    }
    public void DetailNum() {
        System.out.print("상세보기 할 게시물 번호 : ");
    }
    public void DetailPrint(Post index) {
        System.out.println("================");
        System.out.println("번호 : " + index.getNumber());
        System.out.println("제목 : " + index.getTitle());
        System.out.println("내용 : " + index.getContent());
        System.out.println("작성자 : " + index.getWritter());
        System.out.println("작성일 : " + index.getDatetime());
        System.out.println("================");
    }
    public void ExitPrint() {
        System.out.println("프로그램 종료");
    }
    public void Unable() {
        System.out.println("권한이 없습니다.");
    }
}
