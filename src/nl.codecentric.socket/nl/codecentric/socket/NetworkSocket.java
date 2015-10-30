package nl.codecentric.socket;

import java.io.Closeable;
import java.util.Iterator;
import java.util.ServiceLoader;

import nl.codecentric.socket.spi.NetworkSocketProvider;
/**
 * Created by ingmarheuzinkveld on 30/10/15.
 */
public abstract class NetworkSocket implements Closeable {
    protected NetworkSocket() {}

    public static NetworkSocket open() {
        ServiceLoader<NetworkSocketProvider> sl = ServiceLoader.load(NetworkSocketProvider.class);

        Iterator<NetworkSocketProvider> iter = sl.iterator();

        if (!iter.hasNext()) {
            throw new RuntimeException("No service providers found");
        }

        NetworkSocketProvider provider = iter.next();
        for (NetworkSocketProvider networkSocketProvider : sl) {
            System.out.println(networkSocketProvider.openNetworkSocket().getClass());
        }
        return provider.openNetworkSocket();
    }

    public abstract String printVersion();
}
