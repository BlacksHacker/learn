package Generic;

public class Automobile {

    private String msg;

    public void setMsg(String msg){
        this.msg = msg;
    }

    public void showMessage(){
        System.out.println(msg);
    }
}

class Holder<T>{
    private T obj;

    public Holder(T obj){
        this.obj = obj;
    }

    public void setObj(T obj){
        this.obj = obj;
    }

    public static void main(String[] args) {
        Holder<Automobile> m = new Holder<Automobile>(new Automobile());
        m.obj.setMsg("yes it is me");
        m.obj.showMessage();
    }
}

class TwoTuple<A, B>{
    public final A mobile;

    public final B holder;

    public TwoTuple(A mobile, B holder){
        this.mobile = mobile;

        this.holder = holder;
    }

    public void getMessage(){
        System.out.println(mobile.toString() + "----" + holder.toString());
    }

    public static TwoTuple<Automobile, Holder<Automobile>> get(){
        return new TwoTuple<Automobile, Holder<Automobile>>(new Automobile(), new Holder(new Automobile()));
    }

    public static void main(String[] args) {
        TwoTuple<Automobile, Holder<Automobile>> tt = TwoTuple.get();
        tt.getMessage();
    }
}

class LinkedStack<T>{

}



