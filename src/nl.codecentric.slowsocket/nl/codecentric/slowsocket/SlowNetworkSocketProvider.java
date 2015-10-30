package nl.codecentric.slowsocket;

import nl.codecentric.socket.NetworkSocket;
import nl.codecentric.socket.spi.NetworkSocketProvider;

/**
 * Created by ingmarheuzinkveld on 30/10/15.
 */
public class SlowNetworkSocketProvider extends NetworkSocketProvider {
    @Override
    public NetworkSocket openNetworkSocket() {
        return new SlowNetworkSocket();
    }
}
