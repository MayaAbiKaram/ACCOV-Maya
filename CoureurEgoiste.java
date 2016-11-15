package ex3;

public class CoureurEgoiste extends Thread
{
  private static int tick = 0;
  
  public CoureurEgoiste(String n)
  {
      super(n);
  }
  
  public void run()
  {
    System.out.println("Thead name: " + this.getName() + " /priority: " + this.getPriority() + " /groupe: " +     this.getThreadGroup() + " /isDemon: " + this.isDaemon());
    while (tick < 40000000)
    {
      tick++; 
   
      if ((tick % 5000) == 0)
      {
        System.out.println("Thread #" + Thread.currentThread().getName()+
        " tick = " + tick); 
       } 
    } 
  }
  
  public static void main(String[]args)
  {
    CoureurEgoiste thr1 = new CoureurEgoiste("thr1");
    CoureurEgoiste thr2 = new CoureurEgoiste("thr2");
    CoureurEgoiste thr3 = new CoureurEgoiste("thr3");
    thr1.setPriority(Thread.MAX_PRIORITY);
    thr2.setPriority(Thread. MIN_PRIORITY);
    
    thr1.start();
    thr2.start();
    thr3.start();
    
    System.out.println(Thread.activeCount());
   
    try
    {
      	thr1.join();
      	thr2.join();
      	thr3.join();
    }
    catch(Exception e)
    {
        System.out.println(e.toString());
    }
  
    System.out.println("fin de P2c"); 
    System.exit(0); 
  }

}
