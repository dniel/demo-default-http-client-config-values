# Http Client configuration default values and inheritance

## Description
I have created a simple application to demonstrate the default values of the Http Client configuration.
There is one http client defined in the application, called `HttpBinClient`. 
See the `application.yml` file for the configuration.

The global http client is configured with max-concurrent-requests-per-http2-connection: 321
The httpbin client does not have a configuration for this property. 
I have created a custom bean creation event listener that logs the configuration of the 
httpbin client when it's created. I expected the output logged to contain the *321* value 
for this property (inherited from global http client), but it does not, instead it contains 
the default value of *2147483647*. 

## The output of the application is:

```terminaloutput
 __  __ _                                  _   
|  \/  (_) ___ _ __ ___  _ __   __ _ _   _| |_
| |\/| | |/ __| '__/ _ \| '_ \ / _` | | | | __|
| |  | | | (__| | | (_) | | | | (_| | |_| | |_
|_|  |_|_|\___|_|  \___/|_| |_|\__,_|\__,_|\__|
13:10:06.208 [main] INFO  io.micronaut.runtime.Micronaut - No embedded container found. Running as CLI application
13:10:06.332 [main] INFO  n.v.t.t.c.HttpBinClientCreatedEventListener - ###HttpBinClientCreatedEventListener###Bean of type HttpBinClient has been created!
13:10:06.332 [main] INFO  n.v.t.t.c.HttpBinClientCreatedEventListener - ###Config for 'HttpBinClient':
13:10:06.332 [main] INFO  n.v.t.t.c.HttpBinClientCreatedEventListener - ###  connectTimeout = Optional.empty
13:10:06.332 [main] INFO  n.v.t.t.c.HttpBinClientCreatedEventListener - ###  readTimeout = Optional[PT10S]
13:10:06.333 [main] INFO  n.v.t.t.c.HttpBinClientCreatedEventListener - ###  pool config isEnabled  = true
13:10:06.333 [main] INFO  n.v.t.t.c.HttpBinClientCreatedEventListener - ###  pool config maxConcurrentHttp2Connections  = 1
13:10:06.333 [main] INFO  n.v.t.t.c.HttpBinClientCreatedEventListener - ###  pool config maxConcurrentRequestsPerHttp2Connection  = 2147483647
13:10:06.333 [main] INFO  n.v.t.t.c.HttpBinClientCreatedEventListener - ###  pool config connectionLocality  = PREFERRED
```
