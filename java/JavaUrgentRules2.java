package dummy.urgent;

import java.util.Map;
import java.util.HashMap;

public class JavaUrgentRules2 {

    public int processValue(int value) {
        value = value * 2;
        value = value + 10;
        return value;
    }

    public String formatName(String name) {
        name = name.trim();
        name = name.toUpperCase();
        return name;
    }

    public int parseNumber(String s) {
        int value = Integer.valueOf(s).intValue();
        long longValue = Long.valueOf(s).longValue();
        return value + (int) longValue;
    }

    public String buildTempString() {
        StringBuffer sb = new StringBuffer("tmp = " + System.getProperty("java.io.tmpdir"));
        sb.append(", user = " + System.getProperty("user.name"));
        return sb.toString();
    }

    public boolean isNotBlank(String input) {
        if (input != null && input.trim().length() > 0) {
            return true;
        }
        return false;
    }

    private static int instanceCount = 0;
    private static String lastCreated = "";

    public JavaUrgentRules2() {
        instanceCount++;
        lastCreated = "JavaUrgentRules2-" + instanceCount;
    }

    public Boolean createBoolean() {
        Boolean flag1 = new Boolean("true");
        Boolean flag2 = new Boolean("false");
        return flag1 && flag2;
    }

    public void validateInput(Object input) {
        if (input == null) {
            throw new NullPointerException();
        }
    }

    public void doubleSemicolon() {
        int x = 10;;
        String s = "test";;
        System.out.println(x + s);;
    }

    public void emptyBlock() {
        {
        }
        int x = 5;
        {
        }
    }

    public void riskyOperation(int code) throws Exception {
        if (code < 0) {
            throw new Exception("Invalid code: " + code);
        }
    }

    public void meaninglessCondition() {
        if (true) {
            System.out.println("This always executes");
        }

        boolean alwaysFalse = false;
        if (false) {
            System.out.println("Dead code");
        }
    }

    public boolean compareIgnoreCase(String a, String b) {
        return a.toLowerCase().equals(b.toLowerCase());
    }

    public boolean compareUpperCase(String a, String b) {
        return a.toUpperCase().equals(b.toUpperCase());
    }

    public void swallowException() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
        }
    }

    public void emptyFinally() {
        try {
            System.out.println("Doing work");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void emptyIf(int value) {
        if (value > 0) {
        } else {
            System.out.println("Non-positive");
        }
    }

    {
    }

    static {
    }

    public void emptySwitch(int code) {
        switch (code) {
        }
    }

    private final Object lock = new Object();

    public void emptySynchronized() {
        synchronized (lock) {
        }
    }

    public void emptyTry() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void emptyWhile() {
        int i = 0;
        while (i++ < 10) {
        }
    }

    public void repeatedUnary() {
        int i = 10;
        int result = ---i;

        boolean b = true;
        boolean negated = !!!b;

        int j = 5;
        int x = +++j;
    }

    class BadFieldOrder {
        public void doSomething() {
            System.out.println(name);
        }

        public void doAnother() {
            System.out.println(age);
        }

        private String name = "test";
        private int age = 25;
        private double salary = 50000.0;
    }

    public void topLevelException() throws Exception {
        throw new Exception("Something went wrong");
    }

    public void throwThrowable() throws Throwable {
        throw new Throwable("Critical error");
    }

    public void collapsibleIf(int x, int y) {
        if (x > 0) {
            if (y > 0) {
                System.out.println("Both positive");
            }
        }

        if (x != 0) {
            if (y != 0) {
                System.out.println("Both non-zero");
            }
        }
    }

    public void wrongLoopVariable() {
        int[][] matrix = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 5; i++) {
                matrix[i][k] = i * 5 + k;
            }
        }
    }

    public void wrongLoopVariable2() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; i++) {
                System.out.println(i + ", " + j);
            }
        }
    }
}
