package grpc.greeting;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(grpc.greeting.HelloRequest request,
                      io.grpc.stub.StreamObserver<grpc.greeting.HelloResponse> responseObserver) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getSecondName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
