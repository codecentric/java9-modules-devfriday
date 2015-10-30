module nl.codecentric.socket {
        exports nl.codecentric.socket;
        exports nl.codecentric.socket.spi;
        /*
         exports apparently exposes packages to the outside world
         */
//        exports nl.codecentric.helloworld;
        uses nl.codecentric.socket.spi.NetworkSocketProvider;
}
