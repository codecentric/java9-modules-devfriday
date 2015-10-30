module nl.codecentric.fastsocket {
        requires nl.codecentric.socket;
        provides nl.codecentric.socket.spi.NetworkSocketProvider with nl.codecentric.fastsocket.FastNetworkSocketProvider;
}