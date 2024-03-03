import java.util.Scanner;
public class MyTime {
    private int hour;
    private int minute;
    private int seconde;

    public void setTime(int hour, int minute, int seconde) {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || seconde < 0 || seconde > 59) {
            System.out.println("Invalid time values");
        } else {
            this.hour = hour;
            this.minute = minute;
            this.seconde = seconde;
        }
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }

    public void setSeconde(int seconde) {
        this.seconde = seconde;
    }

    public int getSeconde() {
        return seconde;
    }

    @Override
    public String toString() {
        if (getHour()<10 && getMinute()>10 && getSeconde()>10){
            return "0"+getHour()+":"+getMinute()+":"+getSeconde();
        } else if (getMinute()<10 && getHour() >10 && getSeconde() >10) {
            return getHour()+":0"+getMinute()+":"+getSeconde();
        } else if (getSeconde()<10 && getHour() > 10 && getMinute() >10) {
            return getHour()+":"+getMinute()+":0"+getSeconde();
        } else if (getHour()<10 && getMinute()<10 && getSeconde()<10) {
            return "0"+getHour()+":0"+getMinute()+":0"+getSeconde();
        }else {
            return getHour()+":"+getMinute()+":"+getSeconde();
        }
    }

    public void nextSeconde(){
        setSeconde(getSeconde()+1);
        if (getSeconde()  == 60){
            setSeconde(0);
            setMinute(getMinute()+1);
        }
        if (getMinute()==60){
            setMinute(0);

            setHour(getHour()+1);
        }
        if (getHour()==24){
            setHour(0);
        }
        System.out.println(toString());
    }
    public void nextMinute(){
        setMinute(getMinute()+1);
        if (getMinute()==60){
            setMinute(0);
            setHour(getHour()+1);
        }
        if (getHour()==24){
            setHour(0);
        }
        System.out.println(toString());
    }
    public void nextHour(){
        setHour(getHour()+1);

        if (getHour()==24){
            setHour(0);
        }
        System.out.println(toString());
    }
    public void proviusHour(){
        setHour(getHour()-1);
        if (getHour()<0){
            setHour(23);
        }
        System.out.println(toString());
    }
    public void proviusMinute(){
        setMinute(getMinute()-1);
        if (getMinute()<0){
            setMinute(59);
            setHour(getHour()-1);
            if(getHour()<0){
                setHour(23);
            }
        }
        System.out.println(toString());
    }
    public void proviusSecond(){
        setSeconde(getSeconde()-1);
        if (getSeconde()<0){
            setSeconde(59);
            setMinute(getMinute()-1);
            if (getMinute()<0){
                setMinute(59);
                setHour(getHour()-1);
                if (getHour()<0){
                    setHour(23);
                }
            }

        }
        System.out.println(toString());

    }


    public static void main(String[] args) {
        MyTime myTime=new MyTime();
        Scanner scanner=new Scanner(System.in);
        int h=scanner.nextInt();
        int m=scanner.nextInt();
        int s=scanner.nextInt();
        myTime.setHour(h);
        myTime.setMinute(m);
        myTime.setSeconde(s);
        myTime.setTime(h,m,s);
        myTime.nextSeconde();
        myTime.nextMinute();
        myTime.nextHour();
        System.out.println("provius");
        myTime.proviusHour();
        myTime.proviusMinute();
        myTime.proviusSecond();


    }
}
