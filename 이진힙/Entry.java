//자료구조 과제 #8(60200216)
package 이진힙;

public class Entry <Key extends Comparable<Key>, Value> {
    private Key ky;
    private Value val;
    public Entry (Key newKey, Value newValue) {
        ky = newKey;
        val = newValue;
    }

    public Key getKey() {
        return ky;
    }

    public void setKey(Key newKey) {
        this.ky = newKey;
    }

    public Value getValue() {
        return val;
    }

    public void setValue(Value newValue) {
        this.val = newValue;
    }
}
