package operation;

import java.io.Serializable;

public class Operation  implements Serializable {	
	private int nb1;
    private int nb2;
    private char oper;
    private int res;   
    
public Operation(int nb1, int nb2, char oper){
        this.nb1 = nb1;
        this.nb2 = nb2;
        this.oper = oper;
    }
	public int getNb1(){
    return nb1;
	}

	public int getNb2(){
    return nb2;
	}

	public char getOper(){
    return oper;
	}

	public void setRes(int res){
    this.res = res;
	}

	public int getRes(){
    return res;
	}
}