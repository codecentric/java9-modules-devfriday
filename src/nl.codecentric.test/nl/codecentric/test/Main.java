package nl.codecentric.test;

import nl.codecentric.socket.NetworkSocket;
//import nl.codecentric.helloworld.World;

public class Main {

    public static void main(String[] args) {
//        World.greet();
        NetworkSocket s = NetworkSocket.open();
        System.out.println(s.getClass() + " version: " + s.printVersion());
    }
}
