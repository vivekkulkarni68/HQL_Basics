
import util.HibernateUtil;
import org.hibernate.*;
import java.util.*;

public class TestHQL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	PersistentClass object1 = new PersistentClass();
	 //      object1.setSomething("Objhect1");
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx  = session.beginTransaction();
        session.save(object1);
        tx.commit();
      
        session.close(); */
		//createPersons();
		//Test_One_to_Many.createItems();
		SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx  = session.beginTransaction();
      /*  /********************START select all tables from DB***********
        List list = session.createQuery("from java.lang.Object").list();
        System.out.println("The query fetched"+list.size()+ " rows");
        for(int i=0; i <list.size();i++){
        	System.out.println("DEBUG : Output is "+list.get(i));
        }
        *********************END******************
      //  *******************START: Where clause ***********
        List list = session.createQuery("from Person p where  p.shippingAddress.city like'P%'").list();
        System.out.println("The query fetched"+list.size()+ " rows");
        for(int i=0; i <list.size();i++){
        	System.out.println("DEBUG : Output is "+list.get(i));
        }
        //*********************END*****************
       //*****************START expressions with collections ********* 
        List list = session.createQuery("from Item it where  it.bids is not empty").list();
        System.out.println("The query fetched"+list.size()+ " rows");
        for(int i=0; i <list.size();i++){
        	System.out.println("DEBUG : Output is "+list.get(i));
        }
//      *******************END   expressions with collections *********
        //*****************START MEMBER OF expression with collections ********* 
        List list = session.createQuery("select it.description,b.amount from Item it, Bid b where  it.id=1 and b.item member of it").list();
        System.out.println("The query fetched"+list.size()+ " rows");
        for(int i=0; i <list.size();i++){
        	System.out.println("DEBUG : Output is "+list.get(i));
        }
        
//      *******************END   expressions with collections 
 * ********
        // *******START Ordering Query results *************
        List list = session.createQuery("from Person p order by p.firstName asc, p.lastName desc").list();
        System.out.println("The query fetched"+list.size()+ " rows");
        for(int i=0; i <list.size();i++){
        	System.out.println("DEBUG : Output is "+list.get(i));
        }
        //********END Ordering Query results ***************/
        //*******START PROJECTIONS*******
      /*  List list = session.createQuery("from Item i, Bid b").list();
        System.out.println("The query fetched"+list.size()+ " rows");
        Iterator it = list.iterator();
        while(it.hasNext()){
        	Object[] item_bids = (Object[])it.next();
        	System.out.println("DEBUG : Item Output is "+item_bids[0]);
        	System.out.println("DEBUG : Bid Output is "+item_bids[1]);
        }
        //*******END PROJECTIONS********  */
        /*//***** START Parameter BindingJDBC way*********
               Query query = session.createQuery("from Item i where i.description= :search");
               printItems("Dell Inspiron",query); //Passing Search String
               printItems("IBM Think Pad",query);
               
        //******END Parameter Binding***********
      //********START Parameter Binding  Hibernate special using setParameter() method************
               //Address theAddress = (Address)session.get(Address.class, new Long(16));
               String lastName = "DeshPande";
               Address theAddress = new Address("kalpana","411004","Nagpur");
               theAddress.setId(new Long(20));
               Query query = session.createQuery("from Person p where p.shippingAddress=:home and lastName=:lastname")
                                    .setParameter("home", theAddress,Hibernate.entity(Address.class))
                                    .setParameter("lastname",lastName,Hibernate.STRING);
               List list = query.list();
               for(int i=0;i<list.size();i++){
            	   Person p = (Person)list.get(i);
            	   System.out.println("DEBUG :Person's firstName= "+p.getFirstName());
               }
        //********START Parameter Binding  Hibernate spacial ************
/*       
//      ********START Parameter Binding  Using setProperties method ************
        
        //Address theAddress = (Address)session.get(Address.class, new Long(16));
        Address theAddress = new Address("kalpana","411004","Nagpur");
        theAddress.setId(new Long(16));
        PersonBean person = new PersonBean();
        person.setShippingAddress(theAddress);
        System.out.println("*******DEBUG : Creating Query********");
        Query query = session.createQuery("from Person p where p.shippingAddress=:shippingAddress");
        query.setProperties(person);
       
        List list = query.list();
        for(int i=0;i<list.size();i++){
     	   Person p = (Person)list.get(i);
     	   System.out.println("DEBUG :Person's firstName= "+p.getFirstName());
        }
 //********END Parameter Binding  Hibernate spacial ************
//**************START ScrollableResultSet *********************************************
             // createPersons(100);
              Query query = session.createQuery("from Person");
              ScrollableResults cursor = query.scroll(ScrollMode.FORWARD_ONLY);
              cursor.next(); //gets the last row of DB table
              System.out.println("DEBUG : no of columns"+cursor.get(0));
              cursor.previous(); //gets the previous row of DB table//Throws exception due to ScrollMode
              System.out.println("DEBUG : no of columns "+cursor.get(0));
              cursor.first(); //gets the first row of DB table
              System.out.println("DEBUG : no of columns"+cursor.get(0));
              cursor.scroll(30);
              System.out.println("DEBUG : After scrolling by 30 "+cursor.get(0));
              cursor.setRowNumber(80);
              
              System.out.println("DEBUG : After setting row number 80 "+cursor.get(0));
              cursor.setRowNumber(-3);
              System.out.println("DEBUG : After scrolling by -3 "+cursor.get(0));
              //System.out.println("DEBUG : Output "+cursor.first()+cursor.get()[0]+cursor.get()[1]+cursor.get()[2]+cursor.get()[3]);
              /*while(cursor.next()){
            	  Object[] row = cursor.get();
            	  for(int i=0; i< row.length; i++){
            	     System.out.println("DEBUG : Output "+row[i]);
                  }
              }*/
              
//**************END ScrollableResultSet *********************************************/
//*******************START Named Query  **********************************
             /*Query query = session.getNamedQuery("getAllPersons");
             ScrollableResults cursor = query.scroll();
             cursor.first(); //gets the first row of DB table
             System.out.println("DEBUG : no of columns "+cursor.get(0));*/
//*******************END Named Query  ********************************** 
//*******************START Pagination Query  **********************************
            /* Query query = session.createQuery("from Person p order by p.firstName asc");
             query.setMaxResults(10);
             query.setFirstResult(400);
             List list = query.list();
             for(int i=0;i<list.size();i++){
           	   Person p = (Person)list.get(i);
           	   System.out.println("DEBUG :Person \n "+p);
              }*/
             
            
//*******************END Named Query  **********************************
        //******START Reporting Query ********************
        /*Test_One_to_Many.createItems(50,12);
        Test_One_to_Many.createItems(10,5);
        Query query = session.createQuery("select item.id, count(bid), avg(bid.amount) from " +
        		//"Item item join item.bids bid  group by item.id " +
        		"Item item join item.bids bid  where item.successfulBid is null group by item.id " +
        		"having count(bid) < 10 "  );
        List list = query.list();
        for(int i=0; i<list.size(); i++){
        	Object[] result = (Object[])list.get(i);
        	System.out.println("DEBUG : Item Id     = "+result[0]);
        	System.out.println("DEBUG : Count       = "+result[1]);
        	System.out.println("DEBUG : Average Amt = "+result[2]);
        } 	*/
             		                    
        //******END Reporting Query ********************
        //*************START Dynamic Fetching with join fetch clause******
        Query query = session.createQuery("select i from Item i join i.bids b where b.amount >= 10000");
        query.setMaxResults(2);
        Iterator items = query.list().iterator();
        while(items.hasNext()){
        	Item item = (Item)items.next();
        	System.out.println("DEBUG : Item found ="+item);
        	//following line would generate query on Bid Table because item.getSuccessfulBid() method 
        	//needs Bid to be instantiated and intialized. This is called "on-demand" or "lazy-fetch"
        	//lazy fetch is a default behaviour
        // keep following commented and change mapping using lazy="false" and see if Bid table is queried
        	//System.out.println("DEBUG : Bid amount ="+item.getSuccessfulBid().getAmount());
        }
        	
        //**************END  Dynamic Fetching with join fetch clause******
        
      tx.commit();
	}
    public static void createPersons(int no){
    	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
    	for(int i=0;i<no;i++){
    	Address home = new Address("IT Lane"+i, "411004", "Pune"+i);
	    Address home2 = new Address("Kalpana"+i, "411004", "Nagpur"+i);
		Person vivek  = new Person("Vivek"+i, "Kulkarni"+i);
		Person veena  = new Person("Veena"+i, "Deshpande"+i);
		//vivek.setHomeAddress(home);
		vivek.setShippingAddress(home);
		//veena.setHomeAddress(home);
		veena.setShippingAddress(home2);
		try{
	        session.save(vivek);
	        session.save(veena);
		}catch(Throwable ex){
			ex.printStackTrace();
		}
    	}//end for
       tx.commit();
	   session.close();
    }
    public static void printItems(String searchString, Query query){
    	query.setString("search", searchString);
    
    	List list = query.list();
        for(int i=0; i <list.size();i++){
        	System.out.println("DEBUG : Output is "+list.get(i));
        }

    }
}
