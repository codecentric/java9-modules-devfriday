package nl.codecentric.test;

import java.lang.module.ModuleDescriptor;
import java.lang.reflect.Layer;
import java.util.Optional;


import nl.codecentric.socket.NetworkSocket;

public class Main {

    public static void main(String[] args) {
        printModules();

        NetworkSocket s = NetworkSocket.open();
        System.out.println("");
        System.out.println(s.getClass() + " version: " + s.printVersion());
    }

    private static void printModules() {
        Layer layer = Layer.boot();
        // Show it in the ui
        layer.modules().stream().filter(m -> m.getName().startsWith("nl.codecentric")).forEach(m -> {
            String name = m.getName();
            Optional<ModuleDescriptor.Version> version = m.getDescriptor().version();
            // Show it in the ui
            System.out.println("Loaded module: " + name + " - version: " + version);
        });
    }
}
