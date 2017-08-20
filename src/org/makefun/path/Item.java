package org.makefun.path;

public class Item implements Comparable {

    int x;
    int y;
    int priority;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Item(int x, int y, int priority) {
        this.x = x;
        this.y = y;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Item))
            return false;
        Item item = (Item) obj;
        return this.x == item.x && this.y == item.y;
    }

    @Override
    public int compareTo(Object obj) {
        if (obj == this)
            return -1;
        if (!(obj instanceof Item))
            return -1;
        Item item = (Item) obj;
        return Integer.compare(this.priority, item.priority);
    }
}