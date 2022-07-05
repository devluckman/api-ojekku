# HayuJek API

## Base url

```
https://hayujek-api.herokuapp.com
```

## Table endpoints
### HayuJek

| Name                  | Endpoint                    | Method | Auth token   | Body and response                            |
|-----------------------|-----------------------------|--------|--------------|----------------------------------------------|
| Login Customer        | `/v1/api/customer/login`    | `POST` | no           | [example](#hayujek---login-customer)         |
| Register Customer     | `/v1/api/customer/register` | `POST` | no           | [example](#hayujek---register-customer)      |
| Get Customer by name  | `/v1/api/customer/{name}`   | `GET`  | yes          | [example](#hayujek---get-customer-by-name)   |
| Get Customer by token | `/v1/api/customer`          | `GET`  | yes          | [example](#hayujek---get-customer-use-token) |
| Login Driver          | `/v1/api/driver/login`      | `POST` | no           | [example](#hayujek---login-driver)           |
| Register Driver       | `/v1/api/driver/register`   | `POST` | no           | [example](#hayujek---register-driver)        |
| Get Driver by name    | `/v1/api/driver/{name}`     | `GET`  | yes          | [example](#hayujek---get-driver-by-name)     |
| Get Driver by token   | `/v1/api/driver`            | `GET`  | yes          | [example](#hayujek---get-driver-use-token)   |

## Run on localhost
- Run `./gradlew bootRun`

---

### HayuJek - Login Customer

```
POST /v1/api/customer/login
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhMmFlMDAxYi1hM2QwLTRlMTUtOGMxZC00MThlZjRkZDBjMTgiLCJhdXRoIjpbImx1a21hbiJdLCJleHAiOjE2NTcxMDQyMzN9.s66R5gO9NeJC5AtqfVHLmOgShFukaAYlrimxk1Kc0Tc",
    "name": "lukman",
    "role": "customer"
  }
}
```

### HayuJek - Register Customer

```
POST /v1/api/customer/register
```
Request
```json
{
  "username" : "alex",
  "password" : "123456"
}
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": true
}
```

### HayuJek - Get Customer By Name

```
GET /v1/api/customer/:name
HEADER Authorization eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHBpcmVkQXQiOjE2MjI....

```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "id": "a2ae001b-a3d0-4e15-8c1d-418ef4dd0c18",
    "username": "lukman",
    "role": "customer"
  }
}
```

### HayuJek - Get Customer Use Token

```
GET /v1/api/customer
HEADER Authorization eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHBpcmVkQXQiOjE2MjI....
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "id": "a2ae001b-a3d0-4e15-8c1d-418ef4dd0c18",
    "username": "lukman",
    "role": "customer"
  }
}
```

### HayuJek - Login Driver

```
POST /v1/api/driver/login
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhMmFlMDAxYi1hM2QwLTRlMTUtOGMxZC00MThlZjRkZDBjMTgiLCJhdXRoIjpbImx1a21hbiJdLCJleHAiOjE2NTcxMDQyMzN9.s66R5gO9NeJC5AtqfVHLmOgShFukaAYlrimxk1Kc0Tc",
    "name": "lukman",
    "role": "customer"
  }
}
```

### HayuJek - Register Driver

```
POST /v1/api/driver/register
```
Request
```json
{
  "username" : "alex",
  "password" : "123456"
}
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": true
}
```

### HayuJek - Get Driver By Name

```
GET /v1/api/driver/:name
HEADER Authorization eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHBpcmVkQXQiOjE2MjI....

```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "id": "a2ae001b-a3d0-4e15-8c1d-418ef4dd0c18",
    "username": "lukman",
    "role": "driver"
  }
}
```

### HayuJek - Get Driver Use Token

```
GET /v1/api/driver
HEADER Authorization eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHBpcmVkQXQiOjE2MjI....
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "id": "a2ae001b-a3d0-4e15-8c1d-418ef4dd0c18",
    "username": "lukman",
    "role": "driver"
  }
}
```
