import NRW.List;
import com.sun.jdi.IntegerType;
import jdk.jfr.ContentType;

public class ListEditor {
    public static void main(String[] args) {
        List<Integer> list = new List<Integer>();
        int listLength = 10;
        fillListWithInts(list, listLength);
        outputListToConsole(list);
        reverseListInPlace(list);
        outputListToConsole(list);
        System.out.println("Length of list: " + getLengthOfList(list));
        clearList(list);
        System.out.println("Length of list: " + getLengthOfList(list));
    }
    public static void fillListWithInts(List<Integer> pList, int pListLength){
        for(int i = 0; i < pListLength; i++)
            pList.append((int)(Math.random()*pListLength));
    }
    public static <T> void clearList(List<T> pList){
        while(!pList.isEmpty()){
            pList.toFirst();
            pList.remove();
        }
        System.out.println("List cleared. ");
    }
    public static <T> void reverseListInPlace(List<T> pList){
        pList.toFirst();
        if(!pList.hasAccess())return;
        T temp = pList.getContent();
        pList.remove();
        reverseListInPlace(pList);
        pList.append(temp);
    }
    public static <T> void outputListToConsole(List<T> pList){
        pList.toFirst();
        if(!pList.hasAccess())System.out.println("List is empty. ");
        while(pList.hasAccess()){
            System.out.print(pList.getContent() + " | ");
            pList.next();
        }
        pList.toFirst();
        System.out.print("\n");
    }
    public static <T> int getLengthOfList(List<T> pList){
        pList.toFirst();
        if(!pList.hasAccess())return 0;
        int length = 0;
        while(pList.hasAccess()){
            length++;
            pList.next();
        }
        pList.toFirst();
        return length;
    }
}
