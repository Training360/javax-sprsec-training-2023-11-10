docker build -t employees-ui:0.0.1 .
docker tag employees-ui:0.0.1 registry.w3pro.net/employees-ui:0.0.1
docker push registry.w3pro.net/employees-ui:0.0.1