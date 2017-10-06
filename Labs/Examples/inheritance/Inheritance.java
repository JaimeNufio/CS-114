public class Inheritance{

   public static void main(String[] args) {
      System.out.println("How it works on default constructor:");
      System.out.println("****new Derived()****");
      new Derived();
      
      System.out.println("\nHow it works on defined constructor:");
      System.out.println("**** Base b = new Base(3, 5)****");
      Base b = new Base(3, 5);
      b.foo();
      System.out.println("\n**** Derived d = new Derived(4, 5)****");
      Derived d = new Derived(4, 5);
      d.foo();  
      d.zoo();    
      
      System.out.println("\nHow it works on polymorphism: ");
      System.out.println("**** Base b2 = new Derived(3, 4)****");
      System.out.println("**** with super ****");
      Base b2 = new Derived(3, 4); 	
      b2.foo(); // foo override in Derived
      b2.zoo();   // zoo inherited from Base
      
      System.out.println("\n****Base b3 = new Sibling(4,5)****");
      System.out.println("**** without super ****");
      Base b3 = new Sibling(4,5);
      b3.foo(); // no override in Sibling, inherited from Base
      System.out.println("\nnot working: b3.koo()\t please fix this");
   
      // b3.koo(); // not working
      // hint: koo is only defined in Sibling
      //((Sibling)b3).koo();
   }

}

class Base {
	
   private int i;
   private int j;
	
   public Base(){
      System.out.println("Base -- default");
   }
   
   public Base(int i, int j) { // private constructors do not inherit without super
      System.out.println("Base -- defined");
      this.i = i;
      this.j = j;
   }
	
   public void foo() {
      System.out.println("foo Base");
   }
	
   public void zoo(){
      System.out.println("zoo Base");
   }
}

class Derived extends Base {
   public Derived(){
      System.out.println("Derived -- default");
   }
   
   public Derived(int i, int j) { // calls base first, then executes
      super(i, j);
      System.out.println("Derived -- defined");
   }
   public void foo() { // overrides Base().foo() in favor of its own
      System.out.println("foo Derived");
   }
}

class Sibling extends Base{
   public Sibling(){
      System.out.println("Sibling Default");
   }
   
   public Sibling(int a, int b){
      System.out.println("Sibling Defined");
   }
   
   
   public void koo() { 
      System.out.println("koo Sibling");
   }

}
