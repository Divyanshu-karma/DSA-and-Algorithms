//  binary serach tree 

// link  https://www.youtube.com/watch?v=4s1Tcvm00pA&list=PL9gnSGHSqcnqfctdbCQKaw5oZ9Up2cmsq
// video - at time 2 hour 7 minutes see for insertion 

// insertion
Node insert(Node t, int val){
if(t==null) {
    t=new Node(val);
    return t;
}
if(t.data>val){
    t.left= insert(t.left,val);
}
if(t.data<val){
    t.right= insert(t.right,val);
}
 return t;
}
