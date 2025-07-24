package learningjavaproject;

/*
 * StringBuilder，它是一个可变对象，可以预分配缓冲区
 */

public class StringBuilderDemo {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder(1024);
		for (int i = 0; i < 1000; i++) {
		    sb.append(',');
		    sb.append(i);
		}
		String s = sb.toString();
		System.out.println(s);
		
		// 链式操作
        var sb1 = new StringBuilder(1024);
        sb1.append("Mr ")
          .append("Bob")
          .append("!")
          .insert(0, "Hello, ");
        System.out.println(sb1.toString());
        
//        请使用StringBuilder构造一个INSERT语句
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String ss = String.format("INSERT INTO employee (name, position, salary) VALUES (%s, %s, %s)", fields[0], fields[1], fields[2]);   
        System.out.println(ss.equals(insert) ? "测试成功" : "测试失败");
 
	}
	
    static String buildInsertSql(String table, String[] fields) {
        var sb = new StringBuilder(1024);
        sb.append("INSERT INTO employee (name, position, salary) VALUES (")
        .append(fields[0])
        .append(", ")
        .append(fields[1])
        .append(", ")
        .append(fields[2])
        .append(")");
        
        return sb.toString();
    }
}
