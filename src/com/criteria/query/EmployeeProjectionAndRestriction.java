package com.criteria.query;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.criteria.query.EmployeeDTO;

public class EmployeeProjectionAndRestriction {

	public void selectOrderBy(Session session) {
		
		Criteria cri = session.createCriteria(EmployeeDTO.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("firstName"));
		pl.add(Projections.property("companyName"));
		pl.add(Projections.property("city"));
		cri.setProjection(pl);
		cri.addOrder(Order.asc("city"));
		
		List l = cri.list();
		Iterator it = l.iterator();
		while(it.hasNext()) {
			
	    Object[] obj = (Object[])it.next();
	    
	     String name = (String)obj[0];
	     String company = (String)obj[1];
	     String city = (String)obj[2];
	     System.out.println(name+ "\t" +company+ "\t" +city);
		}
	}
	
public void selectLike(Session session) {
		
		Criteria cri = session.createCriteria(EmployeeDTO.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("firstName"));
		pl.add(Projections.property("companyName"));
		pl.add(Projections.property("city"));
		cri.setProjection(pl);
		cri.add(Restrictions.like("companyName","IBM"));
		
		List l = cri.list();
		Iterator it = l.iterator();
		while(it.hasNext()) {
			
	    Object[] obj = (Object[])it.next();
	    
	     String name = (String)obj[0];
	     String company = (String)obj[1];
	     String city = (String)obj[2];
	     System.out.println(name+ "\t" +company+ "\t" +city);
		}
	}
	
public void selectBetween(Session session) {
	
	Criteria cri = session.createCriteria(EmployeeDTO.class);
	ProjectionList pl = Projections.projectionList();
	pl.add(Projections.property("firstName"));
	pl.add(Projections.property("lastName"));
	pl.add(Projections.property("companyName"));
	pl.add(Projections.property("city"));
	pl.add(Projections.property("income"));
	cri.setProjection(pl);
	cri.add(Restrictions.between("income",20000.0,30000.0));
	
	List l = cri.list();
	Iterator it = l.iterator();
	while(it.hasNext()) {
		
    Object[] obj = (Object[])it.next();
    
     String firstname = (String)obj[0];
     String lastname = (String)obj[1];
     String company = (String)obj[2];
     String city = (String)obj[3];
     Double income = (Double)obj[4];
     System.out.println(firstname+ "\t"+lastname+"\t" +company+ "\t" +city+"\t"+income);
	}
}

public void selectOr(Session session) {
	
	Criteria cri = session.createCriteria(EmployeeDTO.class);
	ProjectionList pl = Projections.projectionList();
	pl.add(Projections.property("firstName"));
	pl.add(Projections.property("lastName"));
	pl.add(Projections.property("companyName"));
	pl.add(Projections.property("city"));
	pl.add(Projections.property("income"));
	cri.setProjection(pl);
	cri.add(Restrictions.or(Restrictions.like("companyName","TCS"),Restrictions.eq("city","Bhopal")));
	
	List l = cri.list();
	Iterator it = l.iterator();
	while(it.hasNext()) {
		
    Object[] obj = (Object[])it.next();
    
     String firstname = (String)obj[0];
     String lastname = (String)obj[1];
     String company = (String)obj[2];
     String city = (String)obj[3];
     Double income = (Double)obj[4];
     System.out.println(firstname+ "\t"+lastname+"\t" +company+ "\t" +city+"\t"+income);
	}
}

public void selectIN(Session session) {
	
	Criteria cri = session.createCriteria(EmployeeDTO.class);
	ProjectionList pl = Projections.projectionList();
	pl.add(Projections.property("firstName"));
	pl.add(Projections.property("lastName"));
	pl.add(Projections.property("companyName"));
	pl.add(Projections.property("city"));
	pl.add(Projections.property("income"));
	cri.setProjection(pl);
	cri.add(Restrictions.in("city",new String[] {"Ujjain","Indore"}));
	
	List l = cri.list();
	Iterator it = l.iterator();
	while(it.hasNext()) {
		
    Object[] obj = (Object[])it.next();
    
     String firstname = (String)obj[0];
     String lastname = (String)obj[1];
     String company = (String)obj[2];
     String city = (String)obj[3];
     Double income = (Double)obj[4];
     System.out.println(firstname+ "\t"+lastname+"\t" +company+ "\t" +city+"\t"+income);
	}
}

public void selectFirstRecord(Session session) {
	
	Criteria cri = session.createCriteria(EmployeeDTO.class);
	ProjectionList pl = Projections.projectionList();
	pl.add(Projections.property("firstName"));
	pl.add(Projections.property("lastName"));
	pl.add(Projections.property("companyName"));
	pl.add(Projections.property("city"));
	pl.add(Projections.property("income"));
	cri.setProjection(pl);
	cri.setFirstResult(4);
	
	List l = cri.list();
	Iterator it = l.iterator();
	while(it.hasNext()) {
		
    Object[] obj = (Object[])it.next();
    
     String firstname = (String)obj[0];
     String lastname = (String)obj[1];
     String company = (String)obj[2];
     String city = (String)obj[3];
     Double income = (Double)obj[4];
     System.out.println(firstname+ "\t"+lastname+"\t" +company+ "\t" +city+"\t"+income);
	}
}

public void selectMaxResults(Session session) {
	
	Criteria cri = session.createCriteria(EmployeeDTO.class);
	ProjectionList pl = Projections.projectionList();
	pl.add(Projections.property("firstName"));
	pl.add(Projections.property("lastName"));
	pl.add(Projections.property("companyName"));
	pl.add(Projections.property("city"));
	pl.add(Projections.property("income"));
	cri.setProjection(pl);
	cri.setMaxResults(4);

	
	List l = cri.list();
	Iterator it = l.iterator();
	while(it.hasNext()) {
		
    Object[] obj = (Object[])it.next();
    
     String firstname = (String)obj[0];
     String lastname = (String)obj[1];
     String company = (String)obj[2];
     String city = (String)obj[3];
     Double income = (Double)obj[4];
     System.out.println(firstname+ "\t"+lastname+"\t" +company+ "\t" +city+"\t"+income);
	}
}

public void selectGroupBy(Session session) {
	
	Criteria cri = session.createCriteria(EmployeeDTO.class);
	ProjectionList pl = Projections.projectionList();
	pl.add(Projections.property("firstName"));
	pl.add(Projections.property("lastName"));
	pl.add(Projections.property("companyName"));
	pl.add(Projections.property("city"));
	pl.add(Projections.property("income"));
	pl.add(Projections.groupProperty("city"));
	pl.add(Projections.count("firstname"));
	cri.setProjection(pl);
	cri.setMaxResults(4);
	
	List l = cri.list();
	Iterator it = l.iterator();
	while(it.hasNext()) {
		
    Object[] obj = (Object[])it.next();
    
     String firstname = (String)obj[0];
     String lastname = (String)obj[1];
     String company = (String)obj[2];
     String city = (String)obj[3];
     Double income = (Double)obj[4];
     System.out.println(firstname+ "\t"+lastname+"\t" +company+ "\t" +city+"\t"+income);
	}
}

public void selectEqual(Session session) {
	
	Criteria cri = session.createCriteria(EmployeeDTO.class);
	ProjectionList pl = Projections.projectionList();
	pl.add(Projections.property("id"));
	pl.add(Projections.property("firstName"));
	pl.add(Projections.property("lastName"));
	pl.add(Projections.property("companyName"));
	pl.add(Projections.property("city"));
	pl.add(Projections.property("income"));
	cri.setProjection(pl);
	cri.add(Restrictions.eq("id", 9));
	
	List l = cri.list();
	Iterator it = l.iterator();
	while(it.hasNext()) {
		
    Object[] obj = (Object[])it.next();
     Integer id = (Integer)obj[0];
     String firstname = (String)obj[1];
     String lastname = (String)obj[2];
     String company = (String)obj[3];
     String city = (String)obj[4];
     Double income = (Double)obj[5];
     System.out.println(id+"\t"+firstname+ "\t"+lastname+"\t" +company+ "\t" +city+"\t"+income);
	}
}

public void selectGreaterThen(Session session) {
	
	Criteria cri = session.createCriteria(EmployeeDTO.class);
	ProjectionList pl = Projections.projectionList();
	pl.add(Projections.property("id"));
	pl.add(Projections.property("firstName"));
	pl.add(Projections.property("lastName"));
	pl.add(Projections.property("companyName"));
	pl.add(Projections.property("city"));
	pl.add(Projections.property("income"));
	cri.setProjection(pl);
	cri.add(Restrictions.gt("income", 30000.0));
	
	List l = cri.list();
	Iterator it = l.iterator();
	while(it.hasNext()) {
		
    Object[] obj = (Object[])it.next();
     Integer id = (Integer)obj[0];
     String firstname = (String)obj[1];
     String lastname = (String)obj[2];
     String company = (String)obj[3];
     String city = (String)obj[4];
     Double income = (Double)obj[5];
     System.out.println(id+"\t"+firstname+ "\t"+lastname+"\t" +company+ "\t" +city+"\t"+income);
	}
}

public void rowCountLike(Session session) {
	  
	   Criteria cri = session.createCriteria(EmployeeDTO.class);
	   ProjectionList pl = Projections.projectionList();
	   pl.add(Projections.rowCount());
	   cri.add(Restrictions.like("companyName","Wipro"));
	   cri.setProjection(pl);
	   
	   List l = cri.list();
	   System.out.println("Count : "+l.get(0));
}
	
   public void aggregationlike(Session session) {
	  
	   Criteria cri = session.createCriteria(EmployeeDTO.class);
	   ProjectionList pl = Projections.projectionList();
	  // pl.add(Projections.count("id"));
	  // pl.add(Projections.max("income"));
	   pl.add(Projections.min("income"));
	  // pl.add(Projections.sum("income"));
	   cri.setProjection(pl);
	   cri.add(Restrictions.like("companyName","Wipro"));
	   
	   List l = cri.list();
	   System.out.println("Count : "+l.get(0));
   }
  
   

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		EmployeeProjectionAndRestriction epr = new EmployeeProjectionAndRestriction();

		
		//epr.selectOrderBy(session);
		//epr.selectLike(session);
		//epr.selectBetween(session);
		//epr.selectOr(session);
		//epr.selectIN(session);
		//epr.selectFirstRecord(session);
		//epr.selectMaxResults(session);
		//epr.selectGroupBy(session);
		//epr.selectEqual(session);
		//epr.selectGreaterThen(session);
		//epr.rowCountLike(session);
		//epr.aggregationlike(session);
	   

		session.close();
	}
}
