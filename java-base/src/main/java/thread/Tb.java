package thread;

public class Tb extends Thread{
    private HasSelfPrivateNum hasSelfPrivateNum;

    public Tb(HasSelfPrivateNum hasSelfPrivateNum) {
        super();
        this.hasSelfPrivateNum=hasSelfPrivateNum;
    }

    @Override
    public void run(){
        super.run();
        hasSelfPrivateNum.addI("b");
    }
}
