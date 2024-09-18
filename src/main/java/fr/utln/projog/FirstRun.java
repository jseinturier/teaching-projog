package fr.utln.projog;

import java.io.File;

import org.projog.api.Projog;
import org.projog.api.QueryResult;
import org.projog.api.QueryStatement;
import org.projog.core.term.Atom;

/**
 * The first work on Prolog using <a href="http://projog.org/">Projog</a> from <a href="https://github.com/s-webber/projog-examples/blob/master/calling-prolog-from-java/src/main/java/com/example/ProjogExample.java">Projog examples directory</a>.
 */
public class FirstRun {
	 public static void main(String[] args) {
	      // Create a new Projog instance.
	      Projog projog = new Projog();

          // Knowledge base facts
	      projog.executeOnce("assert(food(burger)).");	      
	      projog.executeOnce("assert(food(pizza)).");
	      projog.executeOnce("assert(lunch(sandwich)).");
	      projog.executeOnce("assert(dinner(pizza)).");

	      // Knowledge base rules
	      projog.executeQuery("meal(X) :- food(X).");

	      // List all the available food
	      QueryResult r1 = projog.executeQuery("food(X).");
	      while (r1.next()) {
	         System.out.println(r1.getTerm("X").toString());
	      }

	      // List all the available meals
	      QueryResult r2 = projog.executeQuery("meal(X).");
	      while (r2.next()) {
	         System.out.println(r2.getTerm("X").toString());
	      }
	      
	      // Execute a query, set a variable and iterate through all the results.
	      QueryStatement s1 = projog.createStatement("test(X,Y).");
	      s1.setTerm("X", new Atom("d"));
	      QueryResult r3 = s1.executeQuery();
	      while (r3.next()) {
	         System.out.println("Y = " + r3.getTerm("Y"));
	      }	     
	   }
}