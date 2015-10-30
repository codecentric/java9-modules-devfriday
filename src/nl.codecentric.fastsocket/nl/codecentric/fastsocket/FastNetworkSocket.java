package nl.codecentric.fastsocket;

import nl.codecentric.socket.NetworkSocket;

import java.io.IOException;

/**
 * Created by ingmarheuzinkveld on 30/10/15.
 */
public class FastNetworkSocket extends NetworkSocket {
    @Override
    public void close() throws IOException {

    }

    @Override
    public String printVersion() {
        return "2.0";
    }
}
