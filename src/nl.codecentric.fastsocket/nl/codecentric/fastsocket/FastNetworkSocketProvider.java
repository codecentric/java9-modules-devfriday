package nl.codecentric.fastsocket;

import nl.codecentric.socket.NetworkSocket;
import nl.codecentric.socket.spi.NetworkSocketProvider;

/**
 * Created by ingmarheuzinkveld on 30/10/15.
 */
public class FastNetworkSocketProvider extends NetworkSocketProvider {
    @Override
    public NetworkSocket openNetworkSocket() {
        return new FastNetworkSocket();
    }
}
