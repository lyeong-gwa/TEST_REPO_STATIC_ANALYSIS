package dummy.blocker;

public class JavaBlockerRules {

    private volatile Object resource;

    public Object getResource() {
        if (resource == null) {
            synchronized (this) {
                if (resource == null) {
                    resource = new Object();
                }
            }
        }
        return resource;
    }

    private static JavaBlockerRules instance;

    public static JavaBlockerRules getInstance() {
        if (instance == null) {
            synchronized (JavaBlockerRules.class) {
                if (instance == null) {
                    instance = new JavaBlockerRules();
                }
            }
        }
        return instance;
    }
}
