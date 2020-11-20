package Interview;

public class SwitchQuestion {
    public static void main(String[] args) {
        String param = null;

        //空指针异常
//        switch (param){
//            case"null":
//                System.out.println("null");
//                break;
//            default:
//                System.out.println("default");
//        }

        switch (param="null"){
            case"null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
