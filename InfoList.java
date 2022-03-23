package project;

/**
@author KIBRU KUTURE
 */
public class InfoList {
        private Player head;
        private Player tail;
        private Player prev=null;
        private Player next=null;
	public InfoList() {
		head=tail=null;
	}
	public InfoList(Player head,Player tail) {
		this.head=head;
		this.tail=tail;
	}
	public void add(String NameAndSurname,Date date,String[] club) {
	       Player add=new Player(NameAndSurname,date,club);
	       if(isEmpty())
	    	   head=tail=add;
	       else {
	    	   Player current =head;
	    	   while(current.getNext()!=null) {
	    		   current=current.getNext();
	    	   }
	    	   current.setNext(add);
	    	   add.setPrev(current);
	    	   tail=add;
	       }	
	}
	public void add(Player player ) {
	       if(isEmpty())
	    	   head=tail=player;
	       else {
	    	   Player current =head;
	    	   while(current.getNext()!=null) {
	    		   current=current.getNext();
	    	   }
	    	   current.setNext(player);
	    	   player.setPrev(current);
	    	   tail=player;
	       }	
	}
	public Player remove (Player object) throws Exception {
		if(isEmpty())
			throw new Exception();
		if(head==object) {
			head=head.getNext();
			head.setPrev(null);
			return object;
		}
		else if(tail==object) {
			tail=tail.getPrev();
			tail.setNext(null);
			return object;
		}
		else {
        Player  current=head;
        while(current!=null) {
        	if(current==object) {
        		prev=current.getPrev();
        		next=current.getNext();
        	}
        	current=current.getNext();
        	}
        next.setPrev(null);
        prev.setNext(next);
        next.setPrev(prev);
		return object;  
	}}
	public Player remove (int  position)  throws Exception {
		   if(isEmpty()) {
			   throw new Exception();
		   }
		   if(position==0) {
			   Player current =head;
			   head=head.getNext();
			   head.setPrev(null);
		       return current;}
		   else if(position==size()-1) {
			   Player current=tail;
			   tail=tail.getPrev();
			   tail.setNext(null);
			   return current;
		   }
		   else {
		  Player  current=head;
          for(int d=0;d<=position;d++){
            if(d==position-1){
                 prev=current;}
            else if (d==position){
                 if(current.getNext()!=null)
                   next=current.getNext();
                    //prev.setPrev(null);
                   }
            current=current.getNext();
          }
          next.setPrev(null);
          prev.setNext(next); 
          next.setPrev(prev);
          return current; }
	}
	public Player removeFromFront() throws Exception  {
		if(isEmpty())
			throw new Exception();
		Player temp=head;
		head=head.getNext();
		head.setPrev(null);
		return temp;
	}
	public Player removeFromBack() throws Exception {
		if(isEmpty())
			throw new Exception();
		Player temp=tail;
		tail=tail.getPrev();
		tail.setNext(null);
		return temp;
	}
	public void insertAt(Player player,int position) throws Exception  {
		if(isEmpty()){
                    throw new Exception();
                }
                    
		if(position==0) {
			head.setPrev(player);
			player.setNext(head);
			head=player;
		}
		else if(position==size()-1) {
			Player temp=tail.getPrev();
			temp.setNext(player);
			player.setPrev(temp);
			player.setNext(tail);
			tail.setPrev(player);
		}
		else {
			Player current=head;
                        int count=0;
                        while(count!=position){
                            current=current.getNext();
                            count++;
                        }
                        Player temp=current.getPrev();
                        temp.setNext(player);
                        player.setPrev(temp);
                        player.setNext(current);
                        current.setPrev(player);	
		}
		
	}
	public void addAtFront(Player player) {
		if(isEmpty()) {
			head=tail=player;
		}else
		{
		       head.setPrev(player);
		       player.setNext(head);
		       head=player;}
		
	}
	public void addAtBack(Player player) {
		if(isEmpty()) {
			head=tail=player;
		}else {
		tail.setNext(player);
		player.setPrev(tail);
		tail=player;}
		
	}
	public void sort(InfoList list) throws Exception  {
		if(isEmpty())
			throw new Exception();
                Player UnsortedArray[]=new Player[list.size()];
                Player Array[]=new Player[list.size()];
                Player tempo=list.getHead();
                for(int k=0;k<list.size();k++){
                    Array[k]=tempo;
                    tempo=tempo.getNext();}
                
                for(int k=0;k<list.size();k++){
                    Player carrier=Array[k];
                    Player data=new Player(carrier.getNameAndSurname(),carrier.getBirthDate(),carrier.getClub());
                    UnsortedArray[k]=data;
                }
             
               for(int i=0;i<list.size();i++){
                   
                   for(int j=i+1;j<list.size();j++){
                       if( UnsortedArray[i].getNameAndSurname().compareTo(UnsortedArray[j].getNameAndSurname())>0){
                           Player temp= UnsortedArray[i];
                           UnsortedArray[i]= UnsortedArray[j];
                           UnsortedArray[j]= temp;
                       } 
                     
                   }
               }
               Player SortedArray[]=UnsortedArray;
               head=null;
               tail=null;
               for(Player l:SortedArray){
                   add(l);
               }   
	}
	public void reverse(InfoList list) throws Exception {
   		if(isEmpty())
			throw new Exception();
                Player UnsortedArray[]=new Player[list.size()];
                Player Array[]=new Player[list.size()];
                Player tempo=list.getHead();
                for(int k=0;k<list.size();k++){
                    Array[k]=tempo;
                    tempo=tempo.getNext();}
                
                for(int k=0;k<list.size();k++){
                    Player carrier=Array[k];
                    Player data=new Player(carrier.getNameAndSurname(),carrier.getBirthDate(),carrier.getClub());
                    UnsortedArray[k]=data;
                }
               for(int i=0;i<list.size();i++){
                   
                   for(int j=i+1;j<list.size();j++){
                       if( UnsortedArray[i].getNameAndSurname().compareTo(UnsortedArray[j].getNameAndSurname())<0){
                           Player temp= UnsortedArray[i];
                           UnsortedArray[i]= UnsortedArray[j];
                           UnsortedArray[j]= temp;}}
               }
               Player SortedArray[]=UnsortedArray;
               head=null;
               tail=null;
               for(Player l:SortedArray){
                   add(l);
               }
		
	}
	public boolean isEmpty()
	{
		return head==null;
	}
	public int size () {
		Player current =head;
		int count=0;
		while(current!=null) {
			count++;
			current=current.getNext();
		}
		return  count;
	}
	public Player getHead() {
		return head;
	}
	public Player getTail() {
		return tail;
	}
	public void clear() {
		head=null;
	}}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
