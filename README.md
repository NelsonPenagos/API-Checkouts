# API-Checkouts

A continuación se hace una breve descripción de la arquitectura utilizada y las tecnologias.

# Arquitectura

![alt](https://raw.githubusercontent.com/NelsonPenagos/imagenes/d72e639d88f1f35bd4d234328da643054085ca69/Micros.svg)

>**checkout-eureka-server**: Se encarga de registrar a cada uno de los microservcios (checkout-service, logistic-service, bill-service) 

>**checkout-service**: Es el servicio principal por donde se hacen las peticiones este a su vez entrega un mensaje al **MessageBroker** para la creación de las ordenes

>**logistic-service**: Se encarga de crear y registrar la orden en la BD

>**bill-service**: Se encarga de realizar la suma de todos los productos y registrar la factura

# Tecnologias

- Spring Boot (Permite la construcción de microservicios)
- Spring Jpa (Permite la interacción con la BD)
- Spring Cloud
- Netflix OSS Eureka (Permite el registro de cada uno de los microservicios, facilitando su administración y visualización dentro de la arquitectura)
- Swagger (Documentación)
- RabbitMQ (Message Broker que permite el intercambio de mensajes entre tecnolgias)
- Postgres (Base de datos utilizada)

# Correr las Imagenes

```
docker-compose up --build
```

# Probar en Postman

```
http://127.0.0.1:8090/api/checkout
```

```rest
{
  "date": "2020-06-28T17:27:27.854Z",
  "direction": "Cra Falsa",
  "products": [
    {
      "cost": 99999,
      "id": 2,
      "quantity": 10
    }
  ]
}

```
