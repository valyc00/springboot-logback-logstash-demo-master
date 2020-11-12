# springboot-logback-logstash-demo

spunto da:
https://github.com/CrayfishGo/springboot-logback-logstash-demo


 esempio logstash.conf da usare 

```html
input {
       

        tcp {
                port => 5100
        }
}


filter {
  json {
    source => "message"
  }
  date {
                match => ["mytimestamp", "yyyyMMddHHmmss"]
                timezone => "Europe/Rome"
                target => "@timestamp"
        }
}
output {
        elasticsearch {
                hosts => "elasticsearch:9200"
                user => "elastic"
                password => "changeme"
        }
}
```


