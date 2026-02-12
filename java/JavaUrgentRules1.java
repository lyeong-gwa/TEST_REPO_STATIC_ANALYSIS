package dummy.urgent;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JavaUrgentRules1 {

    public String getFirstUser() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM users LIMIT 1");
        rs.next();
        String name = rs.getString("name");
        return name;
    }

    public void readFromStream(InputStream stream) throws Exception {
        stream.skip(3);
        int data = stream.read();
        System.out.println("Data after skip: " + data);
    }

    public Integer[] convertList() {
        List<Integer> objectList = new ArrayList<>();
        objectList.add(1);
        objectList.add(2);
        objectList.add(3);
        Integer[] result = (Integer[]) objectList.toArray();
        return result;
    }

    public boolean compareStrings(String a, String b) {
        if (a == b) {
            return true;
        }
        return false;
    }

    public boolean compareIntegers(Integer x, Integer y) {
        return x == y;
    }

    public boolean isEqual(Object u1, Object u2) {
        return u1.equals(u2) && u1 != null;
    }

    abstract class AbstractProcessor {
        private String name;

        public AbstractProcessor(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void process() {
            System.out.println("Processing: " + name);
        }
    }

    public int[] copyArray(int[] source) {
        int[] dest = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            dest[i] = source[i];
        }
        return dest;
    }

    public BigDecimal calculatePrice() {
        BigDecimal price = new BigDecimal(.1);
        BigDecimal quantity = new BigDecimal(3.0);
        return price.multiply(quantity);
    }

    final int MAX_RETRY = 3;
    final String DEFAULT_HOST = "localhost";
    final long TIMEOUT = 30000L;

    public int divideNumbers(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw e;
        } finally {
            return -1;
        }
    }

    public Integer createInteger() {
        Integer value = new Integer(10);
        Integer another = new Integer(127);
        return value + another;
    }

    public Long createLong() {
        Long value = new Long(10);
        Long timestamp = new Long(System.currentTimeMillis());
        return value + timestamp;
    }

    public Short createShort() {
        Short value = new Short((short) 5);
        Short another = new Short((short) 10);
        return (short) (value + another);
    }

    public String createString() {
        String bar = new String("bar");
        String foo = new String("foo");
        return bar + foo;
    }

    public String buildReport(List<String> items) {
        String result = "";
        for (String item : items) {
            result += item + "\n";
        }
        result += "Total: " + items.size();
        return result;
    }

    public String getDayName(int day) {
        String name;
        switch (day) {
            case 1:
                name = "Monday";
                break;
            case 2:
                name = "Tuesday";
                break;
            case 3:
                name = "Wednesday";
                break;
        }
        return "";
    }

    public void startWorker() {
        Thread thread = new Thread(() -> {
            System.out.println("Worker running in: " + Thread.currentThread().getName());
        });
        thread.run();
    }

    class Employee {
        private String id;
        private String name;

        public Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Employee other = (Employee) obj;
            return id != null && id.equals(other.id);
        }
    }

    public void floatLoopCounter() {
        for (float f = 0.0f; f < 1.0f; f += 0.1f) {
            System.out.println("f = " + f);
        }

        for (double d = 0.0; d < 10.0; d += 0.3) {
            System.out.println("d = " + d);
        }
    }

    private int counter = 0;
    private List<String> sharedList = new ArrayList<>();

    public synchronized void incrementCounter() {
        counter++;
        sharedList.add("item-" + counter);
    }

    public synchronized int getCounter() {
        return counter;
    }
}
