/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private String uuid;

    public String getIdentifier() {
        return uuid;
    }

    public void setIdentifier(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
