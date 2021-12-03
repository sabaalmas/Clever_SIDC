
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class CleverSIDC {
    private Node head;
    private Node tail;
    private int size;

    public CleverSIDC() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    class Node {
        private long key;
        private String value;
        Node next;

        public Node(long key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Node(long key, String value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public long getKey() {
            return key;
        }

        public void setKey(long key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


    // n -> N -> new Node
    // N          ^


    void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }

    int partition(long[] arr, long pivot, int pivot_index, int low) {
        int i = low, j = low;
        while (j < arr.length) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        swap(arr, i, pivot_index);
        return i;
    }


    // quickSort([], 0, length - 1)

    /*
    * Quick Sort.
    * [40, 20 , 9, 10, 11, 12]
                            ^
    * [ 10, 9, 11,  12, 40, 20 ]
    * */

    void quickSort(long[] keys, int low, int high) {
        if (low >= high) {
            return;
        }
        long pivot = keys[high];
        int result = partition(keys, pivot, high, low);
        quickSort(keys, 0, result - 1);
        quickSort(keys, result + 1, high);
    }

    void removeElement(int key) {
        // head is null.
        if (head == null) {
            return;
        }
        // only head is present.
        if (head == tail && head.next == null) {
            head = null;
            tail = null;
        }

        // N - N - N - N - N
        //                 ^
        //             c
        Node current = head;
        while (current.next != null) {
            if (current.next.getKey() == key) {
                Node temp = current.next.next;
                current.next = temp;
            }
            current = current.next;
        }
        size--;
    }

    void SetSIDCThreshold(int Size) {
        if (100 <= Size && Size <= 500000) {
            System.out.println("implementation");
        }
    }

    long[] allKeys() {
        Node current = head;
        if (head == null) {
            return new long[0];
        } // N - N - N - N
        long[] result = new long[size];
        int i = 0;
        while (current != null) {
            long key = current.getKey();
            result[i] = key;
            i++;
            current = current.next;
        }
        quickSort(result, 0, result.length - 1);
        return result;
    }
    //N---  KEYS,VALUES,NEXT

    // N N N N N N
    // ^     ^

    String getValues(CleverSIDC list, long key) {

        if (head == null) {
            //System.out.println("No values to return, List is empty");
            return null;
        } else {

            Node ctr_ptr = head;
            String value = "null";
            while (ctr_ptr.next != null) {
                if (ctr_ptr.key == key) {
                    value = ctr_ptr.value;
                }
                ctr_ptr = ctr_ptr.next;
            }
            return value;
        }
    }

    void add(CleverSIDC list, long key, String value) {
        Node node = new Node(key, value);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        this.tail.next = node; // O(1) operation.
        this.tail = node;
        size++;
        return;
    }

    long nextKey(CleverSIDC list, long key) {
        // System.out.println("No next key");
        long next_key = 0;
        if (head == null) {
            System.out.println("inside if...");
            return head.key;
        } else {
            System.out.println("inside else...");
            Node ctr_ptr = head;
            while (ctr_ptr.next!= null) {
                if (ctr_ptr.key == key) {
                    next_key = ctr_ptr.next.key;
                }
                ctr_ptr = ctr_ptr.next;
            }

            return next_key;
        }

    }

    long prevKey(CleverSIDC list, long key) {
        // System.out.println("No next key");
        long prev_key = 0;
        if (head == null) {
            System.out.println("No prev element to return");
        } else {
            System.out.println("inside else...");
            Node ctr_ptr = head;
            while (ctr_ptr.next != null) {
                if (ctr_ptr.key == key) {
                    prev_key = ctr_ptr.next.key;
                }
                ctr_ptr = ctr_ptr.next;
            }
        }
        return prev_key;
    }
    public ArrayList<Long> ReadFile(CleverSIDC list,String base_location, String filename) {
      //  ArrayList<Long> array_list = new ArrayList<Long>();
       String path_final=base_location+filename;
        try {
            File myObj = new File(path_final);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                Long data = myReader.nextLong();
                //System.out.println(data);
                list.add(list,data);

            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }

}




public class Main {
    public static void main(String[] args) {
        String base_location="C:\\Users\\14386\\Downloads\\CleverSIDC-master\\CleverSIDC-master\\CleverSIDC\\src\\";
        CleverSIDC list = new CleverSIDC();
      // list.add(list, 898983, "Name: Vinayak Sareen, Age: ____");
      //  list.add(list, 898981, "Name: Almas, Age: ____");
    // list.add(list, 898982, "Name: John, Age: ____");
    //    list.add(list, 898983, "Name: Cole, Age: ____");
       // list.removeElement(898982);
      // System.out.println(list.allKeys());
      // list.getValues(list,898982);
      // long[] allKeys = list.allKeys();
    //  System.out.println(Arrays.toString(list.allKeys()));
      //System.out.println(list.getValues(list,898982));
      //System.out.println(list.getValues(list,898984));
      //  System.out.println(list.nextKey(list,898982));
        System.out.println( list.ReadFile(base_location,"NASTA_test_file1.txt"));

        //list.ReadFile(base_location,"NASTA_test_file1.txt");
    }
}
