# cqg-vertx-demo
vertx bench

## cmd1
note: you need **maven**

> mvn clean package

## cmd2
> java -Xms4g -Xmx4g -jar cqg-vertx.jar

## cmd3
note: you need **ab** which use "**yum install -y httpd-tools**"

> ab -n 100000 -c 50 -k "localhost:10010/hello"



## result benchmarking

the linux server linux centos7 with 2*6 cpu cores
```
Server Software:        
Server Hostname:        localhost
Server Port:            10010

Document Path:          /hello
Document Length:        19 bytes

Concurrency Level:      10
Time taken for tests:   1.834 seconds
Complete requests:      100000
Failed requests:        0
Write errors:           0
Keep-Alive requests:    100000
Total transferred:      8200000 bytes
HTML transferred:       1900000 bytes
Requests per second:    54529.43 [#/sec] (mean)
Time per request:       0.183 [ms] (mean)
Time per request:       0.018 [ms] (mean, across all concurrent requests)
Transfer rate:          4366.61 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.0      0       0
Processing:     0    0   0.1      0       1
Waiting:        0    0   0.1      0       1
Total:          0    0   0.1      0       1

Percentage of the requests served within a certain time (ms)
  50%      0
  66%      0
  75%      0
  80%      0
  90%      0
  95%      0
  98%      0
  99%      0
 100%      1 (longest request)
```
