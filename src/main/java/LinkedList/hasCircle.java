package LinkedList;

public class hasCircle {
    public static void main(String[] args) {
        JieDian j1 = new JieDian(11,1);
        JieDian j2 = new JieDian(22,2);
        JieDian j3 = new JieDian(33,3);
        JieDian j4 = new JieDian(44,4);
        JieDian j5 = new JieDian(55,5);
        JieDian j6 = new JieDian(66,6);
        JieDian j7 = new JieDian(77,7);
        JieDian j8 = new JieDian(88,8);
        JieDian j9 = new JieDian(99,9);
        JieDian j10 = new JieDian(110,1);
        JieDian j11 = new JieDian(111,1);
        j1.next = j2;
        j2.next = j3;
        j3.next = j4;
        j4.next = j5;
        j5.next = j6;
        j6.next = j7;
        j7.next = j8;
        j8.next = j9;
        j9.next = j10;
        j10.next = j11;
        j11.next = j5;

        //环长
        int x = length(hasLoop(j1));
        System.out.println(x);
        //入口
        entrance(j1,hasLoop(j1)).display();
    }

    public static JieDian entrance(JieDian jd1, JieDian jd2){
        JieDian a1 = jd1;
        JieDian a2 = jd2;
        while(true){
            a1 = a1.next;
            a2 = a2.next;
            int i1 = a1.iData;
            int i2 = a2.iData;

            double d1 = a1.dData;
            double d2 = a2.dData;
            if(i1 ==i2 && d1 ==d2){
                return a1;
            }
        }
    }

    public static int length(JieDian jd){
        JieDian slow = jd;
        JieDian fast = jd;
        int length = 0;
        while (fast != null){
            length++;
            slow = slow.next;
            fast = fast.next.next;

            int i1 = slow.iData;
            int i2 = slow.iData;

            double d1 = slow.dData;
            double d2 = fast.dData;
            if(i1 ==i2 && d1 == d2){
                return length;
            }
        }
        return 0;
    }

    public static JieDian hasLoop(JieDian jd){
        JieDian slow = jd;
        JieDian fast = jd;

        while (fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null){
                System.out.println("No Circle");
                return null;
            }

            int i1 = slow.iData;
            int i2 = slow.iData;

            double d1 = slow.dData;
            double d2 = fast.dData;
            if(i1 ==i2 && d1 == d2){
                System.out.println("Has Circle");
                return slow;
            }
        }
        return null;
    }
}

class JieDian{
    int iData;
    double dData;
    JieDian next;
    JieDian(int id, double dd){
        iData = id;
        dData = dd;
    }

    public void display(){
        System.out.println("{" + iData + "," +dData + "}");
    }
}