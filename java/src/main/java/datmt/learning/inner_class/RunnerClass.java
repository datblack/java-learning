package datmt.learning.inner_class;

public class RunnerClass {
    static class RunnerOne{// test Talking clock
        public static void main(String[] args) {
//            var talkingClock = new TalkingClock(1000, true);
//            talkingClock.start();
//
//            JOptionPane.showMessageDialog(null, "quit");
//            System.exit(0);
            start();

        }
        // construct inner class:
        public void initializationInnerClass() {
            var timePrinter = new TalkingClock().new TimePrinter();// inner class public
            var timePrinterDef = new TalkingClock().new TimePrinterDef();// inner class default
            var timePrinterPro = new TalkingClock().new TimePrinterPro();// inner class protected
            //var timePrinterPri = new TalkingClock().new TimePrinterPri();// private only can initialization in class contain it

            var timePrinterSt = new TalkingClock.TimePrinterSt();// inner class public
            var timePrinterStDef = new TalkingClock.TimePrinterStDef();// inner class default
            var timePrinterStPro = new TalkingClock.TimePrinterStPro();// inner class protected
            //var timePrinterPri = new TalkingClock.TimePrinterStPri();//  private only can initialization in class contain it
        }

        public static void start (){
            var anonymousClassByInterface = (AnonymousClasss) s -> s+"hello world"; // initialization Anonymous inner class
            var anonymousClassByInterfaceNew = new AnonymousClasss() { // initialization Anonymous inner class
                @Override
                public String print(String s) {
                    return s + " with implement this interface";
                }
            };
            var anonymousClassByClass = new ExampleClass() {// initialization Anonymous inner class
                public void print(String a) {
                    System.out.println(a);
                }
                public void abd(){
                    System.out.println("mehtod trong ");
                }
            };

//          ============================================================================================================

            anonymousClassByClass.abd();
            System.out.println(anonymousClassByClass.age);
            System.out.println(anonymousClassByInterfaceNew.print("initialization"));
            System.out.println(anonymousClassByInterface.print("initialization with lambda"));
        }
    }
}
