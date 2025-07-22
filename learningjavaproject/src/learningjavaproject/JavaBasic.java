package learningjavaproject;
//import java.util.Arrays;

public class JavaBasic {
	static String name;
	
	public static void main(String[] args) {
		String x = "hello";
		setName(x);
		getName();
		x = "world";
		getName();
            
	}
	
    public static void setName(String namesx) {
        name = namesx;
    }
    
    public static void getName() {
        System.out.println(name);
    }
}
