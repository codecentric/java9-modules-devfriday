package nl.codecentric.socket.spi;

import nl.codecentric.socket.NetworkSocket;

/**
 * Created by ingmarheuzinkveld on 30/10/15.
 */
public abstract class NetworkSocketProvider {
    protected NetworkSocketProvider() {}


    public abstract NetworkSocket openNetworkSocket();
}
