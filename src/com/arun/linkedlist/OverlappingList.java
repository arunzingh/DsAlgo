package com.arun.linkedlist;

public class OverlappingList {
	
	Node findOverlappingNode(Node head1, Node head2) {
		
		int l1 = getLength(head1);
		int l2 = getLength(head2);
		
		Node curr1 = head1;
		Node curr2 = head2;
		
		if (l1 > l2) {
			curr1 = advanceList(head1, l1-l2);
		} else {
			curr2 = advanceList(head2, l2-l1);
		}
		
		
		while(curr1 != null && curr2 != null) {
			curr1 = curr1.next;
			curr2 = curr2.next;
			
			if(curr1 == curr2) 
				break;
		}
		
		return curr1;
		
	}
	
	
	Node advanceList(Node head, int k) {
		int i = 0;
		while (i < k) {
			head = head.next;
			i++;
		}	
		
		return head;
	}
	
	int getLength(Node head){
		int count = 0;
		Node curr = head;
		
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		
		return count;
	}
	
	
	Node findOverlappingNodeCyclic(Node head1, Node head2) {
		
		Node loopStart1 = getLoopStartIfAny(head1);
		Node loopStart2 = getLoopStartIfAny(head2);
 		
		if (loopStart1 == null && loopStart2 == null) {
			// Both lists not having cycle
			return findOverlappingNode(head1, head2);
		} else if (loopStart1 != null && loopStart2 != null){
			// Both lists have cycle
			Node curr = loopStart1.next;
			while (loopStart1 != curr && loopStart1 != loopStart2) {
				curr = curr.next;
			}
			if (curr.data == loopStart2.data) {
				return loopStart1;
			}
		} 

		// One has cycle and other has no cycle
		return null;
	}
	
	Node getLoopStartIfAny(Node head) {
		Node ptrSlow = head;
		Node ptrFast = head;
		
		while (ptrFast != null && ptrFast.next != null) {
			ptrSlow = ptrSlow.next;
			ptrFast = ptrFast.next.next;
			if (ptrSlow == ptrFast) 
				break;
		}
		
		if (ptrFast == null || ptrFast.next == null) {
			return null;
		}
		
		ptrSlow = head;
		while (ptrSlow != ptrFast) {
			ptrSlow = ptrSlow.next;
			ptrFast = ptrFast.next;
		}
		
		return ptrSlow;
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(5);
		Node n1 = new Node(10);
		Node n2 = new Node(15);
		Node n3 = new Node(20);
		head1.next = n1;
		n1.next = n2;
		n2.next = n3;
		
		
		Node head2 = new Node(3);
		Node n4 = new Node(6);
		head2.next = n4;
		n4.next = n1;
		Utils.printList(head1);
		Utils.printList(head2);
		
		OverlappingList list = new OverlappingList();
		Node result = list.findOverlappingNode(head1, head2);
		System.out.println("Overlapping Node = " + result.data);
	}
}
