//array to linklist
// striver - https://www.youtube.com/watch?v=Nq7ok-OyEpg&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=2

// psudeo code
Node head=new Node(a[0]);
Node move=head;

for(i=0 to a.length){
  Node temp=new Node(a[i]);
  move.next=temp;

  move=temp;
}
return head;
