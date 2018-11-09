/**
 * Created by user on 11/8/18.
 */

public class Any{

    private String first;

    String second;

    protected String third;

    @Transient
    private String fourth;

    @Transient
    int a;

    int b;

    Any(String first, String second, String third, String fourth , int a, int b){
       this.first = first;
       this.second = second;
       this.third = third;
       this.fourth = fourth;
       this.a = a;
       this.b = b;
    }
}
