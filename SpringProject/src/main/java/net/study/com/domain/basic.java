package net.study.com.domain;

public class basic {

    private int no;
    private String col1;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    @Override
    public String toString() {
        return "basic{" +
                "no=" + no +
                ", col1='" + col1 + '\'' +
                '}';
    }
}
