package syncEx;

public class First {

    private Second second;


    public synchronized String getString() {
        return "This is fisrt string";
    }

    public synchronized String getFromSecondObj() {
        String s = "";
        try{
            s = second.getString();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        return s;
    }

    public Second getSecond() {
        return second;
    }

    public void setSecond(Second second) {
        this.second = second;
    }
}
