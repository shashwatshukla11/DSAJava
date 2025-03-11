
public class Linkedlist{ 
    Node head;
    Node tail;
    int length;
    
    class Node{
        int value;
        Node next;
    
        public Node(int value){
            this.value=value;
        }
    }
    // constructor of linked list
    public Linkedlist(int value){
        Node newnode=new Node(value);
        head=newnode;
        tail=newnode;
        length=1;
    }

    // method of print
    public void printll(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    // method of append
    public void append(int value){
        Node newNode=new Node(value);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        length++;

    }

    // method ofremovelast
    public Node removeLast(){
        Node temp=head;
        Node pre=head;
        if(head==null){
            return null;
        }
        while(temp.next!=null){
            pre=temp;
            temp=temp.next;
        }
        pre.next=null;
        tail=pre;
        length--;
        if(length==0){
            head=null;
            tail=null;
        }
return temp;
    }
// method of prepend
    public void prepend(int value){
        Node newnode=new Node(value);
        if(head==null){
            head=newnode;
            tail=newnode;
        }
        else{
            newnode.next=head;
            head=newnode;
        }
        length++;
    }
    // ṃethod of removefirst
    public Node removeFirst(){
     Node temp=head;
     if(head==null){
        return null;
     }
     head=head.next;
     temp.next=null;
     length--;
     if(length==0){
        tail=null;
     }
     return temp;
    }
// method of get
    public Node get(int index){
        if(index<1||index>length){
            return null;
        }
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    // method of set
    public boolean set(int index,int value){
        Node temp=get(index);
        temp.value=value;
        return true;
    }
    // method to insert
    
public boolean insert(int index,int value){
    if(index<0||index>length){
        return false;
    }
 Node newnode=new Node(value);
 Node pre=get(index-1);
 Node temp=pre.next;
 if(index==0){
    prepend(value);
    return true;
 }
 if(index==length){
    append(value);
    return true;
 }
 newnode.next=pre.next;
 pre.next=newnode;
 length++;
 return true;

}

// method to remove from index

public Node remove(int index){
    if(index<0||index>length){
        return null;
    }
    Node pre=get(index-1);
    Node temp=pre.next;
    if(index==0){
        return removeFirst();
    }
    if(index==length-1){
        return removeLast();
    }
    pre.next=temp.next;
    temp.next=null;
    length--;
    if(length==0){
        head=null;
        tail=null;
    }
    return temp;
}

public void reverse(){
    Node temp=head;
    head=tail;
    tail=temp;
    Node pre=null;
    Node after=temp.next;
    for(int i=0;i<length;i++){
        after=temp.next;
        temp.next=pre;
        pre=temp;
        temp=after;
    }

}



//Q1 you have to find the middle node of the linked list?
     //case1:odd number of elements [1->2->3->4->5]
         // output should be->3
     //case2:even number of elements[1->2->3->4->5->6]
             // in even case the output should be second middle node i.e->4

		
             public Node middleNode(){
                Node temp=head;
                Node pre=head;
                while(temp!=null&&temp.next!=null){
                temp=temp.next.next;
                pre=pre.next;
                }
                return pre;
                }
                
                
                
                //Q2 to check whether Linked list contains loop or not?
                        //case1:if contains return true.
                        //case2:if not returns false.
                
                public Boolean hasLoop(){
                Node temp=head;
                Node pre=head;
                while(temp!=null&&temp.next!=null){
                temp=temp.next.next;
                pre=pre.next;
                if(pre==temp){
                return true;
                }
                }
                return false;
                }
    }
    

