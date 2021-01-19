import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        int[][] value, value2, value3, value4;
        int[] inputArray = new int[]{1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        for (int i = 0; i < inputArray.length; i++) {
            value = Main.GenerateInput(inputArray[i]);
            try {
                // lookup method to find reference of remote object
                FloodFill node = (FloodFill) Naming.lookup("rmi://localhost:1900" + "/flood");
                value = node.run(value);
                System.out.println("Work " + inputArray[i] + " is Done using 1 node !");
            } catch (Exception ae) {
                System.out.println(ae);
            }
        }

        for (int i = 0; i < inputArray.length; i = i + 2) {
            value = Main.GenerateInput(inputArray[i]);
            value2 = Main.GenerateInput(inputArray[i+1]);
            try {
                // lookup method to find reference of remote object
                FloodFill node1 = (FloodFill) Naming.lookup("rmi://localhost:1900" + "/flood");
                FloodFill node2 = (FloodFill) Naming.lookup("rmi://localhost:1900" + "/flood");
                value = node1.run(value);
                value2 = node2.run(value2);
                System.out.println("Work " + inputArray[i] + " is Done using 2 nodes !");
                System.out.println("Work " + inputArray[i+1] + " is Done using 2 nodes !");
            } catch (Exception ae) {
                System.out.println(ae);
            }
        }

        for (int i = 0; i < inputArray.length + 2; i = i + 4) {
            value = Main.GenerateInput(inputArray[i]);
            value2 = Main.GenerateInput(inputArray[i+1]);
            // Prevent index out of bounds
            if(i+2 == inputArray.length){
                value3 = null;
                value4 = null;
            }
            else {
                value3 = Main.GenerateInput(inputArray[i + 2]);
                value4 = Main.GenerateInput(inputArray[i + 3]);
            }

            try {
                // lookup method to find reference of remote object
                FloodFill node1 = (FloodFill) Naming.lookup("rmi://localhost:1900" + "/flood");
                FloodFill node2 = (FloodFill) Naming.lookup("rmi://localhost:1900" + "/flood");
                FloodFill node3 = (FloodFill) Naming.lookup("rmi://localhost:1900" + "/flood");
                FloodFill node4 = (FloodFill) Naming.lookup("rmi://localhost:1900" + "/flood");

                value = node1.run(value);
                value2 = node2.run(value2);
                // Prevent index out of bounds
                if(value3 != null && value4 != null){
                    value3 = node3.run(value3);
                    value4 = node4.run(value4);
                }
                System.out.println("Work " + inputArray[i] + " is Done using 4 nodes !");
                System.out.println("Work " + inputArray[i+1] + " is Done using 4 nodes !");
                // Prevent index out of bounds
                if(value3 != null && value4 != null){
                    System.out.println("Work " + inputArray[i+2] + " is Done using 4 nodes !");
                    System.out.println("Work " + inputArray[i+3] + " is Done using 4 nodes !");
                }


            } catch (Exception ae) {
                System.out.println(ae);
            }
        }


    }


} 