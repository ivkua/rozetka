package pageObject;


public class BasePage extends PageObject{

    public void delay(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
