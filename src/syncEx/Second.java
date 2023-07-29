package syncEx;

public class Second {

    private First first;

    public synchronized String getString() {
        return "This is second string";
    }

    public synchronized String getFromFirstObj() {
        String s = "";
        try{
            s = first.getString();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        return s;
    }


    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        this.first = first;
    }
}
