// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HelloService.proto

package grpc.greeting;

public final class HelloServiceOuterClass {
  private HelloServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_greeting_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_greeting_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_grpc_greeting_HelloResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_grpc_greeting_HelloResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\022HelloService.proto\022\rgrpc.greeting\"5\n\014H" +
      "elloRequest\022\021\n\tfirstName\030\001 \001(\t\022\022\n\nsecond" +
      "Name\030\002 \001(\t\"!\n\rHelloResponse\022\020\n\010greeting\030" +
      "\001 \001(\t2R\n\014HelloService\022B\n\005hello\022\033.grpc.gr" +
      "eeting.HelloRequest\032\034.grpc.greeting.Hell" +
      "oResponseB\002P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_grpc_greeting_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_grpc_greeting_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_greeting_HelloRequest_descriptor,
        new String[] { "FirstName", "SecondName", });
    internal_static_grpc_greeting_HelloResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_grpc_greeting_HelloResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_grpc_greeting_HelloResponse_descriptor,
        new String[] { "Greeting", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
