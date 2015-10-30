module nl.codecentric.slowsocket {
        requires nl.codecentric.socket;
        provides nl.codecentric.socket.spi.NetworkSocketProvider with nl.codecentric.slowsocket.SlowNetworkSocketProvider;
}