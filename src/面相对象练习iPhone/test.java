package 面相对象练习iPhone;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class mobilephone{
    int power;
    abstract void call();
    abstract void musicplayer();
}
class iPhone extends mobilephone{
    final int Rate = 50;
    AtomicInteger power;
    AtomicBoolean iscall=new AtomicBoolean(true);
    iPhone(){
        //atomic没有double，电量100%，一秒刷新20次，每次减1，一秒耗电1%，所以设置为2000，
        power = new AtomicInteger(2000);
    }
    public void system(AtomicBoolean iscall) {
        new Thread(()->{
            try {
                while (power.intValue()>0) {
                    wait(Rate);
                    System.out.print("输入指令:[A]call [B]stop_call [C]music [D]stop_music");
                    char i = (char) System.in.read();
                    switch (i){
                        case 'a':new Thread(this::call).start();
                        case 'b':new Thread(this::stopCall).start();

                    }
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void stopCall() {
        iscall.compareAndSet(true,false);//如果为false他会一直等么？
    }

    public void call(){
        final int consumption = 1;
        System.out.println("拨号中");
        try {
            while (power.intValue()>0||iscall.get()) {
                wait(Rate);
                System.out.println("通话中");
                power.getAndDecrement();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            iscall.compareAndSet(false,true);
        }
        System.out.println("挂断");
    }

    void musicplayer(){
        System.out.println();
    };
}

public class test {
    public static void main(String[] args) throws IOException {
        mobilephone p = new iPhone();
    }
}
