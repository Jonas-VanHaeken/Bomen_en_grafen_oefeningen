public class SampleDemo implements Runnable{
    private Thread t;
    private String threadName;

    SampleDemo (String ThreadName){
        this.threadName = ThreadName;
    }

    public void run(){
        while(true){
            System.out.println(threadName);
        }
    }

    public void start(){
        if (t==null){
            t = new Thread (this, threadName);
            t.start();
        }
    }
}
