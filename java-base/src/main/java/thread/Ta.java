package thread;

public class Ta extends Thread {
    private HasSelfPrivateNum hasSelfPrivateNum;

    public Ta(HasSelfPrivateNum hasSelfPrivateNum) {
        super();
        this.hasSelfPrivateNum=hasSelfPrivateNum;
    }

    @Override
    public void run(){
        super.run();
        hasSelfPrivateNum.addI("a");
    }
}
