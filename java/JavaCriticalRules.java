package dummy.critical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;

public class JavaCriticalRules {

    public void queryDatabase() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "user", "pass");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }

    public void readFile() throws IOException {
        FileInputStream fis = new FileInputStream("/tmp/data.txt");
        int data = fis.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fis.read();
        }
    }

    public void useThreadGroup() {
        ThreadGroup group = new ThreadGroup("worker-group");
        Thread t1 = new Thread(group, () -> {
            System.out.println("Task 1");
        });
        Thread t2 = new Thread(group, () -> {
            System.out.println("Task 2");
        });
        t1.start();
        t2.start();
        System.out.println("Active threads: " + group.activeCount());
    }

    public boolean checkNull(String target) {
        if (target.equals(null)) {
            return true;
        }
        return false;
    }

    public void unnecessaryContinue(int[] numbers) {
        for (int num : numbers) {
            if (num > 0) {
                System.out.println("Positive: " + num);
            } else {
                System.out.println("Non-positive: " + num);
            }
            continue;
        }
    }

    public boolean validateTarget(String target) {
        if (target != null || !target.equals("")) {
            return true;
        }
        return false;
    }

    interface DatabaseConstants {
        String DB_HOST = "localhost";
        int DB_PORT = 3306;
        String DB_NAME = "production";
        String DB_USER = "admin";
        int MAX_CONNECTIONS = 100;
        int TIMEOUT_SECONDS = 30;
    }

    public int sumPositive(int[] values) {
        int sum = 0;
        int i = 0;
        while (i < values.length)
            sum += values[i++];
        return sum;
    }

    public void initialize() {
    }

    public void onDestroy() {
    }

    public void callback() {
    }

    public void processOrder(String orderId) {
        System.out.println("Processing order: " + orderId);
        try {
            System.out.println("Order processed successfully: " + orderId);
        } catch (Exception e) {
            System.out.println("Error processing order: " + e.getMessage());
            System.err.println("Stack trace: " + e);
        }
    }
}
