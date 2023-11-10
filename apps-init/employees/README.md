docker build -t employees:0.0.1 .
docker tag employees:0.0.1 registry.w3pro.net/employees:0.0.1
docker push registry.w3pro.net/employees:0.0.1