package syncEx;

public class RaceCondition implements Runnable {

    private CommonRes commonRes = new CommonRes();


    @Override
    public void run() {
    }

    public CommonRes getCommonRes() {
        return commonRes;
    }

    public void setCommonRes(CommonRes commonRes) {
        this.commonRes = commonRes;
    }
}
