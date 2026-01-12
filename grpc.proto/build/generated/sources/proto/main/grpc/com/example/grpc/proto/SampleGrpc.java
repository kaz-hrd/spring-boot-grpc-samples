package com.example.grpc.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SampleGrpc {

  private SampleGrpc() {}

  public static final java.lang.String SERVICE_NAME = "Sample";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.proto.SampleRequest,
      com.example.grpc.proto.SampleReply> getExecuteProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteProcess",
      requestType = com.example.grpc.proto.SampleRequest.class,
      responseType = com.example.grpc.proto.SampleReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.proto.SampleRequest,
      com.example.grpc.proto.SampleReply> getExecuteProcessMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.proto.SampleRequest, com.example.grpc.proto.SampleReply> getExecuteProcessMethod;
    if ((getExecuteProcessMethod = SampleGrpc.getExecuteProcessMethod) == null) {
      synchronized (SampleGrpc.class) {
        if ((getExecuteProcessMethod = SampleGrpc.getExecuteProcessMethod) == null) {
          SampleGrpc.getExecuteProcessMethod = getExecuteProcessMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.proto.SampleRequest, com.example.grpc.proto.SampleReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteProcess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.SampleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.SampleReply.getDefaultInstance()))
              .setSchemaDescriptor(new SampleMethodDescriptorSupplier("ExecuteProcess"))
              .build();
        }
      }
    }
    return getExecuteProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.proto.SleepRequest,
      com.example.grpc.proto.SleepReply> getSleepMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Sleep",
      requestType = com.example.grpc.proto.SleepRequest.class,
      responseType = com.example.grpc.proto.SleepReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.proto.SleepRequest,
      com.example.grpc.proto.SleepReply> getSleepMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.proto.SleepRequest, com.example.grpc.proto.SleepReply> getSleepMethod;
    if ((getSleepMethod = SampleGrpc.getSleepMethod) == null) {
      synchronized (SampleGrpc.class) {
        if ((getSleepMethod = SampleGrpc.getSleepMethod) == null) {
          SampleGrpc.getSleepMethod = getSleepMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.proto.SleepRequest, com.example.grpc.proto.SleepReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Sleep"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.SleepRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.proto.SleepReply.getDefaultInstance()))
              .setSchemaDescriptor(new SampleMethodDescriptorSupplier("Sleep"))
              .build();
        }
      }
    }
    return getSleepMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SampleStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SampleStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SampleStub>() {
        @java.lang.Override
        public SampleStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SampleStub(channel, callOptions);
        }
      };
    return SampleStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SampleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SampleBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SampleBlockingStub>() {
        @java.lang.Override
        public SampleBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SampleBlockingStub(channel, callOptions);
        }
      };
    return SampleBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SampleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SampleFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SampleFutureStub>() {
        @java.lang.Override
        public SampleFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SampleFutureStub(channel, callOptions);
        }
      };
    return SampleFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void executeProcess(com.example.grpc.proto.SampleRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.SampleReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteProcessMethod(), responseObserver);
    }

    /**
     */
    default void sleep(com.example.grpc.proto.SleepRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.SleepReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSleepMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Sample.
   */
  public static abstract class SampleImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SampleGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Sample.
   */
  public static final class SampleStub
      extends io.grpc.stub.AbstractAsyncStub<SampleStub> {
    private SampleStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SampleStub(channel, callOptions);
    }

    /**
     */
    public void executeProcess(com.example.grpc.proto.SampleRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.SampleReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteProcessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sleep(com.example.grpc.proto.SleepRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.proto.SleepReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSleepMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Sample.
   */
  public static final class SampleBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SampleBlockingStub> {
    private SampleBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SampleBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.proto.SampleReply executeProcess(com.example.grpc.proto.SampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteProcessMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.proto.SleepReply sleep(com.example.grpc.proto.SleepRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSleepMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Sample.
   */
  public static final class SampleFutureStub
      extends io.grpc.stub.AbstractFutureStub<SampleFutureStub> {
    private SampleFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SampleFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SampleFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.proto.SampleReply> executeProcess(
        com.example.grpc.proto.SampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteProcessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.proto.SleepReply> sleep(
        com.example.grpc.proto.SleepRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSleepMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXECUTE_PROCESS = 0;
  private static final int METHODID_SLEEP = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE_PROCESS:
          serviceImpl.executeProcess((com.example.grpc.proto.SampleRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.proto.SampleReply>) responseObserver);
          break;
        case METHODID_SLEEP:
          serviceImpl.sleep((com.example.grpc.proto.SleepRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.proto.SleepReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getExecuteProcessMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.proto.SampleRequest,
              com.example.grpc.proto.SampleReply>(
                service, METHODID_EXECUTE_PROCESS)))
        .addMethod(
          getSleepMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.proto.SleepRequest,
              com.example.grpc.proto.SleepReply>(
                service, METHODID_SLEEP)))
        .build();
  }

  private static abstract class SampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SampleBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.proto.SampleProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Sample");
    }
  }

  private static final class SampleFileDescriptorSupplier
      extends SampleBaseDescriptorSupplier {
    SampleFileDescriptorSupplier() {}
  }

  private static final class SampleMethodDescriptorSupplier
      extends SampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SampleMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SampleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SampleFileDescriptorSupplier())
              .addMethod(getExecuteProcessMethod())
              .addMethod(getSleepMethod())
              .build();
        }
      }
    }
    return result;
  }
}
