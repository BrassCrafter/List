import NRW.List;
import com.sun.jdi.IntegerType;
import jdk.jfr.ContentType;

public class ListEditor {
    public static void main(String[] args) {
        List<Integer> list = new List<Integer>();
        int listLength = 10;
        fillListWithInts(list, listLength);
        outputListToConsole(list);
        selectionSortOnList(list);
        //mergeSortOnList(list);
        //reverseListInPlace(list);
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
        pList.toFirst();
        while(!pList.isEmpty()){

            pList.remove();
        }
        System.out.println("List cleared.");
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
    public static void mergeSortOnList(List<Integer> pList){
        List<Integer> leftList = new List<Integer>();
        List<Integer> rightList = new List<Integer>();
        pList.toFirst();
        while(!pList.isEmpty()){
            leftList.append(pList.getContent());
            pList.remove();
            if(!pList.isEmpty()){
                rightList.append(pList.getContent());
                pList.remove();
            }
        }
        if(getLengthOfList(leftList) > 1)mergeSortOnList(leftList);
        if(getLengthOfList(rightList) > 1)mergeSortOnList(rightList);
        mergeLists(leftList, rightList, pList);
    }
    private static void mergeSortMerge(List<Integer> pLeftList, List<Integer> pRightList, List<Integer> pList){
        pLeftList.toFirst();
        pRightList.toFirst();
        while(!pLeftList.isEmpty() && !pRightList.isEmpty()){
            if((pLeftList.getContent()) < pRightList.getContent()){
                pList.append(pLeftList.getContent());
                pLeftList.remove();
            }else{
                pList.append(pRightList.getContent());
                pRightList.remove();
            }
        }
        while(!pLeftList.isEmpty()){
            pList.append(pLeftList.getContent());
            pLeftList.remove();
        }
        while(!pRightList.isEmpty()){
            pList.append(pRightList.getContent());
            pRightList.remove();
        }
    }
    public static void selectionSortOnList(List<Integer> pList){
        int i = 0;
        while(pList.hasAccess()){
            if(i < getLengthOfList(pList))pList.toFirst();
            System.out.println("i: " + i);
            for(int j = 0; j < i; j++)pList.next();
            int min = pList.getContent();
            while(pList.hasAccess()){
                if(pList.getContent() < min)min = pList.getContent();
                pList.next();
            }
            System.out.println("Min: " + min);
            pList.toFirst();
            for(int j = 0; j < i; j++)pList.next();
            while(pList.getContent() != min)pList.next();

            pList.remove();
            pList.toFirst();
            pList.insert(min);
            outputListToConsole(pList);
            i++;
            pList.next();
        }
        reverseListInPlace(pList);
    }
    public static void insertionSortOnList(List<Integer> pList){

    }
}
