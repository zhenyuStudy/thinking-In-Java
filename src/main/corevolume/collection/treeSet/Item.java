package collection.treeSet;

import java.util.Objects;

public class Item implements Comparable<Item> {

    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[description=" + description + ", partNumber=" + partNumber +"]";
    }

    @Override
    public boolean equals(Object otherObj) {
        if(this == otherObj) return true;
        if(otherObj == null) return false;
        if (getClass() != otherObj.getClass()) return false;
        Item other = (Item) otherObj;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNumber, o.partNumber);
        return diff != 0 ? diff : description.compareTo(o.description);
    }
}
