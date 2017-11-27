package objects;

public class Company {
    String id, name, parenthesisSubstring;

    public Company(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company(String id, String name, String parenthesisSubstring) {
        this.id = id;
        this.name = name;
        this.parenthesisSubstring = parenthesisSubstring;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParenthesisSubstring() {
        return parenthesisSubstring;
    }

    public void setParenthesisSubstring(String parenthesisSubstring) {
        this.parenthesisSubstring = parenthesisSubstring;
    }
}
