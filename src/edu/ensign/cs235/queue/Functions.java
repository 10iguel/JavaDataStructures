package edu.ensign.cs235.queue;

public class Functions {
    public static void main(String[] args) {
        String month = "";
        month = "April";
        switch (month){
            case "March":
                System.out.println(month);
                break;
            case "April":
                month = "October";
                System.out.print(month);
                break;
            case "May":
                System.out.println(", May");
                break;
            default:
                System.out.println("Not here");
        }
        myFunction("Hey");
    }
    public static void myFunction(String ar7){
        System.out.println(ar7);
    }
}
