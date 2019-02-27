interface BuySomething{
    void buy();
}
class Client implements BuySomething{
    public void buy(){
        System.out.println("付钱");
    }
}
class ProexPeople implements BuySomething{
    private BuySomething client;
    public ProexPeople(BuySomething client){
        this.client=client;
    }
    public void beforeBuy(){
        System.out.println("到达店内");
    }
    public void afterBuy(){
        System.out.println("寄快递");
    }
    public void buy(){
        beforeBuy();
        this.client.buy();
        afterBuy();
    }
}
public class Test {
    public static void main(String[] args) {
        ProexPeople per=new ProexPeople(new Client());
        per.buy();
    }
}
