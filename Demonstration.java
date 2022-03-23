package project;

/**
  @author KIBRU KUTURE
 */

import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Demonstration extends JFrame implements ActionListener{
    private final int WIDTH=450;
    private final int HEIGHT=450;
    JTextArea area;
    static InfoList list=null;
    JButton button1,button2,button3;
    JLabel sorted,reversed;
    JTextField removefield;
    JButton remover;
    JButton inserter;JLabel name,date,club,pos,po,dat,nam,clu;
    JTextField datefield,namefield,posfield;JTextArea clubfield;
    JButton adder;JTextField datfield,namfield,pofield;JTextArea clufield;JButton recover;
    private int no;
    private Player newPlayer;
     InfoList newInfo;
    public Demonstration(){
            setSize(WIDTH,HEIGHT);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);
            JPanel sortarea=new JPanel();
            button1=new JButton("Sort the players");
            button1.addActionListener(this);
            button2=new JButton("Reverse the order");
            button2.addActionListener(this);
            button1.setBackground(Color.decode("#DAA520"));
            button2.setBackground(Color.decode("#DAA520"));
            sortarea.setLayout(new FlowLayout());
            sortarea.add(button1);
            sortarea.add(button2);
            sortarea.setBackground(Color.DARK_GRAY);
            sortarea.setBounds(10, 600, 300, 50);
            add(sortarea);
            getContentPane().setBackground(Color.decode("#808000"));
            JLabel label=new JLabel();
            label.setText("NOTE:The player's name, surname, birth_date, and the club(s) s/he played____info table");
            label.setBounds(800,20,550,20);
            label.setBackground(Color.gray);
            add(label);
            area=new JTextArea();
            area.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, SOMEBITS, rootPaneCheckingEnabled));
            area.setLineWrap(true);
            area.setEditable(false);
            area.setBackground(Color.LIGHT_GRAY);
            add(area);
            JScrollPane scroll=new  JScrollPane(area);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroll.setPreferredSize(new Dimension(550,800));
            scroll.setBounds(800,50,550, 550);
            add(scroll);
            JLabel removeNote =new JLabel("1. Remove a player by his/her position  |  Note: write a number>0");
            removeNote.setBounds(10, 10, 450, 20);
            add(removeNote);
            removefield=new JTextField();
            removefield.setSize(30, 30);
            removefield.setBounds(10, 30, 150, 30);
            removefield.setColumns(10);
           // removefield.addMouseListener(new MouseListener());
            removefield.setBackground(Color.white);
            add(removefield);
            remover =new JButton("Remove a Player");
            remover.setBounds(10, 70, 150, 25);
            remover.setBackground(Color.decode("#DAA520"));
            remover.addActionListener(this);
            add(remover);
            JTextArea note=new JTextArea();
            note.setBounds(800, 650, 550, 50);
            Font font=new Font("Verdana",Font.BOLD,15);
            note.setFont(font);
            note.setText("A quick note:".toUpperCase()+"\n"+"Fill up  some of the data to where it is required!!");
            note.setEditable(false);
            note.setBackground(Color.pink);
            note.setLineWrap(true);
            add(note);
            JLabel inserttext=new JLabel();
            inserttext.setText("2. Put a player into the list of players  |  Note:  give the following info accordingly");
            inserttext.setBounds(10, 100, 470, 20);
            add(inserttext);
            name=new JLabel("Name_Surname");
            date=new JLabel("Birthdate:dd/mm/yyyy");
            club=new JLabel("Write clubs,comma needed");
            pos=new JLabel("Write a position(number>0)");
            name.setBounds(10,120,150,20);
            namefield=new JTextField();
            namefield.setBounds(10,140,150,30);
            date.setBounds(170,120,130,20);
            datefield=new JTextField();
            datefield.setBounds(170,140,130,30);
            club.setBounds(320,120,180,20);
            clubfield=new JTextArea();
            clubfield.setBounds(320,140,200,100);
            clubfield.setLineWrap(true);
            pos.setBounds(560, 120, 180, 25);
            posfield=new JTextField();
            posfield.setBounds(560, 140, 150, 25);
            add(pos);
            add(posfield);
            add(name);
            add(date);
            add(club);
            add(namefield);
            add(datefield);
            add(clubfield);
            inserter =new JButton("Insert a Player");
            inserter.addActionListener(this);
            inserter.setBounds(10, 170, 150, 25);
            inserter.setBackground(Color.decode("#DAA520"));
            add(inserter);
            //-----------------------------------------------
            JLabel addtext=new JLabel();
            addtext.setText("3. Add a a player into the list of players  |  Note: give the following info accordingly");
            addtext.setBounds(10, 260, 480, 20);
            add(addtext);
            
            nam=new JLabel("Name_Surname");
            dat=new JLabel("Birthdate:dd/mm/yyyy");
            clu=new JLabel("Write clubs,comma needed");
            
            nam.setBounds(10,280,150,20);
            namfield=new JTextField();
            namfield.setBounds(10,320,150,30);
            dat.setBounds(170,280,130,20);
            datfield=new JTextField();
            datfield.setBounds(170,320,130,30);
            clu.setBounds(320,280,180,20);
            clufield=new JTextArea();
            clufield.setBounds(320,320,200,100);
            clufield.setLineWrap(true);
            add(nam);
            add(dat);
            add(clu);
            add(namfield);
            add(datfield);
            add(clufield);
            adder =new JButton("Add a Player");
            adder.addActionListener(this);
            adder.setBounds(10, 350, 150, 25);
            adder.setBackground(Color.decode("#DAA520"));
            add(adder);
            JLabel del=new JLabel("If you want to erase the info table,click delete button");
            JButton deleter=new JButton("Delete");
            del.setBounds(10, 450, 400, 20);
            deleter.setBounds(80, 480, 150, 25);
            deleter.addActionListener(this);
            deleter.setBackground(Color.decode("#DAA520"));
            add(del);
            add(deleter);
            sorted=new JLabel("");
            reversed=new JLabel("");
            sorted.setBounds(350, 480, 450, 20);
            add(sorted);
            reversed.setBounds(350, 540, 450, 20);
            add(reversed);
            recover=new JButton("Recover Data");
            recover.addActionListener(this);
            //sortarea.setBounds(10, 600, 300, 50);
            recover.setBounds(340,600,180,50);
            recover.setBackground(Color.decode("#DAA520"));
            add(recover);
            
            
            
            
        
        
         }
    public boolean isDigit(String str){
        char [] arr=str.toCharArray();
        boolean truth=false;
        for(char c:arr){
            if(Character.isDigit(c)){
                truth=true;
            }
            else{ 
                truth=false;}
        }
        return truth;
    }
            @Override
   public void actionPerformed(ActionEvent e){
                 if(e.getActionCommand().equalsIgnoreCase("Delete")){
                    Font font=new Font("Verdana",Font.BOLD,42);
                    area.setFont(font);
                     area.setText("You have successfully deleted the content"+"\n"+ "):congratulation!!");
                    
                     area.setBackground(Color.LIGHT_GRAY);
                     sorted.setText(null);
                     reversed.setText(null);
                     
                 }
                 else if(e.getSource()==button1){
                     try{
                     list.sort(list);}catch(Exception ee){}
                     Player current=list.getHead();
                     String all=" ";
                     int count=1;
                     while(current!=null){
                         all+=count+". "+current.toString();
                         current=current.getNext();
                         count++;
                     }
                     Font font=new Font("Verdana",Font.BOLD,12);
                     area.setFont(font);
                     area.setBackground(Color.decode("#DAA520"));
                     area.setText(all);
                     reversed.setText(null);
                     if(list.getHead()!=null){
                     Font fon=new Font("Verdana",Font.BOLD,14);
                     sorted.setText("The players' names have been sorted alphabetically");
                     sorted.setFont(fon);}else{
                         Font fon=new Font("Verdana",Font.BOLD,14);
                         sorted.setText(null);
                         sorted.setText("The Players data is  empty now!! Add some players");
                         sorted.setFont(fon);
                     }
                     
                 }
                 else if(e.getSource()==button2){
                      
                              try{
                     list.reverse(list);}catch(Exception ee){}
                     Player current=list.getHead();
                     String all="";
                       int count=1;
                     while(current!=null){
                         all+=count+". "+current.toString();
                         current=current.getNext();
                         count++;
                     }
                     Font font=new Font("Verdana",Font.BOLD,13);
                     area.setFont(font);
                     area.setBackground(Color.decode("#DAA520"));
                     area.setText(all);
                     sorted.setText(null);
                     if(list.getHead()!=null){
                     Font fon=new Font("Verdana",Font.BOLD,14);
                     reversed.setText("The players' names have been reversed ");
                     reversed.setFont(fon);}else{
                     Font fon=new Font("Verdana",Font.BOLD,14);
                     sorted.setText(null);   
                     reversed.setText("The players  data is empty now.Add some players");
                     reversed.setFont(font);
                     }
                 }
                 else if(e.getSource()==remover){
                     String num=removefield.getText();
                     if(this.isDigit(num)){
                     no=Integer.parseInt(num.trim());
                     try{list.remove(no); 
                     }catch(Exception r){}
                       try{outPut(list);}catch(IOException rr){}
                      sorted.setText(null);
                      reversed.setText(null);
                      if(no>list.size()||list.getHead()==null){
                      Font font=new Font("Verdana",Font.BOLD,38);
                      area.setFont(font);
                      area.setText("Oops!! You have entered \na number out of the range or  the list of players is empty now");
                      }
                      else{
                       Player current=list.getHead();
                       String all=" ";
                         int count=1;
                     while(current!=null){
                         all+=count+". "+current.toString();
                         current=current.getNext();
                         count++;
                     }
                     Font font=new Font("Verdana",Font.BOLD,13);
                     area.setFont(font);
                     area.setBackground(Color.decode("#DAA520"));
                     area.setText(all);
                     sorted.setText(null);
                     Font fon=new Font("Verdana",Font.BOLD,14);
                     reversed.setText("The players' name(s) has/have been removed ");
                     reversed.setFont(fon);}
                      
                      
                 }
                     else {
                       
                          Font font=new Font("Verdana",Font.BOLD,36);
                          area.setFont(font);
                          area.setText("You have not entered a position number yet!! or have entered a set of characters!! Please enter a position number and check it!!");
                      
                 }
                 }
                 else if(e.getSource()==inserter){
                     if(datefield.getText()!=null &&namefield.getText()!=null && posfield.getText()!=null && clubfield.getText()!=null){
                        try{
                         String nm=namefield.getText();// nm refers to the name and surname of a player !!
                         String datetext=datefield.getText();
                         String index =posfield.getText();
                         int inde=Integer.parseInt(index.trim());
                         String  str[]=datetext.split("/");
                         int d=Integer.parseInt(str[0].trim());
                         int m=Integer.parseInt(str[1].trim());
                         int y=Integer.parseInt(str[2]);
                         Date datec=new Date(d,m,y);
                         String team[]=clubfield.getText().split(",");
                         newPlayer=new Player(nm,datec,team);
                        
                          list.insertAt(newPlayer,inde);
                          Player current=list.getHead();
                          String all="";
                      int count=1;
                     while(current!=null){
                         all+=count+". "+current.toString();
                         current=current.getNext();
                         count++;
                     }
                     Font font=new Font("Verdana",Font.BOLD,13);
                     area.setFont(font);
                     area.setBackground(Color.decode("#DAA520"));
                     area.setText(all);
                     try{outPut(list);}catch(IOException rr){}
                     Font ont=new Font("Verdana",Font.BOLD,14);
                     sorted.setText("You have positioned the player at: "+inde);
                     sorted.setFont(ont);
                     reversed.setText(null);
                         }catch(Exception exc){
                             Font nt=new Font("Verdana",Font.BOLD,36);
                             area.setText("The data you have provided into are  not correct!! Please take a look at  the position you want to put a player at!! recheck the data");
                             area.setFont(nt);
                                     
                         }
                         }else {
                         Font nt=new Font("Verdana",Font.BOLD,36);
                         area.setText("You have not provided any data yet!! ");
                         area.setFont(nt);
                     }
                 }
                 else if(e.getSource()==adder){
                   if(datefield.getText()!=null &&namefield.getText()!=null && posfield.getText()!=null && clubfield.getText()!=null){
                        try{
                         String nm=namfield.getText();// nm refers to the name and surname of a player !!
                         String datetext=datfield.getText();
                         String  str[]=datetext.split("/");
                         int d=Integer.parseInt(str[0].trim());
                         int m=Integer.parseInt(str[1].trim());
                         int y=Integer.parseInt(str[2]);
                         Date datec=new Date(d,m,y);
                         String team[]=clufield.getText().split(",");
                         Player newPlayer=new Player(nm,datec,team);
                        
                          list.add(newPlayer);
                          Player current=list.getHead();
                          String all="";
                          int count=1;
                     while(current!=null){
                         all+=count+". "+current.toString();
                         current=current.getNext();
                         count++;
                     }
                     Font font=new Font("Verdana",Font.BOLD,13);
                     area.setFont(font);
                     area.setBackground(Color.decode("#DAA520"));
                     area.setText(all);
                     try{outPut(list);}catch(IOException rr){}
                     Font ont=new Font("Verdana",Font.BOLD,14);
                     sorted.setText("You have added the player into the list.");
                     sorted.setFont(ont);
                     reversed.setText(null);
                         }catch(Exception exc){
                             Font nt=new Font("Verdana",Font.BOLD,36);
                             area.setText("The data you have provided into are  not correct!! Please take a look at  the position you want to put a player at!! recheck the data");
                             area.setFont(nt);
                                     
                         }
                         }else {
                         Font nt=new Font("Verdana",Font.BOLD,36);
                         area.setText("You have not provided any data yet!! ");
                         area.setFont(nt);
                     }
                     
                     
                 }
                else if(e.getSource()==recover){
                      if(newInfo.getHead()!=null){
                       Player current=newInfo.getHead();
                       String all=" ";
                         int count=1;
                     while(current!=null){
                         all+=count+". "+current.toString();
                         current=current.getNext();
                         count++;
                     }   
                     
                     Font font=new Font("Verdana",Font.BOLD,13);
                     area.setFont(font);
                     area.setBackground(Color.LIGHT_GRAY);
                     area.setText(all);
                     sorted.setText(null);
                     Font fon=new Font("Verdana",Font.BOLD,14);
                     reversed.setText("The players' data has been recovered");
                     reversed.setFont(fon);
                     //list=newInfo;
                 } }else{
                    ///
                }   
        }
  public void recover(InfoList list){
                         Player temp=list.getHead();
                   Player[] arr=new Player[list.size()];
                  
                  int count=0;
                   while(temp!=null){
                       arr[count]=temp;
                       temp=temp.getNext();
                       count++;
                   }
                   Player nArray[] =new Player[list.size()];
                    for(int k=0;k<list.size();k++){
                      
                           Player carrier=arr[k];
                           Player data=new Player(carrier.getNameAndSurname(),carrier.getBirthDate(),carrier.getClub());
                           nArray[k]=data;
                }
                   Player SortedArray[]=nArray;
                   Player head=null;
                   Player tail=null;
                   newInfo=new InfoList();
               for(Player l:SortedArray){
                    newInfo.add(l);
               } 
      
  }
     public static  void outPut(InfoList list)  throws IOException 
    { 
        FileWriter fileWriter = new FileWriter("to.txt");
        Player current=list.getHead();
        while(current!=null){
            String pdata="";
            String pname=current.getNameAndSurname();// as clear as it looks ,pname is players name;
            Date pd=current.getBirthDate();
            String pds=pd.getDay()+"/"+pd.getMonth()+"/"+pd.getYear();//pds refers to playars date in the string format with delimiter slash//
            String[] cd=current.getClub();
            String datac=",";//datac stands for data of club in the string form 
            for(String clubd:cd){
                datac+=clubd+",";
            }
            datac=datac.replaceAll(",$", "");
            pdata=pname+", "+pds+datac+"\n";
            fileWriter.write(pdata);
            current=current.getNext();
        }
       fileWriter.close();
     }
	public static void main(String [] args) {
		InfoList l=new InfoList();
               Scanner scanner =null;
               try{scanner=new Scanner (new FileInputStream("players.txt"));}catch(FileNotFoundException e){}
               while(scanner.hasNextLine()){
                   String line=scanner.nextLine();
                   String[] str=line.split(",");
                   String name=null;
                   Date date=null;
                   String[] club=new String[str.length-2];
                   int index=0;
                   for(int k=0;k<str.length;k++){
                       if(k==0){
                           name=str[k];
                       }
                       else if(k==1){
                           String[] d=str[k].split("/");
                           int day=Integer.parseInt(d[0].trim());
                           int month=Integer.parseInt(d[1].trim());
                           int year=Integer.parseInt(d[2].trim());
                           date=new Date(day,month,year);
                       }
                       else{
                           club[index]=str[k];
                           index++;
                           
                       }
                   }
                   
                   Player addPlayer=new Player(name,date,club);
                   l.add(addPlayer);
               }
               try{
                   l.sort(l);
               }catch(Exception e){}
               Player k=l.getHead();
               System.out.println("##################################################################################");
               System.out.println("Employing the InfoList class, and making an object from it we can develop the following items:\n WE CAN:");
               System.out.println("Add at any position\n remove from any position\nadd at front,add at back\n remove from front,remove from back\n sort the players list,reverse their order\n and many more!!");
               System.out.println("Instance is done for the sort item,sorting the players according to their names alphabetically!!");
               System.out.println("##################################################################################\n");
               System.out.println("The sorted players data is as below!!".toUpperCase());
               while(k!=null){
                   System.out.println("Name and Surname:"+k.getNameAndSurname());
                   System.out.println("Birth date:"+k.getBirthDate().toString());
                   System.out.println("The club(s) he/she played is(are) as folow:");
                   for(String st:k.getClub()){
                       System.out.println(st);
                   }
                   System.out.println();
                   k=k.getNext();
               }  
	Demonstration demo=new Demonstration();
        demo.list=l;
        demo.recover(l);
        demo.setTitle("Algorithm and Programming II,Project II");
        demo.setVisible(true);
         try{
             outPut(list);
         }catch(IOException rr){}
        Scanner r=null;
        try{
            r=new Scanner(new FileInputStream("to.txt"));
        }catch(Exception we){}
            System.out.println("##################################################################################");
            System.out.println("The players data is being written into the memory !!");
            System.out.println("Writing the players data is dynamic!! when data is added (/or removed) into(from) the GUI ,at\n"
                    + "the same  time the data removed /added will be seen on the text \n"
                    + " To see that you can open the text(to.txt) from the file");
            System.out.println("##################################################################################\n\n");
           while(r.hasNextLine()){
               System.out.println(r.nextLine());
           }      
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
           
                 
	}

}

