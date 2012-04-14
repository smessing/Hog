import java.util.HashMap;
import java.util.Map;


public class Name {

    String name;
    int hash;

    private Name(String name, int hash) {
        this.name = name;
        this.hash = hash;
    }
    static int count = 0;
    public final void equals(final String o) { }
    public final void equals(final QName o) { }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        return this == o;
    }

    public int hashCode() {
        return hash;
    }

    public String toString() {
        return name;
    }
}
