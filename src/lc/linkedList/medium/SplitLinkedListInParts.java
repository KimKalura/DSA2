package lc.linkedList.medium;

import lc.linkedList.easy.LinkedListCycle;

public class SplitLinkedListInParts {

    //Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
    //The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
    //The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
    //Return an array of the k parts.

    //Input: head = [1,2,3], k = 5
    //Output: [[1],[2],[3],[],[]]
    //The first element output[0] has output[0].val = 1, output[0].next = null.
    //The last element output[4] is null, but its string representation as a ListNode is [].

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while (current != null) {//lungimea listei
            length++;
            current = current.next;
        }

        //calculam dimensiunea fiecărei parti
        int partSize = length / k; // dimensiunea minimă a fiecărei parti
        int extraNodes = length % k; // numărul de parti care necesită un nod suplimentar

        //initializam array-ul result
        ListNode[] result = new ListNode[k];
        current = head;

        for (int i = 0; i < k; i++) {
            //pentru fiecare parte, incepem cu nodul curent
            result[i] = current;
            int currentPartSize = partSize + (i < extraNodes ? 1 : 0); //adăugam un nod suplimentar la primele părți `extraNodes`

            //mergem prin partea curentă și întrerupem legătura
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) {
                    current = current.next;
                }
            }

            //daca este necesar intrerupem leg
            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }
        }

        return result;
    }

    //*length % k -> calculează restul când lungimea totală a listei este împărțită la k. Este folosit pentru a distribui uniform nodurile
    // suplimentare în primele câteva părți ale diviziunii rezultate

}
