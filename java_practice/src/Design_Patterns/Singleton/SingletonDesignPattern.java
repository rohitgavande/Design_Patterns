package Design_Patterns.Singleton;

public class SingletonDesignPattern {
//SIngle ton is used when we want to have only one object of particular class 
// one obj per jvm	
//There are multiple ways to do it given below are all ways
	public static void main(String[] args) {

	}
}

class Singleton {
//	1 -- Eager Initialization when class loading happen one obj gets created 
	private static Singleton obj = new Singleton();

// 	private constructor to avoid obj creation
	private Singleton() {

	}

// 	this method return the only object and kept it static so can be called with class name
	private static Singleton getInstance() {
		return obj;
	}

//Issue is even if we dont want obj it gets created if we have 100 singleton class they will unnecessarily gets created 

}

class Singleton2 {
//	2 -- Lazy initialization
	private static Singleton2 obj;

//	 	private constructor to avoid obj creation
	private Singleton2() {

	}

// 	this method return the only object is created it once called
	private static Singleton2 getInstance() {
		if (obj == null) {
			return new Singleton2();
		}
		return obj;
	}

// 	Issue is what if multiple threads access it parellely t1 & t2 then both will see it null and two obj could get created.
}

class Singleton3 {
//	3 -- Synchronized
	private static Singleton3 obj;

// 	private constructor to avoid obj creation
	private Singleton3() {

	}

//	this method return the only object is created it once called
	private static synchronized Singleton3 getInstance() {
		if (obj == null) {
			return new Singleton3();
		}
		return obj;
	}

//	Issue is if many threads are calling they are waiting in q causing performance issue.	
}

class Singleton4 {
//	4 -- double check lock
	private static volatile Singleton4 obj;

// 	private constructor to avoid obj creation
	private Singleton4() {

	}

//	this method return the only object is created it once called
	private static Singleton4 getInstance() {
		if (obj == null) {
			synchronized (Singleton4.class) {
				if (obj == null) {
					return new Singleton4();
				}
			}
		}
		return obj;
	}
// use volatile to read and write to memory direct instead of cache
}

class Singleton5 {
	// 5 -- bill pugh
//	by using private static class so whenever its called then only it loaded property of nested class.
	private Singleton5() {

	}

	private static class Singleton5Helper {
		private static final  Singleton5 INSTANCE_OBJ = new Singleton5();
		
		public static Singleton5 getInstance() {
			return INSTANCE_OBJ;
		}
	}
}

enum Singleton6{
//	enum solves all prblems as controctors are private , obj of declare ele is bydefault singleton one onj per jvm
	Singleton;
}



